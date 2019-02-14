package com.cursosdedesarrollo.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/mav")
    public ModelAndView sayHello(Model model){
        model.addAttribute("variable","valor");
        model.addAttribute("variable2","valor2");
        return new ModelAndView("modelandview","model",model);
    }

    @GetMapping("/listado")
    public ModelAndView tomaListado(Model model){
        ArrayList<String> listado = new ArrayList<>();
        listado.add("Guijuelo");
        listado.add("Peñaranda de Bracamonte");
        listado.add("Béjar");
        model.addAttribute("listado",listado);
        return new ModelAndView("listado","model",model);
    }

    @GetMapping("/parametro/{id}")
    public String dameParam(@PathVariable String id, Model model){
        model.addAttribute("id",id);
        return "parametro";
    }

    @GetMapping("/playagame")
    public String playGame(
            @RequestParam(name="choice", required=false)
                    String theChoice,
            Model model) {

        if (theChoice == null) {
            return "index";
        }

        String theOutcome = "error";
        if (theChoice.equals("rock")) {
            theOutcome = "tie";
        }
        if (theChoice.equals("paper")) {
            theOutcome = "win";
        }
        if (theChoice.equals("scissors")) {
            theOutcome = "loss";
        }

        model.addAttribute("outcome", theOutcome);
        return "results";

    }
}