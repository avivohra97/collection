package com.collections.theatreTwo;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

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
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return seats.get(mid).reserve(); // key found
        }
        return false;  // key not found
    }

    public void getSeat(){
//        Collections.shuffle(seats);
        for (Seat seat:
             seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat>{
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

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
