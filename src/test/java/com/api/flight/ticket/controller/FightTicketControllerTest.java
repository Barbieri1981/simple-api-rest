package com.api.flight.ticket.controller;

import com.api.flight.ticket.dto.request.FlightTicketRqDTO;
import com.api.flight.ticket.dto.response.FlightTicketRsDTO;
import com.api.flight.ticket.service.FlightTicketService;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class FightTicketControllerTest {

    @InjectMocks
    private FlightTicketController controller;

    @Mock
    private FlightTicketService service;

    private MockMvc mockMvc;

    private static final Long TICKET_ID = 1l;
    private static final String FORMAT_DATE = "yyyy-MM-dd";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller)
                .build();
    }

    @Test
    public void whenRetrieveFlightTicketIsCalledThenReturnOkStatus() throws Exception {
        when(this.service.retrieveTicket(TICKET_ID)).thenReturn(new FlightTicketRsDTO());

        final ResultActions getResult = this.mockMvc.perform(
                get("/flight/ticket/1").contentType(MediaType.APPLICATION_JSON));

        getResult.andExpect(status().isOk());
    }

    @Test
    public void whenCreateFlightTicketIsCalledThenReturnOkStatus() throws Exception {
        FlightTicketRqDTO flightTicketRq = new FlightTicketRqDTO();
        flightTicketRq.setArrivalDate(parseDate("2020-01-01"));
        flightTicketRq.setDepartureDate(parseDate("2020-01-01"));

        final String request = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create().toJson(flightTicketRq);

        this.mockMvc.perform(post("/flight/ticket")
                .content(request).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private Date parseDate(final String date) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.parse(date);
    }

}
