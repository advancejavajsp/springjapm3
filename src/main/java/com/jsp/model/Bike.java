package com.jsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Bike {
    @Id
    private int id;
    private String brand;
    private String model;
    private double price;
}
