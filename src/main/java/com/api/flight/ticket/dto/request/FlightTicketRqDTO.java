package com.api.flight.ticket.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.Date;

public class FlightTicketRqDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
    private Date departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT-3")
    private LocalTime departureTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
    private Date arrivalDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT-3")
    private LocalTime arrivalTime;
    private String originCity;
    private String destinationCity;
    private String passengerName;
    private Long passengerAge;
    private boolean luggageStore;
    private double price;

    public FlightTicketRqDTO() {
    }

    public FlightTicketRqDTO(Date departureDate, LocalTime departureTime, Date arrivalDate, LocalTime arrivalTime, String originCity, String destinationCity, String passengerName, Long passengerAge, boolean luggageStore, double price) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.luggageStore = luggageStore;
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
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

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "FlightTicketRqDTO{" +
                "departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", luggageStore=" + luggageStore +
                ", price=" + price +
                '}';
    }
}
