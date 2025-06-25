package com.arbly.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "liter_titulos")
public class Titulo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String idioma;
        private Integer numeroDownloads;
        @ManyToOne
        private Autor autor;

        public Titulo() {}

        public Long getId() {
                return id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getIdioma() {
                return idioma;
        }

        public void setIdioma(String idioma) {
                this.idioma = idioma;
        }

        public Integer getNumeroDownloads() {
                return numeroDownloads;
        }

        public void setNumeroDownloads(Integer numeroDownloads) {
                this.numeroDownloads = numeroDownloads;
        }

        public Autor getAutor() {
                return autor;
        }

        public void setAutor(Autor autor) {
                this.autor = autor;
        }

        @Override
        public String toString() {
                return String.format("%-40s %-30s %-6s %9d",
                        titulo, autor.getNome(), idioma, numeroDownloads);
        }
}
