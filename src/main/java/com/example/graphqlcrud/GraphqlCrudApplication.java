package com.example.graphqlcrud;

import com.example.graphqlcrud.entity.Coffee;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlCrudApplication {

    private final CoffeeRepository repository;

    @Bean@Profile("data")
    public ApplicationRunner runner(){
        return r->{
            Coffee coffee1 = new Coffee("Java", Size.MEDIUM);
            Coffee coffee2 = new Coffee("Latte",Size.LARGE);
            Coffee coffee3 = new Coffee("Cappuccino",Size.REGULAR);

            repository.saveAll(List.of(coffee1,coffee2,coffee3));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlCrudApplication.class, args);
    }

}
