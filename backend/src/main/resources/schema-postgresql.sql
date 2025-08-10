CREATE TABLE IF NOT EXISTS filmes(
    id serial PRIMARY KEY,
    titulo VARCHAR(50),
    genero VARCHAR(25),
    descricao VARCHAR(100),
    imagem VARCHAR(500),
    gostei int,
    naoGostei int
);

INSERT INTO filmes (titulo, genero, descricao, imagem,gostei,naoGostei)
VALUES
    ('Harry Potter e a Pedra Filosofal', 'Fantasia', 'Um jovem descobre que é um bruxo e inicia sua jornada em Hogwarts.', 'https://images.justwatch.com/poster/243932643/s718/harry-potter-e-a-pedra-filosofal.jpg', 0,0),
    ('Coraline', 'Animação', 'Uma garota descobre um mundo secreto cheio de mistérios.', 'https://images.justwatch.com/poster/304438372/s718/coraline-e-o-mundo-secreto.jpg',0,0),
    ('Stranger Things', 'Ficção Científica', 'Um grupo de amigos enfrenta forças sobrenaturais em uma cidade pequena.', 'https://m.media-amazon.com/images/M/MV5BMjg2NmM0MTEtYWY2Yy00NmFlLTllNTMtMjVkZjEwMGVlNzdjXkEyXkFqcGc@._V1_.jpg',0,0),
    ('Frozen', 'Animação', 'Duas irmãs enfrentam um inverno mágico para salvar seu reino.', 'https://lumiere-a.akamaihd.net/v1/images/hb_frozenanniversaryrefresh_fallback_mobile_2326_v2_f49_77e68f09.jpeg?region=0%2C0%2C640%2C480',0,0),
    ('Suits', 'Drama', 'Um advogado brilhante e seu associado enfrentam casos jurídicos complexos.', 'https://m.media-amazon.com/images/M/MV5BYmE4MmNjZjUtNTEyNy00NTZiLWE4NTktYjM2NjBhYzQ1N2IzXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg',0,0);