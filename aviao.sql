create database sistema_lp_animaisMarinhos;
use sistema_lp_animaisMarinhos;

create table animal(
	id int auto_increment primary key,
    nomeEspecie varchar(50),
    idade int,
    qtdPatas int,
    peso int,
    profundidadeMax int,
    velocidadeMax int
);

select * from animal;
