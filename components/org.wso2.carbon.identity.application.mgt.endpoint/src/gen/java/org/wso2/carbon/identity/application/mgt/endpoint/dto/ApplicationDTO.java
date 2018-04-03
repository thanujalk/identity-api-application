package org.wso2.carbon.identity.application.mgt.endpoint.dto;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ApplicationDTO  {
  
  
  
  private String id = null;
  
  @NotNull
  private String name = null;
  
  
  private String description = null;
  
  
  private AuthenticationParametersDTO authentication = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("authentication")
  public AuthenticationParametersDTO getAuthentication() {
    return authentication;
  }
  public void setAuthentication(AuthenticationParametersDTO authentication) {
    this.authentication = authentication;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationDTO {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  authentication: ").append(authentication).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
