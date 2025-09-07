package com.jsp.service.impl;

import com.jsp.dao.BikeRepository;
import com.jsp.exception.UserNotFoundException;
import com.jsp.model.Bike;
import com.jsp.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {
    @Autowired
    BikeRepository bikeRepository;
    @Override
    public Bike save(Bike bike) {
        return bikeRepository.save(bike) ;
    }

    @Override
    public Bike update(Bike bike) {
        return bikeRepository.save(bike) ;
    }

    @Override
    public Bike findById(int id) {
        Optional<Bike> o= bikeRepository.findById(id);
        if(o.isPresent()){
          return  o.get();
        }
        throw new UserNotFoundException("user with id "+id +" is not present");
    }
     //java 8 code
    public Bike findByIds(int id) {
        return bikeRepository
               .findById(id).orElseThrow(()->  new UserNotFoundException("user with id "+id +" is not present"));
    }

    @Override
    public Bike deleteById(int id) {

         bikeRepository.deleteById(id);
         return null;
    }

    @Override
    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    @Override
    public List<Bike> findAllBikeByBrand(String brand) {
        return bikeRepository.findByBrand(brand);
    }


}
