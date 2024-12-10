create database sistema_lp;
use sistema_lp;

create table aviao(
	id int auto_increment primary key,
    modelo varchar(50),
    fabricante varchar(50),
    qtdAssentos int,
    anoFabricacao int
);

select * from aviao;
