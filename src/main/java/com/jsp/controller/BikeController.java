package com.jsp.controller;

import com.jsp.dao.BikeRepository;
import com.jsp.model.Bike;
import com.jsp.payload.ResponseStructure;
import com.jsp.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    BikeService bikeService;

    @PostMapping
    public Bike save(@RequestBody Bike bike){
        bikeService.save(bike);
        return bike;
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<Bike>> findById(@RequestParam int id){
       Bike b= bikeService.findById(id);
        ResponseStructure<Bike> structure=new ResponseStructure<Bike>();
         structure.setStatusCode(HttpStatus.FOUND.value());
         structure.setMessage("Data Fetched");
         structure.setData(b);

      return  ResponseEntity.status(HttpStatus.FOUND).body(structure);
    }

    @GetMapping("/findall")
    public List<Bike> findAll(){
        return bikeService.findAll();

    }

    @PutMapping
    public Bike update(@RequestBody Bike bike){
        bikeService.update(bike);
        return bike;
    }

    @DeleteMapping
    public String delete(@RequestParam int id){
        bikeService.deleteById(id);
        return "deleted";
    }


}
