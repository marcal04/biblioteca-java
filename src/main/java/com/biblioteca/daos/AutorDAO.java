package com.biblioteca.daos;

import com.biblioteca.models.AutorModel;

import java.util.List;

public interface AutorDAO {
      void create(AutorModel autorModel);
        List<AutorModel> buscarAutor();
}
