package com.oscarinom.dao;

import com.oscarinom.entity.Persona;

import java.util.Collection;

public interface PersonaDao {
    Collection<Persona> getAllPersonas();

    Persona getPersonaById(int id);

    void removePersonaById(int id);

    void updatePersona(Persona persona);

    void insertPersona(Persona persona);
}
