package org.wso2.carbon.identity.application.mgt.endpoint.exception;

public class EndpointException extends Exception {

    public EndpointException() {
        super();
    }

    public EndpointException(String message) {
        super(message);
    }

    public EndpointException(String message, Throwable cause) {
        super(message, cause);
    }
}
