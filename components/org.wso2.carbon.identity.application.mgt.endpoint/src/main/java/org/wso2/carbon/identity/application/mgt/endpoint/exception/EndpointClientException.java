package org.wso2.carbon.identity.application.mgt.endpoint.exception;

public class EndpointClientException extends EndpointException {

    public EndpointClientException() {
        super();
    }

    public EndpointClientException(String message) {
        super(message);
    }

    public EndpointClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
