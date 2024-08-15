CREATE TABLE Coleta(
    id bigserial not null,
    nome VARCHAR(100) not null,
    cpf VARCHAR(11) not null,
    telefone varchar(11) not null,
    tipoObjetoDescartado varchar(50) not null,
    objetoDescartado varhcar(50) not null,
    responsavelColete varchar(50) not null,
    motivoDescarte varchar(500) null,
    DataHora timestamp not null
);
ALTER TABLE Coleta ADD CONSTRAINT Coleta_pk PRIMARY KEY (id);