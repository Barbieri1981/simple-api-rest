package com.api.flight.ticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FLIGHT_TICKET")
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DEPARTURE_DATE", nullable = false)
    private Date departureDate;

    @Column(name = "ARRIVAL_DATE", nullable = false)
    private Date arrivalDate;

    @Column(name = "ORIGIN_CITY", nullable = false)
    private String originCity;

    @Column(name = "DESTINATION_CITY", nullable = false)
    private String destinationCity;

    @Column(name = "PASSENGER_NAME", nullable = false)
    private String passengerName;

    @Column(name = "PASSENGER_AGE", nullable = false)
    private Long passengerAge;

    @Column(name = "LUGGAGE_STORE", nullable = false)
    private boolean luggageStore;

    @Column(name = "PRICE", nullable = false)
    private double price;

    public FlightTicket() {
    }

    public FlightTicket(Date departureDate, Date arrivalDate, String originCity, String destinationCity, String passengerName, Long passengerAge, boolean luggageStore, double price) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.luggageStore = luggageStore;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
