package com.oscarinom.service;

import com.oscarinom.dao.*;
import com.oscarinom.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class PersonaService {
    @Qualifier("mysql")
    @Autowired
    private PersonaDao personaDao;
    public Collection<Persona> getAllPersonas(){
        return personaDao.getAllPersonas();
    }
    public Persona getPersonaById(int id){
        return this.personaDao.getPersonaById(id);
    }
    public void removePersonaById(int id){
        this.personaDao.removePersonaById(id);
    }
    public void updatePersona(Persona persona){
        this.personaDao.updatePersona(persona);
    }
    public void insertPersona(Persona persona){
        this.personaDao.insertPersona(persona);
    }

}
