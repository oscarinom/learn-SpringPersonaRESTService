package com.oscarinom.controller;

import com.oscarinom.entity.Persona;
import com.oscarinom.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Collection;

@RestController
@RequestMapping("/personas")
public class PersonaController {

        @Autowired
        private PersonaService personaService;

        @RequestMapping(method = RequestMethod.GET)
        public Collection<Persona> getAllPersonas(){
        return personaService.getAllPersonas();
        }

        @RequestMapping(value ="/{id}", method = RequestMethod.GET)
        public Persona getPersonaById(@PathVariable("id") int id){
            return this.personaService.getPersonaById(id);
        }

        @RequestMapping(value ="/remove/{id}", method = RequestMethod.GET)
        public void removePersonaById(@PathVariable("id") int id){
            this.personaService.removePersonaById(id);
            }
        @RequestMapping(value ="/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
        public void updatePersona(@RequestBody Persona persona){
            personaService.updatePersona(persona);
        }
        @RequestMapping(value ="/insert", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
        public void insertPersona(@RequestBody Persona persona){
            personaService.insertPersona(persona);
        }



}
