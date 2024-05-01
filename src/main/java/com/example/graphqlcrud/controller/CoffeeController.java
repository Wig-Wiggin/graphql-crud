package com.example.graphqlcrud.controller;

import com.example.graphqlcrud.dto.CoffeeRequest;
import com.example.graphqlcrud.dto.CoffeeResponse;

import com.example.graphqlcrud.entity.Coffee;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService service;


    @QueryMapping
    public List<CoffeeResponse> findAll(){
        return service.findAll();
    }


    @QueryMapping
    public CoffeeResponse findOne(@Argument Integer id){
        return service.findOne(id);
    }

    @MutationMapping
    public CoffeeResponse createCoffee(@Argument CoffeeRequest request){
        return service.createCoffee(request);
    }


    @MutationMapping
    public CoffeeResponse changeSize(@Argument  Integer id,@Argument Size size){
        return service.changeSize(id,size);
    }

    @MutationMapping
    public CoffeeResponse delete(@Argument Integer id){
        return service.delete(id);
    }
}
