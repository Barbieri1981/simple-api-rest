package com.api.flight.ticket.controller;

import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.service.FlightTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("flight/ticket")
public class FlightTicketController {

    private final FlightTicketService flightTicketService;

    @Autowired
    public FlightTicketController(final FlightTicketService flightTicketService) {
        this.flightTicketService = flightTicketService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates flight tickets")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FlightTicketRsDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public ResponseEntity<FlightTicketRsDTO> createFlightTicket(@RequestBody final FlightTicketRqDTO flightTicketRq) {
        return new ResponseEntity<>(this.flightTicketService.createTicket(flightTicketRq), HttpStatus.OK);
    }

    @GetMapping(value = "{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieves flight ticket by provided id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FlightTicketRsDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public ResponseEntity<FlightTicketRsDTO> retrieveFlightTicket(@PathVariable("ticketId") final long ticketId) {
        return new ResponseEntity<>(this.flightTicketService.retrieveTicket(ticketId), HttpStatus.OK);
    }
}
