package com.collections.SetsAndHashSets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury",88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus",225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new HeavenlyBody("Mars",88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Deimos",1.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Phobos",0.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Earth",365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Moon",27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        System.out.println("Planets");
        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of "+body.getName());
        for(HeavenlyBody moons: body.getSatellites()){
            System.out.println(moons.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet: planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons){
            System.out.println(moon.getName());
        }

        temp = new HeavenlyBody("Mercury",80);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);
        System.out.println("Planets");
        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName()+ " "+planet.getOrbitalPeriod());
        }
        //sets are supposed to be unique but here they are not, because here only referential equal is performed,
        // ie: if both reference point to same then they are equal
        Object o = new Object();
        o.equals(o);
        "temp".equals(o);
    }
}
