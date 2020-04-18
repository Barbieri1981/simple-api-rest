package com.api.flight.ticket.service;

import com.api.flight.ticket.converter.FlightTicketConverter;
import com.api.flight.ticket.converter.FlightTicketRsConverter;
import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.entity.FlightTicket;
import com.api.flight.ticket.repository.FlightTicketRepository;
import com.api.flight.ticket.service.impl.FlightTicketServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FlightTicketServiceTest {

    @InjectMocks
    private FlightTicketServiceImpl flightTicketService;
    @Mock
    private FlightTicketRepository flightTicketRepository;
    @Spy
    private FlightTicketConverter flightTicketConverter;
    @Spy
    private FlightTicketRsConverter flightTicketRsConverter;


    @Before
    public void setup() {
        this.flightTicketService = new FlightTicketServiceImpl(this.flightTicketRepository,
                this.flightTicketConverter,
                this.flightTicketRsConverter);
    }

    @Test
    public void whenCreateFlightTicketIsCalledThenVerifyTheConvertersAndSaveMethodAreExecuted() {
        final FlightTicket flightTicket = retrieveFlightTicket();
        final FlightTicketRqDTO flightTicketRq = createFlightTicketRq();
        Mockito.when(this.flightTicketRepository.save(any(FlightTicket.class))).thenReturn(flightTicket);

        final FlightTicketRsDTO result = this.flightTicketService.createTicket(flightTicketRq);

        assertNotNull(result);
        verify(this.flightTicketConverter).convert(flightTicketRq);
        verify(this.flightTicketRepository).save(any());
        verify(this.flightTicketRsConverter).convert(flightTicket);
    }

    private FlightTicket retrieveFlightTicket() {
        return new FlightTicket();
    }

    private FlightTicketRqDTO createFlightTicketRq() {
        final FlightTicketRqDTO flightTicket = new FlightTicketRqDTO();
        flightTicket.setArrivalDate(new Date());
        flightTicket.setArrivalTime(LocalTime.now());
        flightTicket.setDepartureDate(new Date());
        flightTicket.setDepartureTime(LocalTime.now());

        return flightTicket;
    }
}
