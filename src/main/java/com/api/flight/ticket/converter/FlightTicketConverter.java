package com.api.flight.ticket.converter;

import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.entity.FlightTicket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class FlightTicketConverter implements Converter<FlightTicketRqDTO, FlightTicket> {
    @Override
    public FlightTicket convert(FlightTicketRqDTO source) {


        return new FlightTicket(addTimeToDate(source.getDepartureDate(), source.getDepartureTime()),
                addTimeToDate(source.getArrivalDate(), source.getArrivalTime()),
                source.getOriginCity(),
                source.getDestinationCity(),
                source.getPassengerName(),
                source.getPassengerAge(),
                source.isLuggageStore(),
                source.getPrice());
    }

    public Date addTimeToDate(final Date date, final LocalTime time) {
        final Calendar result = Calendar.getInstance();
        result.setTime(date);
        result.set(Calendar.HOUR, time.getHour());
        result.set(Calendar.MINUTE, time.getMinute());
        return result.getTime();
    }
}
