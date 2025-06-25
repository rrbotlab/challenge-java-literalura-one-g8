package com.arbly.literalura.main;

import com.arbly.literalura.repository.AutorRepository;
import com.arbly.literalura.service.LivroService;

import java.util.Scanner;

import static com.arbly.literalura.main.Ascii.*;

public class LiterMenu {

    private final AutorRepository repository;

    public LiterMenu(AutorRepository repository) {
        this.repository = repository;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        LivroService livroService = new LivroService(repository);

        System.out.println(CLEAR_CONSOLE);
        System.out.println(LOGO);
        System.out.println(ABOUT);

        while (true){
            String menu = """
                    
                    1 - Buscar livro por título (api)
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros cadastrados em determinado idioma
                    9 - Sair""";
            System.out.println(menu);
            System.out.print("\nDigite uma opção: ");
            var input = sc.nextLine();

            if (input.equals("9")) break;

            switch (input){
                case "cl":
                    System.out.println(CLEAR_CONSOLE);
                    System.out.println(LOGO);
                    break;
                case "1":
                    livroService.buscarTituloApi();
                    break;
                case "2":
                    livroService.listarLivros();
                    break;
                case "3":
                    livroService.listarAutores();
                    break;
                case "4":
                    livroService.autoresVivos();
                    break;
                case "5":
                    livroService.livrosIdioma();
                    break;
            }
        }
    }
}
