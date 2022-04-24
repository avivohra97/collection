package com.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        languages.put("java","jvm one");
        languages.put("python","automation");
        languages.put("go","by google");
        System.out.println(languages);
//        keys are unique for maps
        System.out.println(languages.containsKey("java"));
        for(String key:languages.keySet()){
            System.out.println(key+" : "+languages.get(key));
        }
        languages.remove("go");
    }
}
