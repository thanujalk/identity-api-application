/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.application.mgt.endpoint.util;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.application.common.model.ServiceProvider;
import org.wso2.carbon.identity.application.mgt.bridge.ApplicationManagementBridgeService;
import org.wso2.carbon.identity.application.mgt.bridge.model.ExtendedApplicationBasicInfo;
import org.wso2.carbon.identity.application.mgt.bridge.model.ExtendedServiceProvider;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationListItemDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ErrorDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.exception.EndpointClientException;
import org.wso2.carbon.identity.application.mgt.endpoint.exception.EndpointServerException;

import javax.ws.rs.core.Response;

import static org.wso2.carbon.identity.application.mgt.endpoint.util.EndPointConstants.FILE_BASED_APPLICATION_ID;
import static org.wso2.carbon.identity.application.mgt.endpoint.util.EndPointConstants.UNIQUE_ID_PREFIX;
import static org.wso2.carbon.identity.core.util.IdentityUtil.base58Decode;

/**
 * This class provides util methods for the endpoint.
 */
public class EndpointUtils {

    /**
     * Get ApplicationManagementBridgeService backend OSGi service
     *
     * @return ApplicationManagementBridgeService instance
     */
    public static ApplicationManagementBridgeService getApplicationManagementRESTService()
            throws EndpointServerException {

        ApplicationManagementBridgeService service = (ApplicationManagementBridgeService) PrivilegedCarbonContext
                .getThreadLocalCarbonContext().getOSGiService(ApplicationManagementBridgeService.class, null);

        if (service == null) {
            throw new EndpointServerException("Failed to find ApplicationManagementBridgeService.");
        }
        return service;
    }

    public static ServiceProvider getServiceProvider(ApplicationDTO applicationDTO) throws EndpointClientException {

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setApplicationName(applicationDTO.getName());
        serviceProvider.setDescription(applicationDTO.getDescription());

        if (StringUtils.isNotBlank(applicationDTO.getId())) {
            int serviceProviderId = getServiceProviderId(applicationDTO.getId());
            if (FILE_BASED_APPLICATION_ID != serviceProviderId) {
                serviceProvider.setApplicationID(serviceProviderId);
            }
        }
        return serviceProvider;
    }

    public static ApplicationDTO getApplicationDTO(ExtendedServiceProvider serviceProvider) {

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setName(serviceProvider.getApplicationName());
        applicationDTO.setDescription(serviceProvider.getDescription());
        applicationDTO.setId(serviceProvider.getUniqueId());
        return applicationDTO;
    }

    public static ApplicationListItemDTO getApplicationListItemDTO(ExtendedApplicationBasicInfo
                                                                           extendedApplicationBasicInfo) {
        ApplicationListItemDTO applicationListItemDTO = new ApplicationListItemDTO();
        applicationListItemDTO.setId(extendedApplicationBasicInfo.getUniqueId());
        applicationListItemDTO.setName(extendedApplicationBasicInfo.getApplicationName());
        applicationListItemDTO.setDescription(extendedApplicationBasicInfo.getDescription());
        return applicationListItemDTO;
    }

    public static int getServiceProviderId(String applicationId)
            throws EndpointClientException {

        String extractedId = extractedApplicationId(applicationId);
        if (StringUtils.isNumeric(extractedId)) {
            return Integer.valueOf(extractedId);
        }

        return FILE_BASED_APPLICATION_ID;
    }

    public static String extractedApplicationId(String applicationId) throws EndpointClientException {

        String decodedId = new String(base58Decode(applicationId));
        if (StringUtils.isBlank(decodedId) || !decodedId.startsWith(UNIQUE_ID_PREFIX)) {
            throw new EndpointClientException("Invalid application id.");
        }

        // Unique id format is APPLICATION.{application id or application name}
        return decodedId.replaceFirst("^" + UNIQUE_ID_PREFIX, "");
    }

    public static Response getInternalServerErrorResponse() {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(String.valueOf(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()));
        errorDTO.setMessage(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorDTO).build();
    }

    public static Response getBadRequestErrorResponse(Exception e) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
        errorDTO.setMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}
