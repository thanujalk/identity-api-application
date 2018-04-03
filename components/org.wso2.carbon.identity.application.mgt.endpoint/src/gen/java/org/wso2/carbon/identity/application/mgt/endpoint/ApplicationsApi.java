package org.wso2.carbon.identity.application.mgt.endpoint;

import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.ApplicationListItemDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.AuthenticationSequenceDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.OIDCParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.dto.SAML2ParametersDTO;
import org.wso2.carbon.identity.application.mgt.endpoint.factories.ApplicationsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/applications")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/applications", description = "the applications API")
public class ApplicationsApi  {

   private final ApplicationsApiService delegate = ApplicationsApiServiceFactory.getApplicationsApi();

    @DELETE
    @Path("/{applicationId}/authentication/protocols/oidc")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete OIDC authentication protocol parameters\n", notes = "This API provides the capability to delete OIDC authentication protocol parameters of an application.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsOidcDelete(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsOidcDelete(applicationId);
    }
    @GET
    @Path("/{applicationId}/authentication/protocols/oidc")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve OIDC authentication protocol parameters\n", notes = "This API provides the capability to retrieve OIDC authentication protocol parameters of an application.\n", response = OIDCParametersDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsOidcGet(@ApiParam(value = "Id of the application",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsOidcGet(applicationId);
    }
    @PUT
    @Path("/{applicationId}/authentication/protocols/oidc")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update OIDC authentication protocol parameters\n", notes = "This API provides the capability to store OIDC authentication protocol parameters of an application.\n", response = OIDCParametersDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsOidcPut(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId,
    @ApiParam(value = "This represents the OIDC authentication protocol parameters of an application." ,required=true ) OIDCParametersDTO parameters)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsOidcPut(applicationId,parameters);
    }
    @DELETE
    @Path("/{applicationId}/authentication/protocols/saml2")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete SAML2 authentication protocol parameters\n", notes = "This API provides the capability to delete SAML2 authentication protocol parameters of an application.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Delete(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsSaml2Delete(applicationId);
    }
    @GET
    @Path("/{applicationId}/authentication/protocols/saml2")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve SAML2 authentication protocol parameters\n", notes = "This API provides the capability to retrive SAML2 authentication protocol parameters of an application.\n", response = SAML2ParametersDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Get(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsSaml2Get(applicationId);
    }
    @PUT
    @Path("/{applicationId}/authentication/protocols/saml2")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update SAML2 authentication protocol parameters.\n", notes = "This API provides the capability to store SAML2 authentication protocol parameters of an application.\n", response = SAML2ParametersDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationProtocolsSaml2Put(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId,
    @ApiParam(value = "This represents the SAML2 protocol attributes of the application." ,required=true ) SAML2ParametersDTO saml2ProtocolAttributes)
    {
    return delegate.applicationsApplicationIdAuthenticationProtocolsSaml2Put(applicationId,saml2ProtocolAttributes);
    }
    @GET
    @Path("/{applicationId}/authentication/sequence")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve authentication sequence of an application\n", notes = "This API provides the capability to retrive authentication sequence of an application.\n", response = AuthenticationSequenceDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationSequenceGet(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdAuthenticationSequenceGet(applicationId);
    }
    @PUT
    @Path("/{applicationId}/authentication/sequence")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update authentication sequence of an application\n", notes = "This API provides the capability to store authentication sequence of an application.\n", response = AuthenticationSequenceDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdAuthenticationSequencePut(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId,
    @ApiParam(value = "This represents the authnentication sequence of the application." ,required=true ) AuthenticationSequenceDTO identityProviders)
    {
    return delegate.applicationsApplicationIdAuthenticationSequencePut(applicationId,identityProviders);
    }
    @DELETE
    @Path("/{applicationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete an application by id\n", notes = "This API provides the capability to delete an aplication by id.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdDelete(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdDelete(applicationId);
    }
    @GET
    @Path("/{applicationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrive application by id\n", notes = "This API provides the capability to retrive the aplication information by id.\n", response = ApplicationDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdGet(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId)
    {
    return delegate.applicationsApplicationIdGet(applicationId);
    }
    @PUT
    @Path("/{applicationId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an application by id\n", notes = "This API provides the capability to update an application.\n", response = ApplicationDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsApplicationIdPut(@ApiParam(value = "Id of the application.",required=true ) @PathParam("applicationId")  String applicationId,
    @ApiParam(value = "This represents the application to be updated." ,required=true ) ApplicationDTO application)
    {
    return delegate.applicationsApplicationIdPut(applicationId,application);
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List applications\n", notes = "This API provides the capability to retrive the list of applications.\n", response = ApplicationListItemDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsGet(@ApiParam(value = "Number of search results.") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Start index of the search.") @QueryParam("offset")  Integer offset)
    {
    return delegate.applicationsGet(limit,offset);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add application\n", notes = "This API provides the capability to store the application information provided by users.\n", response = ApplicationDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response."),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response applicationsPost(@ApiParam(value = "This represents the application to be created." ,required=true ) ApplicationDTO application)
    {
    return delegate.applicationsPost(application);
    }
}

