package com.cursosdedesarrollo.springbootdemo;

import java.io.Serializable;

public class Dato implements Serializable {

    private String cadena;
    public Dato() {
        this.cadena = "";
    }

    public Dato(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return "Dato{" +
                "cadena='" + cadena + '\'' +
                '}';
    }
}
