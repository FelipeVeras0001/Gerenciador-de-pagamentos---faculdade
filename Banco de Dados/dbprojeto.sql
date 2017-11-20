-- Criando banco de dados para gerenciamento de pagamentos

create database dbprojeto;

use dbprojeto;

-- criando tabela de Fornecedores

CREATE TABLE Fornecedores (
idforn INT PRIMARY KEY auto_increment,
razao VARCHAR(100),
CNPJ VARCHAR(20),
telefone VARCHAR(20),
celular VARCHAR(20) NOT NULL,
email VARCHAR(50),
endereco VARCHAR(100),
bairro VARCHAR(100) NOT NULL,
complemento VARCHAR(100) NOT NULL,
UF VARCHAR(20) NOT NULL,
cidade VARCHAR(100) NOT NULL,
CEP VARCHAR(20)
);


-- criando tabela para Contas a Pagar

CREATE TABLE ContasPagar (
idpagar INT PRIMARY KEY auto_increment,
idforn INT NOT NULL,
razao VARCHAR (100) NOT NULL,
emissao VARCHAR(100) NOT NULL,
vencimento VARCHAR(100) NOT NULL,
doc VARCHAR(200)NOT NULL,
descricao VARCHAR(100) NOT NULL,
valorParcela DECIMAL (10,2) NOT NULL,
desconto DECIMAL(10,2) NOT NULL,
dias INT NOT NULL,
juros DECIMAL(10,2) NOT NULL,
valorTotal DECIMAL (10,2) NOT NULL,
situacao VARCHAR(100) NOT NULL,
FOREIGN KEY(idforn) REFERENCES Fornecedores (idforn)
);

-- Criando tabela para Alunos

CREATE TABLE Alunos (
idMatricula INT PRIMARY KEY auto_increment,
nome VARCHAR(50) NOT NULL,
cpf VARCHAR(20) NOT NULL,
rg VARCHAR(20) NOT NULL, 
sexo VARCHAR(20) NOT NULL,
dataMatricula VARCHAR (20) NOT NULL,
dataNasc VARCHAR (20) NOT NULL,
telefone VARCHAR(20) NOT NULL,
celular VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
endereco VARCHAR(50)NOT NULL,
bairro VARCHAR(100) NOT NULL,
complemento VARCHAR(50) NOT NULL,
UF VARCHAR(20) NOT NULL,
cidade VARCHAR(50) NOT NULL,
CEP VARCHAR(20) NOT NULL
);

-- Criando tabela para Contas a Receber

CREATE TABLE ContasReceber (
idreceber INT PRIMARY KEY auto_increment,
matricula INT NOT NULL,
nome VARCHAR (100) NOT NULL,
emissao VARCHAR(100) NOT NULL,
vencimento VARCHAR(100) NOT NULL,
parcela INT NOT NULL,
descricao VARCHAR(100) NOT NULL,
valorParcela DECIMAL (10,2) NOT NULL,
desconto DECIMAL(10,2) NOT NULL,
dias INT NOT NULL,
juros DECIMAL(10,2) NOT NULL,
valorTotal DECIMAL (10,2) NOT NULL,
situacao VARCHAR(100) NOT NULL,
FOREIGN KEY(matricula ) REFERENCES ALunos (idMatricula )
);

-- descrever tabelas

describe Fornecedores;

describe ContasPagar;

describe Alunos;

describe ContasReceber;

-- Selecionar tabelas

select*from Fornecedores;

select*from ContasPagar;

select*from Alunos;

select*from ContasReceber;

-- selecionado alguns dados de cada tabela principal
select idforn as ID,razao as Razao, CNPJ as CNPJ, telefone as Telefone from Fornecedores where razao like '%';

select idMatricula as ID,nome as Nome, cpf as CPF, telefone as Telefone from Alunos where nome like '%';

select idreceber as ID,nome as Nome, vencimento as Vencimento, valorTotal as Valor, situacao as Situacao from contasreceber where nome like '%';

select idpagar as ID,razao as Razao, vencimento as Vencimento, valorTotal as Valor, situacao as Situacao from contaspagar where razao like '%';


-- Fazendo as inserções na tabela Fornecedores

insert into Fornecedores(razao,CNPJ,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Primetek','017.289.14.12','(61)2108-2345','(61)99654-3209','vendas@primetek.com.br','QSA QD A','Centro','Aguas Claras','DF','Brasilia','12332-22');

insert into Fornecedores(razao,CNPJ,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Shopping Risk','017.223.23.12','(61)2108-3345','(61)99654-3349','vendas@risk.com.br','QSA QD B Lote 4','Centro','taguatinga','DF','Brasilia','55632-272');

insert into Fornecedores(razao,CNPJ,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Chamex','017.3339.14.12','(61)3208-3444','(61)99654-3349','vendas@chamex.com.br','Avenida Leste qd 04 lote 34','St Industrial','Barueri','SP','São Paulo','34432-89');

insert into Fornecedores(razao,CNPJ,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Chamex','017.3339.14.12','(61)3208-3444','(61)99654-3349','vendas@chamex.com.br','Avenida Leste qd 04 lote 34','St Industrial','Barueri','SP','São Paulo','34432-89');


-- Fazendo as inserções na tabela Contas a Pagar

insert into contaspagar(idforn,razao,emissao,vencimento,doc,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (12,'Dell Computadores','12/11/2017','12/12/2017',1212,'compra de mouses',345.00,0.00,0,0,345.00,'Aberto');

insert into contaspagar(idforn,razao,emissao,vencimento,doc,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (16,'Shopping Risk','17/11/2017','28/12/2017',1234,'compra de pinceis atômicos',37.10,0.00,0,0,37.10,'Aberto');

insert into contaspagar(idforn,razao,emissao,vencimento,doc,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (17,'Chamex','18/11/2017','14/01/2018',345,'compra de resmas de papeis',670.67,0.00,0,0,670.67,'Aberto');

insert into contaspagar(idforn,razao,emissao,vencimento,doc,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (17,'Chamex','18/11/2017','14/01/2018',345,'compra de resmas de papeis',670.67,0.00,0,0,670.67,'Aberto');

-- Fazendo as inserções na tabela Alunos

insert into alunos(nome,cpf,rg,sexo,dataMatricula,dataNasc,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Felipe dos santos','044.289.031-12','2233-134','M','12/11/2017','02/07/1993','(61)3208-3454','(61)99654-3249','felipe@hotmail.com','QSB 14 LOTE 6','Edificio Dom Bosco','Aguas Claras','DF','Brasilia','34432-89');

insert into alunos(nome,cpf,rg,sexo,dataMatricula,dataNasc,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Hitalo servolo','048.123.456-10','2453.12','M','13/11/2017','12/05/1994','(61)3245-3564','(61)9890-3445','hitalotop5@gmail.com','quadra 96 lote 4','Residencial','Recanto das Emas','DF','Brasilia','45532-89');

insert into alunos(nome,cpf,rg,sexo,dataMatricula,dataNasc,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Carlos Santana','444.545.121-33','7475-980','M','13/11/2017','20/04/1996','(61)3208-4545','(61)98950-5656','carlos@hotmail.com','casa 02 lote 22','Pistão Sul','taguatinga','DF','Brasilia','34562-89');

insert into alunos(nome,cpf,rg,sexo,dataMatricula,dataNasc,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)
values ('Carlos Santana','444.545.121-33','7475-980','M','13/11/2017','20/04/1996','(61)3208-4545','(61)98950-5656','carlos@hotmail.com','casa 02 lote 22','Pistão Sul','taguatinga','DF','Brasilia','34562-89');

-- Fazendo as inserções na tabela Contas a Receber

insert into contasreceber(matricula,nome,emissao,vencimento,parcela,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (4,'Felipe dos santos','12/11/2017','12/12/2017',1,'mensalidade',567.00,0.00,0,0,567.00,'Aberto');

insert into contasreceber(matricula,nome,emissao,vencimento,parcela,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (5,'Hitalo servolo','12/11/2017','12/12/2017',1,'mensalidade',545.00,0.00,0,0,545.00,'Aberto');

insert into contasreceber(matricula,nome,emissao,vencimento,parcela,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (6,'Carlos Santana','12/11/2017','12/12/2017',1,'mensalidade',455.00,0.00,0,0,455.00,'Aberto');

insert into contasreceber(matricula,nome,emissao,vencimento,parcela,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)
values (6,'Carlos Santana','12/11/2017','12/12/2017',1,'mensalidade',455.00,0.00,0,0,455.00,'Aberto');

-- Utilizando combinações INNER JOIN, LEFT JOIN e RIGHT

select Alunos.nome, ContasReceber.vencimento
from Alunos
INNER JOIN ContasReceber
on Alunos.idMatricula=ContasReceber.idreceber;

select * from alunos
LEFT JOIN contasreceber
on contasreceber.idreceber=alunos.idMatricula;

select *from alunos as al
RIGHT JOIN contasreceber as cr
on al.idMatricula=cr.idreceber;

-- Utilizando COUNT,MAX,MIN,SUM,AVG

-- utilizando na tabela alunos
select COUNT(*)from alunos;
select COUNT(distinct idMatricula)from alunos;
-- Utilizando na tabela contas a pagar
select MAX(valorParcela)from ContasPagar;
select MIN(valorParcela)from ContasPagar;
select AVG(valorParcela)from ContasPagar;
select SUM(valorParcela)from ContasPagar;

-- Utilizando ORDER BY, GROUP BY e HAVING

-- selecionando a tabela alunos em ordem alfabética
select*from alunos ORDER BY nome ASC;

-- selecionando a tabela fornecedores em ordem alfabética
select*from fornecedores ORDER BY razao ASC;

-- selecionando a tabela alunos em ordem de numérica
select idMatricula,nome from alunos ORDER BY idMatricula;


-- selecionando a tabela contas a receber por nome e mensalidade por valor total de pagamentos
select nome,valorTotal from contasreceber ORDER BY valorTotal DESC;


-- consultando razao do fornecedor cadastrado no contas a pagar
select*from ContasPagar
where razao="Dell Computadores";

-- consulta usando agregação para obter valor por fornecedor
select SUM(valorTotal)as Total
from contaspagar
where razao='Dell Computadores';

-- consulta totalizando as compras com cada fornecedor cadastrado no contas a pagar:
select razao,SUM(valorTotal) as Total
from contaspagar
GROUP BY razao;

-- consulta retornando total de lançamentos por fornecedores com menos de R$100,00 de compras
select razao, sum(valorTotal) as Total
from contaspagar
group by razao
HAVING sum(valorTotal)<100.00;

-- consulta retornando total de lançamentos por fornecedores com maior de R$100,00 de compras
select razao, sum(valorTotal) as Total
from contaspagar
group by razao
HAVING sum(valorTotal)>100.00;

-- Fazendo alterações nas tabelas UPDATE

update alunos set rg='2.235-134,' where idMatricula=4;

update fornecedores set cnpj='017.339.14/0002-12,' where idforn=17;

update contaspagar set doc='2666,' where idpagar=3;

update contasreceber set vencimento='14/12/2017,' where idreceber=6;

-- Fazendo exclusões nas tabelas DELETE

delete from alunos where idMatricula=7;

delete from fornecedores where idforn=18;

delete from contasreceber where idreceber=7;

delete from contaspagar where idpagar=9;

-- VIEWS

create view vw_contasreceber
as select alunos.nome as nome,
contasreceber.valorTotal as valorTotal
from alunos
inner join contasreceber
on alunos.idMatricula=contasreceber.idreceber;

create view vw_contaspagar
as select fornecedores.razao as razao,
contaspagar.valorTotal as valor
from fornecedores
inner join contaspagar
on fornecedores.idforn=contaspagar.idpagar;

create view vw_pagarsituacao
as select fornecedores.razao as razao,
contaspagar.situacao as situacao
from fornecedores
inner join contaspagar
on fornecedores.idforn=contaspagar.idpagar;

-- TRIGGERS

-- criando uma tabela de desconto de no CURSO
Create table descontocurso(
id INT NOT NULL,
nome VARCHAR(45) NULL,
valor_normal decimal (10,2) NULL,
valor_desconto decimal (10,2) NULL,
primary key (id));


-- desconto de 0.90
create trigger tr_desconto before insert
on descontocurso
for each row
set new.valor_desconto=(new.valor_normal* 0.90);

insert into descontocurso(id,nome,valor_normal)
values (1,'Engenharia',100.00);

-- excluindo a Trigger feita para desconto para criar uma nova Trigger para aplicar juros
Drop Trigger tr_desconto;

-- adicionando coluna para calcular juros
alter table descontocurso add column valor_juros decimal(10,2) not null;

-- juros de 1,25
create trigger tr_juros before insert
on descontocurso
for each row
set new.valor_juros=(new.valor_normal+ 1.25);

-- nova inserção com os juros
insert into descontocurso(id,nome,valor_normal)
values (2,'Engenharia',100.00);

select * from descontocurso;

-- excluindo a Trigger feita para desconto para criar uma nova Trigger para aplicar juros
Drop Trigger tr_juros;

-- adicionando coluna para valor total
alter table descontocurso add column valor_total decimal(10,2) not null;


 create trigger tr_total before insert
 on descontocurso
 for each row
 set new.valor_total=(new.valor_normal*0.90 + 1.25);


 Drop Trigger tr_total;
-- nova inserção 
insert into descontocurso(id,nome,valor_normal)
 values (6,'Engenharia',100.00); 

 select * from descontocurso;

-- STORE PROCEDURES
call nome_procedimento (parâmetros);

create procedure verValor (varContasPagar smallint)
select concat ('O valor é  ', valorTotal) as valor
From contaspagar
where idpagar = varContasPagar;

call verValor(7);


create procedure verValorReceber (varContasReceber smallint)
select concat ('O valor é  ', valorTotal) as valor
From contasreceber
where idreceber = varContasReceber;

call verValorReceber(7);

DELIMITER $$
DROP PROCEDURE IF EXISTS Somar $$
Create procedure Somar (n1 int, n2 int)
main: BEGIN

DECLARE resultado int;
set resultado = n1+n2;
SELECT resultado as result;


END $$

DELIMITER $$

call somar (3,5);





-- BLOB--

-- criando tabela perfil para guardar as imagens
Create table perfil(
id INT NOT NULL,
nome VARCHAR(45) NULL,
imagens longblob,
primary key (id));

insert into perfil(id,nome,imagens)values
(1,'foto jpeg', load_file("C:\Users\R\Desktop\projeto\conceitualdb.jpeg")),
(2,'foto jpeg', load_file("C:\Users\R\Desktop\projeto\logicodb.jpeg"));

select *from perfil;

select imagens into outfile "C:\Users\R\Desktop\projeto\conceitualdb.jpeg"
from perfil
where id=1;

select imagens into outfile "C:\Users\R\Desktop\projeto\logicodb.jpeg"
from perfil
where id=2;


-- INDEX--

-- índice para o nome do fonecedor
create index nomeIndice on Fornecedores (razao);
-- índice para o cpf do aluno
create unique index nomeIndice2 on alunos (cpf);
-- índice para o nome do aluno
create fulltext index nomeIndice3 on alunos(nome);

-- índice para o contas a pagar
create index nomeíndice4 on contaspagar(vencimento); 
-- índice para o contas a receber
create index nomeíndice5 on contasreceber(vencimento); 

-- transações--


-- commit

start transaction;

update contasreceber set nome="Larissa" where valorTotal>10.00;

commit;

-- rollback

start transaction;

update contasreceber set nome="Larissa2" where valorTotal>60.00;

rollback;


-- delete

start transaction;

delete from contasreceber where valorTotal>10.00;

commit;

-- rollback

start transaction;

delete from contasreceber where valorTotal>60.00;

rollback;

