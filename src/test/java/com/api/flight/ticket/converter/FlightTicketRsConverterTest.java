package com.api.flight.ticket.converter;

import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.entity.FlightTicket;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightTicketRsConverterTest {

    private static final String ORIGIN_CITY = "ORIGIN_CITY";

    @Test
    public void whenFlightTicketRsConverterIsCalledThenReturnDataTransferObject() {
        FlightTicket entity = new FlightTicket();
        entity.setOriginCity(ORIGIN_CITY);
        final FlightTicketRsConverter converter = new FlightTicketRsConverter();

        final FlightTicketRsDTO result = converter.convert(entity);

        assertNotNull(result);
        assertEquals(entity.getOriginCity(), result.getOriginCity());
    }
}
