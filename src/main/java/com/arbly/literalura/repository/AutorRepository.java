package com.arbly.literalura.repository;

import com.arbly.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository <Autor, Long> {

    Optional<Autor> findByNome(String name);

    @Query(value = "select * from liter_autores a where a.ano_nascimento <= ?1 and a.ano_morte >= ?1", nativeQuery = true)
    List<Autor> findAutoresVivos(int ano);

    List<Autor> findByTitulosIdioma(String idioma);
}
