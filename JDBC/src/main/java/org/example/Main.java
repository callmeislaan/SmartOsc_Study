package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityService();
        PersonService personService = new PersonService();
        List<Integer> cityIds = cityService.getAllCityId();
        List<Integer> populationOfCities = new ArrayList<>();
//        Map<Integer, Integer> populationOfCities = new HashMap<>();
        for (Integer cityId :
                cityIds) {
            populationOfCities.add(personService.getAmountOfPersonsByCityId(cityId));

//            populationOfCities.put(cityId, personService.getAmountOfPersonsByCityId(cityId));
        }
        int maxPopulation = populationOfCities.stream().reduce(Integer::max).orElse(-1);

//        int max = populationOfCities.values().stream().reduce(Integer::max).orElse(-1);

        for (int i = 0; i < populationOfCities.size(); i++) {
            if (populationOfCities.get(i) == maxPopulation) {
                System.out.println(cityService.getCityName(cityIds.get(i)));
            }
        }
    }
}
