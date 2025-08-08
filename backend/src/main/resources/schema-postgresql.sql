CREATE TABLE IF NOT EXISTS filmes(
    id serial PRIMARY KEY,
    titulo VARCHAR(50),
    genero VARCHAR(25),
    descricao VARCHAR(100),
    imagem VARCHAR(500),
    gostei int,
    naoGostei int
);