package com.api.flight.ticket.util;

public enum ErrorType {

    INTERNAL_SERVER_ERROR("flight_ticket_001", "Internal error");

    private final String code;
    private final String description;

    private ErrorType(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
