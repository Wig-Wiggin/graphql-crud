package com.example.graphqlcrud.repository;

import com.example.graphqlcrud.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Integer> { }
