package com.arbly.literalura;

import com.arbly.literalura.service.LivroService;

import java.util.Scanner;

public class LiterMenu {
    private String menu = """
                    1 - Buscar livro por título (api)
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros cadastrados em determinado idioma
                    9 - Sair""";

    public void start() {
        Scanner sc = new Scanner(System.in);
        LivroService livroService = new LivroService();

        while (true){
            System.out.println(menu);
            var input = sc.nextLine();

            if (input.equals("9")) break;

            switch (input){
                case "1":
                    livroService.BuscarTituloApi();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
            }
        }
    }
}
