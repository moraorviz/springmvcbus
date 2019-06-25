package com.bus.business;

import java.util.Vector;

import com.bus.model.City;

public interface CityManagerService {
    public Vector<City> getCities() throws Exception;
}