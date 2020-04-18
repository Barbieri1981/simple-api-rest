package com.api.flight.ticket.converter;

import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.entity.FlightTicket;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightTicketConverterTest {

    private static final String ORIGIN_CITY = "ORIGIN_CITY";

    @Test
    public void whenFlightTicketConverterIsCalledThenReturnEntity() {
        final FlightTicketRqDTO request = new FlightTicketRqDTO();
        request.setOriginCity(ORIGIN_CITY);
        request.setArrivalDate(new Date());
        request.setArrivalTime(LocalTime.now());
        request.setDepartureDate(new Date());
        request.setDepartureTime(LocalTime.now());
        final FlightTicketConverter converter = new FlightTicketConverter();

        final FlightTicket result = converter.convert(request);

        assertNotNull(result);
        assertEquals(request.getOriginCity(), result.getOriginCity());
    }
}
