package com.bus.persistence;

import java.util.Vector;

import com.bus.model.City;

public interface CityDataService {
    public Vector<City> getCities() throws Exception;
}