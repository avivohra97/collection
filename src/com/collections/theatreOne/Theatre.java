package com.collections.theatreOne;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private Collection<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow ; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow;seatNum++){
                Seat seat = new Seat(row + String.format("%02d",seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestSeat = null;
        for(Seat seat : seats){
            if(seat.getSeatNumber().equals(seatNumber)){
                requestSeat = seat;
                break;
            }
        }
        if(requestSeat == null){
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
        return requestSeat.reserve();
    }

    public void getSeat(){
        for (Seat seat:
             seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber){
            this.seatNumber=seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean reserve(){
            if(this.reserved == false){
                this.reserved = true;
                System.out.println("Seat "+ seatNumber+" reserved");
                return  true;
            }
            System.out.println("Seat "+seatNumber+" already reserved, please try another seat. Sorry for inconvenience");
            return  false;
        }

        public  boolean cancel(){
            if(this.reserved){
                this.reserved= false;
                System.out.println("Reservation cancelled for "+seatNumber);
            }
            return false;
        }


    }
}
