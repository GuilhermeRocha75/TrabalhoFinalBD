# TrabalhoFinalBD

# NOMES: Guilherme Rocha - Renan Isidoro - Thaylon Santos


## CODIGO MYSQL:
create database trabalhofinalbd;
use trabalhofinalbd;

create table tb_usuarios(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(15)not null
);

insert into tb_usuarios(id_usuario, usuario, login, senha)
values(0, 'administrador', 'admin', 'admin');

select * from tb_usuarios;
