CREATE TABLE medicos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    telefone      VARCHAR(20)  NOT NULL,
    crm           VARCHAR(6)   NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    logradouro    VARCHAR(100) NOT NULL,
    bairro        VARCHAR(100) NOT NULL,
    cep           VARCHAR(9)   NOT NULL,
    complemento   VARCHAR(100),
    numero        VARCHAR(20),
    uf            CHAR(2)      NOT NULL,
    cidade        VARCHAR(100) NOT NULL,
    ativo         TINYINT,
    PRIMARY KEY (id)
);

CREATE TABLE pacientes
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    cpf           VARCHAR(15)  NOT NULL UNIQUE,
    telefone      VARCHAR(20)  NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    logradouro    VARCHAR(100) NOT NULL,
    bairro        VARCHAR(100) NOT NULL,
    cep           VARCHAR(9)   NOT NULL,
    complemento   VARCHAR(100),
    numero        VARCHAR(20),
    uf            CHAR(2)      NOT NULL,
    cidade        VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE consultas
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    medico_id   BIGINT   NOT NULL,
    paciente_id BIGINT   NOT NULL,
    data        DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES medicos (id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);