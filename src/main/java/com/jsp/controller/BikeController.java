package com.jsp.controller;

import com.jsp.dao.BikeRepository;
import com.jsp.model.Bike;
import com.jsp.payload.ResponseStructure;
import com.jsp.service.BikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
@Tag(name = "bike",description = "bicke controller ")
public class BikeController {
    @Autowired
    BikeService bikeService;

    @PostMapping
    public Bike save( @RequestBody  Bike bike){
        bikeService.save(bike);

        return bike;
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<Bike>> findById(@RequestParam  int id){
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

    @GetMapping("/bybrand/{brand}")
    @Operation(summary = "find bike by barnd",description = "find all by using brand name")
    @ApiResponse(responseCode = "201" ,description = "if data is present")
    @ApiResponse(responseCode = "404",description = "when data is not present")
    public ResponseEntity<ResponseStructure<List< Bike>>> findAllBikeByBrand(@Parameter(name = "brand",description = "it will accept brand name") @PathVariable String brand){
        List<Bike> bikes=bikeService.findAllBikeByBrand(brand);
        ResponseStructure<List< Bike>> structure=new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("total bike present is "+ bikes.size());
        structure.setData(bikes);

        return ResponseEntity.status(HttpStatus.OK).body(structure);
    }
}
