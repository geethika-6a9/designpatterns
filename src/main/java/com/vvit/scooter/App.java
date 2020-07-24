package com.vvit.scooter;

import java.util.logging.Logger;

import java.util.logging.Level;

interface scooter {

    public void assemble();
}
class BasicBike implements scooter {

    public void assemble() {
        System.out.print("Basic Bike.");
    }

}

class BikeDecorator implements scooter{

    protected scooter bike;

    public BikeDecorator(scooter c){
        this.bike=c;
    }


    public void assemble() {
        this.bike.assemble();
    }

}
class SportsBike extends BikeDecorator {

    public SportsBike(scooter c) {
        super(c);
    }


    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Bike.");
    }
}
class LuxuryBike extends BikeDecorator {

    public LuxuryBike(scooter c) {
        super(c);
    }


    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Bike.");
    }
}


public class App
{
    private static final Logger l=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main( String[] args )
    {
        l.log(Level.INFO,"use of memento behaviour pattern and decorate structural pattern");
        scooter sportsBike = new SportsBike(new BasicBike());
        scooter lC=new LuxuryBike(new BasicBike());
        sportsBike.assemble();
        lC.assemble();
        System.out.println("\n*****");

        scooter sportsLuxuryBike = new SportsBike(new LuxuryBike(new BasicBike()));
        sportsLuxuryBike.assemble();
        l.log(Level.INFO,"program terminated");

    }
}