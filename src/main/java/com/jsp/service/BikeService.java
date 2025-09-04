package com.jsp.service;

import com.jsp.model.Bike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BikeService {

    Bike save(Bike bike);
    Bike update(Bike bike);
    Bike findById(int id);
    Bike deleteById(int id);
    List<Bike> findAll();

}
