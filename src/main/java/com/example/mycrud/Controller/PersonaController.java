package com.example.mycrud.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.Model.Persona;
import com.example.mycrud.Service.PersonaDTO;
import com.example.mycrud.Service.PersonaDosDTO;
import com.example.mycrud.Service.PersonaService;


@RestController
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/persona")
	public List<PersonaDTO> listarPersona(){
		return personaService.getPersonas().stream().map(persona->modelMapper.map(persona, PersonaDTO.class)).collect(Collectors.toList());
		//return personaService.getPersonas(); Y cambiar List<Persona>
	}
	
	@PostMapping("/persona")
	public Persona crearPersona(@RequestBody Persona persona) {
		return personaService.crearEditarPersona(persona);
		
	}
	
	@PostMapping("/persona2")
	public ResponseEntity<PersonaDosDTO> createUser(@Valid @RequestBody PersonaDosDTO personaDto){
		
	     Persona personaEntity = modelMapper.map(personaDto, Persona.class);
	     personaEntity = personaService.crearEditarPersona(personaEntity);
	        
		
		return new ResponseEntity<PersonaDosDTO>(modelMapper.map(personaEntity, PersonaDosDTO.class), HttpStatus.CREATED);
	}
	
	@PutMapping("/persona")
	public Persona editarPersona(@RequestBody Persona persona) {
		return personaService.crearEditarPersona(persona);
		
	}
	
	@DeleteMapping("/persona/{id}")
	public void borrarPersona(@PathVariable Long id) {
		personaService.borrarPersona(id);
		
	}
	
	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable Long id) {
		return personaService.getPersonaId(id);
		
	}
	
	@PostMapping("/login")
	public PersonaDTO login(@RequestBody Persona persona) {
		return personaService.login(persona.getUser(), persona.getPassword());
	}

}
