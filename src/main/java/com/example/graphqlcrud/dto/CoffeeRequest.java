package com.example.graphqlcrud.dto;

import com.example.graphqlcrud.entity.Size;

public record CoffeeRequest(String name, Size size) {
}
