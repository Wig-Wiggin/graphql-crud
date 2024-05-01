package com.example.graphqlcrud.service;

import com.example.graphqlcrud.dto.CoffeeRequest;
import com.example.graphqlcrud.dto.CoffeeResponse;
import com.example.graphqlcrud.entity.Coffee;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository repository;

    private CoffeeResponse toDto(Coffee coffee){
        return new CoffeeResponse(coffee.getId(),coffee.getName(),coffee.getSize());
    }

    private Coffee toEntity(CoffeeRequest request){
       return new Coffee(request.name(),request.size());
    }

    private Coffee getCoffee(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No coffee found with given id"));
    }





    public List<CoffeeResponse> findAll(){
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CoffeeResponse findOne(Integer id){
        return toDto(getCoffee(id));
    }



    public CoffeeResponse createCoffee(CoffeeRequest request){
        return toDto(repository.save(toEntity(request)));
    }


    @Transactional
    public CoffeeResponse changeSize(Integer id, Size size){
        Coffee coffee = getCoffee(id);
        coffee.setSize(size);
        return toDto(coffee);
    }

    public CoffeeResponse delete(Integer id){
       Coffee coffee = getCoffee(id);
       repository.deleteById(id);
       return toDto(coffee);
    }
}
