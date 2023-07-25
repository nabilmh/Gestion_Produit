package com.example.demo.repository;

import com.example.demo.model.Agence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends CrudRepository<Agence,Integer> {
}
