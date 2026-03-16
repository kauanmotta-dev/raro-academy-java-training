CREATE DATABASE Biblioteca_Raro_Academy;


USE Biblioteca_Raro_Academy;


CREATE TABLE Estante (
	numero INT PRIMARY KEY,
    sala VARCHAR(20),
    andar VARCHAR(10)
);

CREATE TABLE Item (
	codigo INT PRIMARY KEY,
    numero_estante INT,
    titulo VARCHAR(30),
    descricao TEXT,
    tipo_item ENUM ('CD', 'DVDs', 'Livro'),
	FOREIGN KEY (numero_estante) REFERENCES Estante(numero)

);

CREATE TABLE Livro (
	codigo_item INT PRIMARY KEY,
    sumario TEXT,
    ano_publicação SMALLINT,
	FOREIGN KEY (codigo_item) REFERENCES Item(codigo)
);

CREATE TABLE Editora_livro (
	editora varchar(50),
    codigo_livro INT,
    PRIMARY KEY (editora, codigo_livro),
    FOREIGN KEY (codigo_livro) REFERENCES Livro(codigo_item)
);

CREATE TABLE Autor_livro (
	autor varchar(50),
    codigo_livro INT,
    PRIMARY KEY (autor, codigo_livro),
    FOREIGN KEY (codigo_livro) REFERENCES Livro(codigo_item)
);


CREATE TABLE CD (
	codigo_item INT PRIMARY KEY,
    nome_produtora VARCHAR(50),
    ano SMALLINT,
	FOREIGN KEY (codigo_item) REFERENCES Item(codigo)

);

CREATE TABLE Musica_CD (
	musica VARCHAR(30),
    codigo_CD INT,
    PRIMARY KEY (musica, codigo_CD),
    FOREIGN KEY (codigo_CD) REFERENCES CD(codigo_item)
);

CREATE TABLE DVD (
	codigo_item INT PRIMARY KEY,
    nome_produtora VARCHAR(50),
    ano SMALLINT,
	FOREIGN KEY (codigo_item) REFERENCES Item(codigo)
);

CREATE TABLE Musica_DVD (
	codigo INT,
    codigo_DVD INT,
    nome VARCHAR(30),
    PRIMARY KEY (codigo, codigo_DVD),
    FOREIGN KEY (codigo_DVD) REFERENCES DVD(codigo_item)
);

CREATE TABLE Funcionario (
	matricula INT,
    codigo INT,
    sexo CHAR(1),
    nome VARCHAR(30),
    turno VARCHAR(50),
    PRIMARY KEY (matricula, codigo)
);

CREATE TABLE Endereco_funcionario (
	endereço VARCHAR (50),
	matricula_funcionario INT,
	codigo_funcionario INT,
    PRIMARY KEY (endereço, matricula_funcionario, codigo_funcionario),
    FOREIGN KEY (matricula_funcionario, codigo_funcionario) REFERENCES Funcionario(matricula, codigo)
);

CREATE TABLE telefone_funcionario (
	telefone CHAR(12),
	matricula_funcionario INT,
	codigo_funcionario INT,
    PRIMARY KEY (telefone, matricula_funcionario, codigo_funcionario),
    FOREIGN KEY (matricula_funcionario, codigo_funcionario) REFERENCES Funcionario(matricula, codigo)
);

CREATE TABLE Associado (
	codigo INT PRIMARY KEY,
    nome VARCHAR (30)
);

CREATE TABLE Endereco_associado (
	endereco VARCHAR(50),
    codigo_associado INT,
    PRIMARY KEY (endereco, codigo_associado),
    FOREIGN KEY (codigo_associado) REFERENCES Associado(codigo)
);

CREATE TABLE Telefone_associado (
	telefone CHAR(12),
    codigo_associado INT,
    PRIMARY KEY (telefone, codigo_associado),
    FOREIGN KEY (codigo_associado) REFERENCES Associado(codigo)
);

CREATE TABLE Fornecedor (
	codigo INT PRIMARY KEY,
    nome VARCHAR(30),
    cidade VARCHAR(20),
    rua VARCHAR(30),
    estado CHAR(2)
);

CREATE TABLE Telefone_fornecedor(
	telefone CHAR(12),
    codigo_fornecedor INT,
    PRIMARY KEY (telefone, codigo_fornecedor),
    FOREIGN KEY (codigo_fornecedor) REFERENCES Fornecedor(codigo)
);

DROP TABLE Emprestimo;

CREATE TABLE Emprestimo(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	codigo_associado INT, 
	codigo_item INT, 
	matricula_funcionario_verificante INT DEFAULT NULL, 
	codigo_funcionario_verificante INT DEFAULT NULL,
    data_hora_verificacao DATETIME DEFAULT NULL,
	data_emprestimo DATE, 
	data_devolucao DATE, 
	FOREIGN KEY (codigo_associado) REFERENCES Associado(codigo),
	FOREIGN KEY (codigo_item) REFERENCES Item(codigo),
	FOREIGN KEY (matricula_funcionario_verificante, codigo_funcionario_verificante) REFERENCES Funcionario(matricula, codigo)
);

CREATE TABLE Responsavel_por (
	matricula_funcionario INT,
	codigo_funcionario INT, 
	numero_estante INT,
    PRIMARY KEY (matricula_funcionario, codigo_funcionario, numero_estante),
    FOREIGN KEY (matricula_funcionario, codigo_funcionario) REFERENCES Funcionario(matricula, codigo),
    FOREIGN KEY (numero_estante) REFERENCES Estante(numero)
);

CREATE TABLE Fornece (
	codigo_fornecedor INT,
    codigo_item INT,
    PRIMARY KEY (codigo_fornecedor, codigo_item),
    FOREIGN KEY (codigo_fornecedor) REFERENCES Fornecedor(codigo),
	FOREIGN KEY (codigo_item) REFERENCES Item(codigo)
);

DELIMITER $$
CREATE PROCEDURE realizar_emprestimo( 
IN p_codigo_associado INT, 
IN p_codigo_item INT, 
IN p_data_emprestimo DATE, 
IN p_data_devolucao DATE
)
BEGIN
	INSERT INTO Emprestimo (
    codigo_associado, 
    codigo_item, 
    data_emprestimo, 
    data_devolucao,
    data_hora_verificacao,
    matricula_funcionario_verificante, 
	codigo_funcionario_verificante
	)
    VALUES (
    p_codigo_associado, 
    p_codigo_item, 
    p_data_emprestimo, 
    p_data_devolucao,
    NULL,
    NULL,
    NULL
	);
END $$
	DELIMITER ;
    
    
    INSERT INTO Associado (codigo, nome) VALUES (1, 'Fulano');
	INSERT INTO Item (codigo, numero_estante) VALUES (1,1);
    INSERT INTO Estante (numero) VALUES (1);