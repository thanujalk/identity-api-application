package org.wso2.carbon.identity.application.mgt.endpoint.dto;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

@ApiModel(description = "")
public class AuthenticationProtocolsDTO  {
  
  
  
  private SAML2ParametersDTO saml2Parameters = null;
  
  
  private OIDCParametersDTO oidcParameters = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("saml2Parameters")
  public SAML2ParametersDTO getSaml2Parameters() {
    return saml2Parameters;
  }
  public void setSaml2Parameters(SAML2ParametersDTO saml2Parameters) {
    this.saml2Parameters = saml2Parameters;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("oidcParameters")
  public OIDCParametersDTO getOidcParameters() {
    return oidcParameters;
  }
  public void setOidcParameters(OIDCParametersDTO oidcParameters) {
    this.oidcParameters = oidcParameters;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationProtocolsDTO {\n");
    
    sb.append("  saml2Parameters: ").append(saml2Parameters).append("\n");
    sb.append("  oidcParameters: ").append(oidcParameters).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
