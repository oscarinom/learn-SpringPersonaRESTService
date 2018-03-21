package com.oscarinom.dao;

import com.oscarinom.entity.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakePersonaDao implements PersonaDao {
    private static Map<Integer, Persona> personas;

    static{
        personas = new HashMap<Integer, Persona>(){
            {
                put(1, new Persona(1,"Oscar","Ortiz"));
                put(2, new Persona(2,"Cristina","Morales"));
                put(3, new Persona(3,"Juan","Perez"));
            }
        };
    }
    @Override
    public Collection<Persona> getAllPersonas(){
        return this.personas.values();
    }

    @Override
    public Persona getPersonaById(int id){
        return this.personas.get(id);
    }
    @Override
    public void removePersonaById(int id){
        this.personas.remove(id);
    }

    @Override
    public void updatePersona(Persona persona){
        Persona s = personas.get(persona.getId());
        s.setNombre(persona.getNombre());
        s.setApellido(persona.getApellido());
        personas.put(persona.getId(), persona);
    }
    @Override
    public void insertPersona(Persona persona){
        this.personas.put(persona.getId(), persona);
    }
}
