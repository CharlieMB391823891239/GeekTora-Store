package com.geektora.geektora_api.exceptions;

public class ResourceNotExistsException extends RuntimeException {
    public ResourceNotExistsException(String message) {
        super(message);
    }
}
