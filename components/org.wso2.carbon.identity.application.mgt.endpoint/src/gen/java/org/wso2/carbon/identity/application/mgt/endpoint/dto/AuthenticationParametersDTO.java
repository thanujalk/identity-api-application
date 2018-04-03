package org.wso2.carbon.identity.application.mgt.endpoint.dto;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

@ApiModel(description = "")
public class AuthenticationParametersDTO  {
  
  
  
  private AuthenticationProtocolsDTO protocols = null;
  
  
  private AuthenticationSequenceDTO sequence = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("protocols")
  public AuthenticationProtocolsDTO getProtocols() {
    return protocols;
  }
  public void setProtocols(AuthenticationProtocolsDTO protocols) {
    this.protocols = protocols;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("sequence")
  public AuthenticationSequenceDTO getSequence() {
    return sequence;
  }
  public void setSequence(AuthenticationSequenceDTO sequence) {
    this.sequence = sequence;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationParametersDTO {\n");
    
    sb.append("  protocols: ").append(protocols).append("\n");
    sb.append("  sequence: ").append(sequence).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
