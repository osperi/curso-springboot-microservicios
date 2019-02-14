package com.cursosdedesarrollo.springbootdemo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DatosController {
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
    @RequestMapping(value = "/dato/",method =
            RequestMethod.GET)
    public List<Dato> showDato(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        List<Dato> listado= new ArrayList<Dato>();
        for (int i = 0; i < 10; i++) {
            Dato dato= new Dato();
            dato.setCadena("Mi cadena "+i);
            listado.add(dato);
        }
        return listado;
    }
    @RequestMapping(value = "/dato/",method = RequestMethod.POST)
    public Dato addDato(@RequestBody Dato dato)
            throws ServletException, IOException {
        return dato;
    }
    @RequestMapping(value = "/dato/{id}",method =
            RequestMethod.GET)
    public Dato showDatoById(@PathVariable String id)
            throws ServletException, IOException {
        Dato dato= new Dato();
        dato.setCadena("Mi cadena "+id);
        return dato;
    }
    @RequestMapping(value = "/dato/{id}",method =
            RequestMethod.POST)
    public Dato editDatoById(@PathVariable String
                                     id,@RequestBody Dato dato)
            throws ServletException, IOException {
        return dato;
    }
    @RequestMapping(value = "/dato/{id}",method =
            RequestMethod.DELETE)
    public Dato deleteDatoById(@PathVariable String id)
            throws ServletException, IOException {
        Dato dato= new Dato();
        dato.setCadena("Mi cadena borrada");
        return dato;
    }
}
