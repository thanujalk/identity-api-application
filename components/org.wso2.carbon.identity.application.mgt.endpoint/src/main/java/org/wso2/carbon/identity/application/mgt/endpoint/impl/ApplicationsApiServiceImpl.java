/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
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
package org.wso2.carbon.identity.application.mgt.endpoint.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.ServiceProvider;
import org.wso2.carbon.identity.application.mgt.bridge.ApplicationManagementBridgeService;
import org.wso2.carbon.identity.application.mgt.bridge.exception.ApplicationManagementBridgeClientException;
import org.wso2.carbon.identity.application.mgt.bridge.exception.ApplicationManagementBridgeException;
import org.wso2.carbon.identity.application.mgt.bridge.model.ExtendedApplicationBasicInfo;
import org.wso2.carbon.identity.application.mgt.bridge.model.ExtendedServiceProvider;
import org.wso2.carbon.identity.application.mgt.endpoint.ApiResponseMessage;
import org.wso2.carbon.identity.application.mgt.endpoint.ApplicationsApiService;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationListItemDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.AuthenticationSequenceDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.OIDCParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.SAML2ParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.exception.EndpointClientException;
import org.wso2.carbon.identity.application.mgt.endpoint.exception.EndpointServerException;
import org.wso2.carbon.identity.application.mgt.endpoint.util.EndpointUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.core.Response;

public class ApplicationsApiServiceImpl extends ApplicationsApiService {

    private static final Log LOG = LogFactory.getLog(ApplicationsApiServiceImpl.class);

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsOidcDelete(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Coming Soon!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsOidcGet(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsOidcPut(String applicationId, OIDCParametersDTO
            parameters) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Delete(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Get(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Put(String applicationId, SAML2ParametersDTO
            saml2ProtocolAttributes) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationSequenceGet(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdAuthenticationSequencePut(String applicationId,
                                                                       AuthenticationSequenceDTO identityProviders) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdDelete(String applicationId) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsApplicationIdGet(String applicationId) {

        String extractedApplicationId;
        try {
            extractedApplicationId = EndpointUtils.extractedApplicationId(applicationId);
        } catch (EndpointClientException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Client error occurred.", e);
            }
            return EndpointUtils.getBadRequestErrorResponse(e);
        }

        ApplicationManagementBridgeService service;
        try {
            service = EndpointUtils.getApplicationManagementRESTService();
        } catch (EndpointServerException e) {
            LOG.error("Server error occurred.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        ExtendedServiceProvider serviceProvider;
        try {
            if (StringUtils.isNumeric(extractedApplicationId)) {
                serviceProvider = service.getApplication(Integer.valueOf(extractedApplicationId),
                        "carbon.super", "admin  ");
            } else {
                // This is a file based SP
                throw new RuntimeException("Not implemented!");
            }
        } catch (ApplicationManagementBridgeClientException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Client error occurred.", e);
            }
            return EndpointUtils.getBadRequestErrorResponse(e);
        } catch (ApplicationManagementBridgeException e) {
            LOG.error("Failed to create a service provider.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        ApplicationDTO applicationDTO = EndpointUtils.getApplicationDTO(serviceProvider);
        return Response.ok().entity(applicationDTO).build();
    }

    @Override
    public Response applicationsApplicationIdPut(String applicationId, ApplicationDTO application) {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not implemented!")).build();
    }

    @Override
    public Response applicationsGet(Integer limit, Integer offset) {

        ApplicationManagementBridgeService service;
        try {
            service = EndpointUtils.getApplicationManagementRESTService();
        } catch (EndpointServerException e) {
            LOG.error("Server error occurred.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        List<ExtendedApplicationBasicInfo> extendedApplicationBasicInfos;
        try {
            extendedApplicationBasicInfos = service.getApplications(offset, limit, false, "carbon.super", "admin");
        } catch (ApplicationManagementBridgeClientException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Client error occurred.", e);
            }
            return EndpointUtils.getBadRequestErrorResponse(e);
        } catch (ApplicationManagementBridgeException e) {
            LOG.error("Failed to retrieve list application information.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        if(extendedApplicationBasicInfos.isEmpty()) {
            return Response.ok().entity(Collections.<ApplicationListItemDTO>emptyList()).build();
        }

        List<ApplicationListItemDTO> applicationListItemDTOs = new ArrayList<>();
        for (ExtendedApplicationBasicInfo extendedApplicationBasicInfo :  extendedApplicationBasicInfos) {
            applicationListItemDTOs.add(EndpointUtils.getApplicationListItemDTO(extendedApplicationBasicInfo));
        }

        return Response.ok().entity(applicationListItemDTOs).build();
    }

    @Override
    public Response applicationsPost(ApplicationDTO application) {

        ServiceProvider serviceProvider;
        try {
            serviceProvider = EndpointUtils.getServiceProvider(application);
        } catch (EndpointClientException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Client error occurred.", e);
            }
            return EndpointUtils.getBadRequestErrorResponse(e);
        }

        ApplicationManagementBridgeService service;
        try {
            service = EndpointUtils.getApplicationManagementRESTService();
        } catch (EndpointServerException e) {
            LOG.error("Server error occurred.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        ExtendedServiceProvider createdServiceProvider;
        try {
            createdServiceProvider = service.createApplication(serviceProvider, "carbon.super", "admin");
        } catch (ApplicationManagementBridgeClientException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Client error occurred.", e);
            }
            return EndpointUtils.getBadRequestErrorResponse(e);
        } catch (ApplicationManagementBridgeException e) {
            LOG.error("Failed to create a service provider.", e);
            return EndpointUtils.getInternalServerErrorResponse();
        }

        ApplicationDTO applicationDTO = EndpointUtils.getApplicationDTO(createdServiceProvider);
        return Response.ok().entity(applicationDTO).build();
    }
}
