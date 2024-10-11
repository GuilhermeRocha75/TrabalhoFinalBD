# TrabalhoFinalBD

## Participantes

<div align="center">
  <table>
    <tr>
      <td align="center">
        <a href="https://github.com/GuilhermeRocha75">
          <img src="https://avatars.githubusercontent.com/u/132854835?v=4" width="75px;" alt="Foto de Guilherme Rocha"/>
          <br />
          <sub><b>Guilherme Rocha</b></sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/RenanIsidoro08">
          <img src="https://avatars.githubusercontent.com/u/170661990?v=4" width="75px;" alt="Foto de Renan Isidoro"/>
          <br />
          <sub><b>Renan Isidoro</b></sub>
        </a>
      </td>
    </tr>
  </table>
</div>


## CODIGO MYSQL:

```sql


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

-- ALterar dados
update tb_usuarios set usuario = '?', login = '?', senha = '?' where id_usuario = '?';

select * from tb_usuarios;

-- TABELA CLIENTES

create table tb_clientes(
id_usuario int primary key,
nome varchar(50) not null,
endereço varchar(50) not null,
telefone varchar(11) not null,
email varchar(50) not null,
CPF_CNPJ varchar(15)not null
);

insert into tb_clientes(id_usuario, nome, endereço, telefone, email, CPF_CNPJ)
values(0, 'administrador', 'admin', '0011112222', 'admin@gmail.com','00000000000');

select * from tb_clientes;
```
