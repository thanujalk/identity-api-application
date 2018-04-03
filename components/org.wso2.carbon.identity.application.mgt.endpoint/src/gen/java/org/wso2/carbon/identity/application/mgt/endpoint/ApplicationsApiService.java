package org.wso2.carbon.identity.application.mgt.endpoint;

import org.wso2.carbon.identity.application.mgt.endpoint.dto.OIDCParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.SAML2ParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.AuthenticationSequenceDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationDTO;

import javax.ws.rs.core.Response;

public abstract class ApplicationsApiService {
    public abstract Response applicationsApplicationIdAuthenticationProtocolsOidcDelete(String applicationId);
    public abstract Response applicationsApplicationIdAuthenticationProtocolsOidcGet(String applicationId);
    public abstract Response applicationsApplicationIdAuthenticationProtocolsOidcPut(String applicationId,OIDCParametersDTO parameters);
    public abstract Response applicationsApplicationIdAuthenticationProtocolsSaml2Delete(String applicationId);
    public abstract Response applicationsApplicationIdAuthenticationProtocolsSaml2Get(String applicationId);
    public abstract Response applicationsApplicationIdAuthenticationProtocolsSaml2Put(String applicationId, SAML2ParametersDTO saml2ProtocolAttributes);
    public abstract Response applicationsApplicationIdAuthenticationSequenceGet(String applicationId);
    public abstract Response applicationsApplicationIdAuthenticationSequencePut(String applicationId,AuthenticationSequenceDTO identityProviders);
    public abstract Response applicationsApplicationIdDelete(String applicationId);
    public abstract Response applicationsApplicationIdGet(String applicationId);
    public abstract Response applicationsApplicationIdPut(String applicationId,ApplicationDTO application);
    public abstract Response applicationsGet(Integer limit,Integer offset);
    public abstract Response applicationsPost(ApplicationDTO application);
}

