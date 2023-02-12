package com.example.project5.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class APIException extends RuntimeException {

    private String message;
}