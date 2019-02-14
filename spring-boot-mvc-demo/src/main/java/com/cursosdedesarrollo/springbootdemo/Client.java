package com.cursosdedesarrollo.springbootdemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client implements Serializable {
    private String id;
    private String name;
    private String password;
    private String email;
    private boolean activo;
    private String token;

}
