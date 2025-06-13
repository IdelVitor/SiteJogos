-- Desativa validação de chaves estrangeiras para evitar erros na criação
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE IF NOT EXISTS perfil (
    id_perfil INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    acesso TEXT
    );

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email_usuario VARCHAR(150) UNIQUE,
    senha VARCHAR(255),
    cpf VARCHAR(14),
    );

CREATE TABLE IF NOT EXISTS jogos (
    id_status_log INT PRIMARY KEY AUTO_INCREMENT,
    id_empresa INT,
    id_processo INT,
    id_status INT,
    id_usuario INT,
    data_status DATETIME,
    descricao TEXT,
    FOREIGN KEY (id_empresa, id_processo) REFERENCES empresa_processo(id_empresa, id_processo),
    FOREIGN KEY (id_status) REFERENCES status(id_status),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
    );

-- Ativa novamente as validações de chave estrangeira
SET FOREIGN_KEY_CHECKS = 1;