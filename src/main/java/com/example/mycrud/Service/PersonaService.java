package com.example.mycrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mycrud.Model.Persona;
import com.example.mycrud.Repository.IPersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	IPersonaRepository personaRepo;
	
	public Persona crearEditarPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public void borrarPersona(Long id) {
		personaRepo.deleteById(id);
	}
	
	
	public List<Persona> getPersonas(){
		return personaRepo.findAll();
	}
	
	public Persona getPersonaId(Long id) {
		return personaRepo.findById(id).orElse(null);
	}
	
	public PersonaDTO login(String user,String password) {
		Persona persona = personaRepo.findByUserAndPassword(user, password);
		PersonaDTO personaDto = new PersonaDTO(persona.getUbication(), persona.getPosition(), persona.getFullName(), persona.getImage());
		return personaDto;
	}
	
	

}
