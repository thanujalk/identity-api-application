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

package org.wso2.carbon.identity.application.mgt.bridge;

import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.application.common.IdentityApplicationManagementException;
import org.wso2.carbon.identity.application.common.model.ApplicationBasicInfo;
import org.wso2.carbon.identity.application.common.model.ServiceProvider;
import org.wso2.carbon.identity.application.mgt.ApplicationManagementService;
import org.wso2.carbon.identity.application.mgt.bridge.exception.ApplicationManagementBridgeClientException;
import org.wso2.carbon.identity.application.mgt.bridge.exception.ApplicationManagementBridgeException;
import org.wso2.carbon.identity.application.mgt.bridge.internal.ApplicationManagementBridgeServiceDataHolder;
import org.wso2.carbon.identity.application.mgt.bridge.model.ExtendedServiceProvider;
import org.wso2.carbon.user.api.UserStoreException;

import java.util.List;

/**
 * This class wraps the {@link ApplicationManagementService} and provides the backend implementation for the
 * Application Management REST API as an OSGi service.
 */
public class ApplicationManagementBridgeService {

    /**
     * Create service provider.
     *
     * @param serviceProvider service provider
     * @param tenantDomain    tenant domain
     * @param username        username
     * @return created service provider
     * @throws ApplicationManagementBridgeClientException
     */
    public ExtendedServiceProvider createApplication(ServiceProvider serviceProvider, String tenantDomain,
                                                     String username) throws ApplicationManagementBridgeException {

        try {
            startTenantFlow(tenantDomain, username);

            ServiceProvider createdServiceProvider;
            try {
                // Create service provider
                createdServiceProvider = ApplicationManagementBridgeServiceDataHolder.getInstance()
                        .getApplicationManagementService().createApplication(serviceProvider, tenantDomain, username);
            } catch (IdentityApplicationManagementException e) {
                throw new ApplicationManagementBridgeException("Error occurred while creating the application", e);
            }

            return new ExtendedServiceProvider(createdServiceProvider);
        } finally {
            endTenantFlow();
        }
    }

    /**
     * List service providers from given offset to a given limit.
     *
     * @param offset        offset
     * @param limit         limit
     * @param fileBasedApps include file based service providers
     * @param tenantDomain  tenant domain
     * @param username      username
     * @return updated service provider
     * @throws IdentityApplicationManagementException
     */
    public List<ApplicationBasicInfo> getApplications(int offset, int limit, boolean fileBasedApps,
                                                      String tenantDomain, String username)
            throws IdentityApplicationManagementException {

        return null;
    }

    /**
     * Update service provider.
     *
     * @param serviceProvider service provider
     * @param tenantDomain    tenant domain
     * @param username        username
     * @return updated service provider
     * @throws IdentityApplicationManagementException
     */
    public ServiceProvider updateApplication(ServiceProvider serviceProvider, String tenantDomain, String username)
            throws IdentityApplicationManagementException {

        return null;
    }

    /**
     * Get service provider by id
     *
     * @param id           service provider id
     * @param tenantDomain tenant domain
     * @param username     username
     * @return service provider
     * @throws IdentityApplicationManagementException
     */
    public ServiceProvider getApplication(String id, String tenantDomain, String username)
            throws IdentityApplicationManagementException {

        return null;
    }

    /**
     * Delete service provider by id
     *
     * @param id           service provider id
     * @param tenantDomain tenant domain
     * @param username     username
     * @throws IdentityApplicationManagementException
     */
    public void deleteApplication(String id, String tenantDomain, String username)
            throws IdentityApplicationManagementException {

    }

    private void startTenantFlow(String tenantDomain, String username) throws ApplicationManagementBridgeClientException {

        PrivilegedCarbonContext.startTenantFlow();
        PrivilegedCarbonContext privilegedCarbonContext = PrivilegedCarbonContext.getThreadLocalCarbonContext();
        privilegedCarbonContext.setTenantDomain(tenantDomain);
        privilegedCarbonContext.setTenantId(getTenantId(tenantDomain));
        privilegedCarbonContext.setUsername(username);
    }

    private void endTenantFlow() {

        PrivilegedCarbonContext.endTenantFlow();
    }

    private int getTenantId(String tenantDomain) throws ApplicationManagementBridgeClientException {

        try {
            return ApplicationManagementBridgeServiceDataHolder.getInstance().getRealmService()
                    .getTenantManager().getTenantId(tenantDomain);
        } catch (UserStoreException e) {
            throw new ApplicationManagementBridgeClientException("Error when setting tenant domain. ", e);
        }
    }
}
