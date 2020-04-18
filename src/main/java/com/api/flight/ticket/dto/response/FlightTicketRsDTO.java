package com.api.flight.ticket.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FlightTicketRsDTO {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm", timezone = "GMT-3")
    private Date departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm", timezone = "GMT-3")
    private Date arrivalDate;
    private String originCity;
    private String destinationCity;
    private String passengerName;
    private Long passengerAge;
    private boolean luggageStore;
    private double price;

    public FlightTicketRsDTO() {
    }

    public FlightTicketRsDTO(Long id, Date departureDate, Date arrivalDate, String originCity, String destinationCity, String passengerName, Long passengerAge, boolean luggageStore, double price) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.luggageStore = luggageStore;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Long passengerAge) {
        this.passengerAge = passengerAge;
    }

    public boolean isLuggageStore() {
        return luggageStore;
    }

    public void setLuggageStore(boolean luggageStore) {
        this.luggageStore = luggageStore;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
