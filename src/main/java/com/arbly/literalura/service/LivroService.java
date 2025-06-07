package com.arbly.literalura.service;

import com.arbly.literalura.Author;
import com.arbly.literalura.BookResponse;
import com.arbly.literalura.Livro;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class LivroService {
    Scanner sc = new Scanner(System.in);
    private ConvertsData convertsData = new ConvertsData();

    public void BuscarTituloApi(){
        RequestApi requestApi = new RequestApi();
        System.out.println("Digite o titulo do livro:");
        var input = sc.nextLine();
        System.out.println("Buscando API, aguarde...");
        var result = requestApi.getApi("https://gutendex.com/books/?search=" + input.replace(' ', '+'));

        var data = convertsData.jsonToClass(result, BookResponse.class);

        for ( var book : data.results()){


                //System.out.println(book.title() book.authors().forEach() book.languages().forEach() book.downloadCount());


        }






    }

}
