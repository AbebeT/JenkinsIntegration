package com.example.tdd.controller;

import com.example.tdd.model.Car;
import com.example.tdd.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.assertj.core.api.BDDAssumptions.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CarController.class)
public class CarControllerTest {


    @MockBean
    CarService carService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getCarByName() throws Exception{

        given(carService.getCarByName(Mockito.anyString()))
                .willReturn(new Car("Scala","Sadan"));

               mockMvc.perform(MockMvcRequestBuilders
                .get("/cars/Scala"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("name").value("Scala"))
                .andExpect(jsonPath("type").value("Sadan"));;
    }
}
