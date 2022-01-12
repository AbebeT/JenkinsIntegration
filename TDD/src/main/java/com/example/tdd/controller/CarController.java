package com.example.tdd.controller;


import com.example.tdd.model.Car;
import com.example.tdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cars/")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/{name}")
    public ResponseEntity<Car> getCarByName(@PathVariable String name) throws Exception{
        Car car = carService.getCarByName(name);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }


}
