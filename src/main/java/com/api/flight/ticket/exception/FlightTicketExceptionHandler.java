package com.api.flight.ticket.exception;

import com.api.flight.ticket.dto.response.ErrorRsDTO;
import com.api.flight.ticket.util.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FlightTicketExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightTicketExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRsDTO> retrieveError(final Exception e, final WebRequest request) {
        return new ResponseEntity<>(createError(e, ErrorType.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorRsDTO createError(final Exception e, final ErrorType errorType) {
        LOGGER.error("Error:{} ", errorType);
        return new ErrorRsDTO(errorType.getCode(), e.getMessage(), errorType.getDescription());
    }
}
