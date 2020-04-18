package com.api.flight.ticket.service.impl;

import com.api.flight.ticket.converter.FlightTicketConverter;
import com.api.flight.ticket.converter.FlightTicketRsConverter;
import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.entity.FlightTicket;
import com.api.flight.ticket.repository.FlightTicketRepository;
import com.api.flight.ticket.service.FlightTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightTicketServiceImpl implements FlightTicketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightTicketServiceImpl.class);
    private final FlightTicketRepository flightTicketRepository;
    private final FlightTicketConverter flightTicketConverter;
    private final FlightTicketRsConverter flightTicketRsConverter;

    @Autowired
    public FlightTicketServiceImpl(final FlightTicketRepository flightTicketRepository,
                                   final FlightTicketConverter flightTicketConverter,
                                   final FlightTicketRsConverter flightTicketRsConverter){
        this.flightTicketRepository = flightTicketRepository;
        this.flightTicketConverter = flightTicketConverter;
        this.flightTicketRsConverter = flightTicketRsConverter;
    }

    @Override
    public FlightTicketRsDTO createTicket(FlightTicketRqDTO flightTicketRq) {
        LOGGER.info("Creating a flight ticket {}", flightTicketRq);
        final FlightTicket flightTicket = this.flightTicketConverter.convert(flightTicketRq);
        return flightTicketRsConverter.convert(this.flightTicketRepository.save(flightTicket));
    }

    @Override
    public FlightTicketRsDTO retrieveTicket(long ticketId) {
        LOGGER.info("Retrieving ticket by id {}", ticketId);
        Optional<FlightTicket> ticket = this.flightTicketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            return flightTicketRsConverter.convert(ticket.get());
        }
        return new FlightTicketRsDTO();
    }
}
