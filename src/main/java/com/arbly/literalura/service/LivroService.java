package com.arbly.literalura.service;

import com.arbly.literalura.model.Autor;
import com.arbly.literalura.repository.AutorRepository;
import com.arbly.literalura.model.BookResponse;
import com.arbly.literalura.model.Titulo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LivroService {

    private AutorRepository repo;
    Scanner sc = new Scanner(System.in);
    private ConvertsData convertsData = new ConvertsData();

    public LivroService(AutorRepository repo) {
        this.repo = repo;
    }

    public void buscarTituloApi(){
        RequestApi requestApi = new RequestApi();
        System.out.print("Digite o titulo do livro: ");
        var input = sc.nextLine();
        System.out.println("Buscando API, aguarde...");
        var apiResult = requestApi.getApi("https://gutendex.com/books/?search=" + input.replace(' ', '+'));

        var data = convertsData.jsonToClass(apiResult, BookResponse.class);
        if (data.count() == 0) {
            System.out.println("\n>>> Não encontrado\n");
            return;
        }

        System.out.println("\nTITULO                                   AUTOR                          IDIOMA DOWNLOADS");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-40s %-30s %-6s %9d\n\n",
                data.books().get(0).title(),
                data.books().get(0).authors().get(0).name(),
                data.books().get(0).languages().get(0),
                data.books().get(0).downloadCount());

        System.out.print("Incluir no banco de dados? (s/N) ");
        input = sc.nextLine();
        if (!input.equals("s")) {
            System.out.println("\n>>> Não incluído.");
            return;
        }

        System.out.println("\n>>> Incluindo no DB...");

        var autorResult = repo.findByNome(data.books().get(0).authors().get(0).name());
        // se autor já cadastrado, inclui o título caso não exista
        if (autorResult.isPresent()){
            var titulo = new Titulo();

            for (Titulo t : autorResult.get().getTitulos()) {
                if (t.getTitulo().equals(data.books().get(0).title())) {
                    System.out.println("\n>>> Titulo já cadastrado para esse autor");
                    return;
                }
            }

            titulo.setTitulo(data.books().get(0).title());
            titulo.setIdioma(data.books().get(0).languages().get(0));
            titulo.setNumeroDownloads(data.books().get(0).downloadCount());
            titulo.setAutor(autorResult.get());

            autorResult.get().getTitulos().add(titulo);

            repo.save(autorResult.get());
        }else {
            // Se autor não existe no db, salva autor e inclui titulo
            var autor = new Autor();
            var titulo = new Titulo();
            autor.setNome(data.books().get(0).authors().get(0).name());
            autor.setAnoNascimento(data.books().get(0).authors().get(0).birthYear());
            autor.setAnoMorte(data.books().get(0).authors().get(0).deathYear());

            titulo.setTitulo(data.books().get(0).title());
            titulo.setIdioma(data.books().get(0).languages().get(0));
            titulo.setNumeroDownloads(data.books().get(0).downloadCount());
            titulo.setAutor(autor);

            autor.getTitulos().add(titulo);

            repo.save(autor);
        }
    }

    public void listarLivros() {
        List<Autor> autores = repo.findAll();
        System.out.println("\nTITULO                                   AUTOR                          IDIOMA DOWNLOADS");
        System.out.println("----------------------------------------------------------------------------------------");
        autores.forEach(a -> a.getTitulos().forEach(System.out::println));
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public void listarAutores() {
        List<Autor> autores = repo.findAll();
        System.out.println("\nAUTOR                                    NASC MORTE TITULOS");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        autores.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    public void autoresVivos(){
        System.out.print("Digite o ano para consulta: ");
        var input = sc.nextLine();
        try {
            List<Autor> autores = repo.findAutoresVivos(Integer.parseInt(input));
            System.out.println("\nAUTOR                                    NASC MORTE TITULOS");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            autores.forEach(System.out::println);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }catch (NumberFormatException ignored){
            System.out.println("\n>>> Ano inválido");
        }
    }

    public void livrosIdioma(){
        System.out.println("https://pt.wikipedia.org/wiki/ISO_639");
        System.out.print("Digite o código ISO 639-1 do idioma para consulta (Ex: pt, en, it, etc.): ");
        var input = sc.nextLine();
        List<Autor> autores = repo.findByTitulosIdioma(input);
        System.out.println("\nTITULO                                   AUTOR                          IDIOMA DOWNLOADS");
        System.out.println("----------------------------------------------------------------------------------------");
        autores.forEach(a -> a.getTitulos().forEach(System.out::println));
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
