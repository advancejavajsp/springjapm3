package com.jsp.dao;

import com.jsp.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {

    @Query("select b from Bike b where b.brand=?1")
    public List<Bike> findBikeByBrand(String brand);

    public List<Bike> findByBrand(String brand);
    /*
    findByPriceGreaterthan
    findByPriceAndModel
     */
}
