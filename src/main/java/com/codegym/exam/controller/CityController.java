package com.codegym.exam.controller;

import com.codegym.exam.model.City;
import com.codegym.exam.model.Country;
import com.codegym.exam.service.ICityService;
import com.codegym.exam.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> getAllCountry(){
        return countryService.findAll();
    }

    @GetMapping
    public ModelAndView findAll(){
        return new ModelAndView("index","cities",cityService.findAll());
    }

    @GetMapping("detail/{id}")
    public ModelAndView cityDetail(@PathVariable("id") Long id){
        return new ModelAndView("detail","city",cityService.findById(id).get());
    }

    @GetMapping("create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","city",new City());
    }

    @PostMapping("create")
    public ModelAndView getCreate(@Valid @ModelAttribute("city") City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create","city",city);
        }
        cityService.save(city);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        return new ModelAndView("edit","city",cityService.findById(id).get());
    }

    @PostMapping("edit/{id}")
    public ModelAndView getEdit(@ModelAttribute("city") City city){
        cityService.save(city);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        return new ModelAndView("delete","city",cityService.findById(id).get());
    }

    @GetMapping("delete/{id}/confirm")
    public ModelAndView getDelete(@PathVariable("id") Long id){
        cityService.delete(id);
        return new ModelAndView("redirect:/");
    }
}
