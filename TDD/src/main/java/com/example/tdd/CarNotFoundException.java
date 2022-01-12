package com.example.tdd;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code= HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class CarNotFoundException extends Exception{
}
