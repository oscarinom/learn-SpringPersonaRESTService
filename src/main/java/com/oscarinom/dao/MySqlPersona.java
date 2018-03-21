package com.oscarinom.dao;

import com.oscarinom.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository("mysql")
public class MySqlPersona implements PersonaDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class PersonaRowMapper implements RowMapper<Persona>{

        @Override
        public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
            Persona persona = new Persona();
            persona.setId(resultSet.getInt("id"));
            persona.setNombre(resultSet.getString("nombre"));
            persona.setApellido(resultSet.getString("apellido"));
            return persona;
        }
    }

    @Override
    public Collection<Persona> getAllPersonas() {
        final String query = "SELECT id,nombre,apellido FROM personas";
        Collection<Persona> personas = jdbcTemplate.query(query, new PersonaRowMapper());
        return personas;
    }

    @Override
    public Persona getPersonaById(int id) {
        final String query = "SELECT id,nombre,apellido FROM personas WHERE id = ?";
        jdbcTemplate.queryForObject(query, new PersonaRowMapper(), id);
        return null;
    }

    @Override
    public void removePersonaById(int id) {
        final String query = "DELETE FROM personas WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void updatePersona(Persona persona) {
        final String query = "UPDATE personas SET nombre = ?, apellido = ? WHERE id = ?";
        int id = persona.getId();
        String nombre = persona.getNombre();
        String apellido = persona.getApellido();
        jdbcTemplate.update(query, new Object[] {nombre, apellido, id});
    }

    @Override
    public void insertPersona(Persona persona) {
        final String query = "INSERT INTO personas(nombre,apellido) VALUES(?,?)";
        final String nombre = persona.getNombre();
        final String apellido = persona.getApellido();
        jdbcTemplate.update(query, new Object[]{nombre,apellido});

    }
}
