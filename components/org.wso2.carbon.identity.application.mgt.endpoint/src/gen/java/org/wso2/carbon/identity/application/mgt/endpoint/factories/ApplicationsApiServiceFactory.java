package org.wso2.carbon.identity.application.mgt.endpoint.factories;

import org.wso2.carbon.identity.application.mgt.endpoint.ApplicationsApiService;
import org.wso2.carbon.identity.application.mgt.endpoint.impl.ApplicationsApiServiceImpl;

public class ApplicationsApiServiceFactory {

   private final static ApplicationsApiService service = new ApplicationsApiServiceImpl();

   public static ApplicationsApiService getApplicationsApi()
   {
      return service;
   }
}
