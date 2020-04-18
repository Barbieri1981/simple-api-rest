package com.api.flight.ticket.service;

import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.dto.response.FlightTicketRsDTO;

public interface FlightTicketService {

    FlightTicketRsDTO createTicket(final FlightTicketRqDTO flightTicketRq);

    FlightTicketRsDTO retrieveTicket(final long ticketId);
}
