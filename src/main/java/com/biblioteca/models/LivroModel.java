package com.biblioteca.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LivroModel {
    private int id;
    private String titulo;
    private int ano;
    private boolean disponivel;
    private int autorId;
}
