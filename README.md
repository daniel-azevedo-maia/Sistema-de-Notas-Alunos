# Aluno Boletim Swing App

Este é um projeto de cadastro e gerenciamento de alunos e suas disciplinas, desenvolvido em Java utilizando a biblioteca Swing para a interface gráfica. O sistema permite cadastrar alunos, associar disciplinas e notas, gerar relatórios e armazenar as informações em um banco de dados MySQL.

## Funcionalidades

- Cadastro de alunos com informações básicas, como:
  - Nome
  - CPF
  - Matrícula
  - Série
  - Turno
  - Turma
- Cadastro de disciplinas e notas associadas a cada aluno.
- Geração de relatórios em formato de texto.
- Registro dos dados no banco de dados MySQL.
- Consulta e visualização de boletins.

## Pré-requisitos

Certifique-se de que os seguintes softwares estão instalados no seu sistema:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (já incluso no projeto)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou qualquer IDE Java de sua preferência.

## Configuração do Banco de Dados

1. Crie um banco de dados no MySQL para o projeto. Exemplo:
   ```sql
   CREATE DATABASE aluno_boletim;

2. Crie as tabelas necessárias no banco de dados. Exemplo:
   ```sql
   CREATE TABLE Aluno (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Chave primária, gerada automaticamente
    nome VARCHAR(100) NOT NULL,        -- Nome do aluno (até 100 caracteres)
    cpf CHAR(11) NOT NULL UNIQUE,      -- CPF (11 caracteres, sem formatação)
    matricula VARCHAR(20) NOT NULL UNIQUE, -- Matrícula única
    sexo ENUM('Masculino', 'Feminino') NOT NULL, -- Sexo, com valores pré-definidos
    serie ENUM('1º ano', '2º ano', '3º ano') NOT NULL, -- Série do aluno
    turno ENUM('Manhã', 'Tarde') NOT NULL, -- Turno do aluno
    turma CHAR(1) NOT NULL,            -- Turma (letra única)
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Data de cadastro automática
   );

3. Atualize o arquivo Conexao.java com as informações do seu banco de dados:
   ```sql
   private static final String URL = "jdbc:mysql://localhost:3306/aluno_boletim";
   private static final String USER = "seu_usuario";
   private static final String PASSWORD = "sua_senha";


