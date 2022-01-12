package com.example.tdd.model;

import lombok.*;
import org.hibernate.annotations.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.Id;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    @Generated
    private Long id;

    private String name;
    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
