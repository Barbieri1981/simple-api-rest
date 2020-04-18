package com.api.flight.ticket.converter;

import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.entity.FlightTicket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FlightTicketRsConverter implements Converter<FlightTicket, FlightTicketRsDTO> {

    @Override
    public FlightTicketRsDTO convert(FlightTicket source) {
        return new FlightTicketRsDTO(source.getId(),
                source.getDepartureDate(),
                source.getArrivalDate(),
                source.getOriginCity(),
                source.getDestinationCity(),
                source.getPassengerName(),
                source.getPassengerAge(),
                source.isLuggageStore(),
                source.getPrice());
    }
}
