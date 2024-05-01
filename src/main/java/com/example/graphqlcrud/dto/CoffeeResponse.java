package com.example.graphqlcrud.dto;

import com.example.graphqlcrud.entity.Size;
import lombok.Getter;


public record CoffeeResponse(Integer id, String name, Size size) {
}
