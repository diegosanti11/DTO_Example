package com.example.mycrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.Model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{

	Persona findByUserAndPassword(String user,String password);
}
