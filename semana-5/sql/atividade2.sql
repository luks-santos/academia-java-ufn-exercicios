--1
CREATE TABLE tb_leitores (
    leitor_id SERIAL PRIMARY KEY,
    leitor_nome VARCHAR(100),
    leitor_endereco VARCHAR(255),
    leitor_telefone VARCHAR(15)
);

CREATE TABLE tb_livros (
    livro_id SERIAL PRIMARY KEY,
    livro_titulo VARCHAR(255),
    livro_autor VARCHAR(100),
    ano_publicacao DATE,
    isbn VARCHAR(13)
);

CREATE TABLE tb_emprestimo (
    emprestimo_id SERIAL PRIMARY KEY ,
    leitor_id INT,
    livro_id INT,
    
    FOREIGN KEY (leitor_id) REFERENCES tb_leitores(leitor_id),
    FOREIGN KEY (livro_id) REFERENCES tb_livros(livro_id)
);


--2
CREATE TABLE tb_professores (
    professor_id SERIAL PRIMARY KEY,
    professor_nome VARCHAR(100),
    area_especializacao VARCHAR(100),
    codigo_identificacao INT
);

CREATE TABLE tb_alunos (
    aluno_id SERIAL PRIMARY KEY,
    aluno_nome VARCHAR(100),
    data_nascimento DATE,
    numero_matricula VARCHAR(20) UNIQUE,
    professor_id INT,
    
    FOREIGN KEY (professor_id) REFERENCES tb_professores(professor_id)
);


--3
CREATE TABLE tb_produtos (
    produto_id SERIAL PRIMARY KEY,
    produto_nome VARCHAR(255),
    preco NUMERIC(10, 2),
    codigo_barras VARCHAR(13)
);

CREATE TABLE tb_clientes (
    cliente_id SERIAL PRIMARY KEY,
    cliente_nome VARCHAR(100),
    email VARCHAR(255),
    cpf VARCHAR(11) UNIQUE
);

CREATE TABLE tb_compras (
    compra_id SERIAL PRIMARY KEY,
    cliente_id INT,
    produto_id INT,
    
    FOREIGN KEY (cliente_id) REFERENCES tb_clientes(cliente_id),
    FOREIGN KEY (produto_id) REFERENCES tb_produtos(produto_id)
);

--4
CREATE TABLE tb_filmes (
    filme_id SERIAL PRIMARY KEY,
    filme_titulo VARCHAR(255),
    diretor VARCHAR(100),
    genero VARCHAR(50)
);

CREATE TABLE tb_membros (
    membro_id SERIAL PRIMARY KEY,
    membro_nome VARCHAR(100)
);

CREATE TABLE tb_visualizacoes (
    visualizacao_id SERIAL PRIMARY KEY,
    membro_id INT,
    filme_id INT,
   
    FOREIGN KEY (membro_id) REFERENCES tb_membros(membro_id),
    FOREIGN KEY (filme_id) REFERENCES tb_filmes(filme_id)
);


