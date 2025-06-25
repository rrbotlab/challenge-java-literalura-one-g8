![GitHub License](https://img.shields.io/github/license/rrbotlab/challenge-java-literalura-one-g8)
![GitHub commit activity](https://img.shields.io/github/commit-activity/t/rrbotlab/challenge-java-literalura-one-g8)
![GitHub last commit](https://img.shields.io/github/last-commit/rrbotlab/challenge-java-literalura-one-g8)


# Challenge Literalura

![capa](/assets/images/capa.png)

## Alura Latam & Oracle Next Education - ONE - G8

Desafio proposto no curso Java da Alura Latam em parceria com a
Oracle Next Education - ONE. Grupo G8 (2025).

## Objetivo

Desenvolver um aplicativo em Java com _interface_ via terminal para consulta de livros. Para isso
consumindo uma API externa [Gutendex](https://gutendex.com/) e posteriomente armazenando os dados 
em um banco de dados relacional. No caso foi utilizado o Postgres em nuvem [Neon](https://neon.com/).

## Tecnologias utilizadas

* Java SDK 21
* SpringBoot 3.5.0
* Maven
* Postgres 

## Screenshoots

![screen1](/assets/images/literalura-scr1.png)
![screen1](/assets/images/literalura-scr2.png)


## Dependências

Todas as dependencias são gerenciadas pelo Maven.

## Variáveis de ambiente

O arquivo _application.properties_ utiliza variáveis de ambiente que precisam ser setadas com os dados do DB.
Substitua os valores conforme os dados da instância.

Windows PowerShell:
```
$env:LITERALURA_DATASOURCE="jdbc:postgresql://servidor-db/nome-db"
$env:LITERALURA_USERNAME="NOME_DE_USUARIO"
$env:LITERALURA_PASSWORD="SENHA"
```

Linux:
```
export LITERALURA_DATASOURCE="jdbc:postgresql://servidor-db/nome-db"
export LITERALURA_USERNAME="NOME_DE_USUARIO"
export LITERALURA_PASSWORD="SENHA"
```

