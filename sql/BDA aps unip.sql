CREATE DATABASE 'sistema_caixa'
TEMPLATE = template0
ENCODING 'win1252'
CONNECTION LIMIT -1;

CREATE TABLE tb_funcionario(
id_func		INTEGER 	CONSTRAINT nn_tb_funcionario_id_func NOT NULL,
nm_func		VARCHAR(60) 	CONSTRAINT nn_tb_funcionario_nm_func NOT NULL,
senha_func	VARCHAR(255) 	CONSTRAINT nn_tb_funcionario_senha_func NOT NULL,
permissao	BOOLEAN 	CONSTRAINT nn_tb_funcionario_perm NOT NULL,
CONSTRAINT pk_tb_funcionario_id_func PRIMARY KEY(id_func));

DROP TABLE tb_funcionario;

INSERT INTO tb_funcionario (id_func, nm_func, senha_func, permissao)
VALUES
(1,'PERSIO', 'admadm', true);

SELECT * FROM tb_funcionario;

CREATE TABLE tb_produto(
cod_barra	VARCHAR(13) 	CONSTRAINT nn_tb_prod_cod_bar NOT NULL,
nm_prod		VARCHAR(60)	CONSTRAINT nn_tb_prod_nm_prod NOT NULL,
vol_prod	VARCHAR(30)	CONSTRAINT nn_tb_prod_vol_prod NOT NULL,
qte_prod	INTEGER		CONSTRAINT nn_tb_prod_qte_prod NOT NULL,
vl_compra	NUMERIC(7,2)	CONSTRAINT nn_tb_prod_vl_comp NOT NULL,
vl_venda	NUMERIC(7,2)	CONSTRAINT nn_tb_prod_vl_venda NOT NULL,
CONSTRAINT pk_tb_produtp_cod_bar PRIMARY KEY(cod_barra));

SELECT * FROM tb_produto;

drop table tb_produto;

INSERT INTO tb_produto (cod_barra, nm_prod, vol_prod, qte_prod, vl_compra, vl_venda)
VALUES
('7891149104109', 'Brahma chop', '550 ml', 12, 1.30, 2.50);

CREATE TABLE tb_venda(
id_func		INTEGER 	CONSTRAINT nn_tb_venda_id_func NOT NULL ,
cod_prod	VARCHAR(13) 	CONSTRAINT nn_tb_venda_cod_prod NOT NULL,
valor_total	NUMERIC(7,2)	CONSTRAINT nn_tb_venda_vl_total NOT NULL,
CONSTRAINT pk_tb_venda_cod_prod PRIMARY KEY(cod_prod),
CONSTRAINT fk_tb_venda_id_func FOREIGN KEY(id_func) REFERENCES tb_funcionario(id_func),
CONSTRAINT fk_tb_venda_cod_prod FOREIGN KEY(cod_prod) REFERENCES tb_produto(cod_barra));

select * from tb_venda;

drop table tb_venda;

INSERT INTO tb_venda (id_func,cod_prod,valor_total)
VALUES
(1,'7891149104109',2.50);

select * from tb_venda v inner join tb_produto p on p.cod_barra = v.cod_prod;

select qte_prod from tb_produto p inner join tb_venda v on p.cod_barra = v.cod_prod WHERE cod_prod LIKE '7891149104109';

select * from tb_venda v inner join tb_funcionario f on f.id_func = v.id_func;

SELECT * FROM tb_venda WHERE cod_prod LIKE '7891149104109';

SELECT * FROM tb_produto;

DELETE FROM tb_venda;

UPDATE tb_produto SET qte_prod = 22 WHERE cod_barra = '7891149104109';

CREATE TABLE tb_caixa(
Cod_venda	SERIAL		NOT NULL,
id_func		INTEGER 	CONSTRAINT nn_tb_caixa_id_func NOT NULL,
qte_vendas	INTEGER		CONSTRAINT nn_tb_caixa_qte_vendas NOT NULL,
data_vendas	Varchar(10) 		CONSTRAINT nn_tb_caixa_dt_vendas NOT NULL,
valor_total	numeric(10,2)	CONSTRAINT nn_tb_caixa_vl_total NOT NULL,
CONSTRAINT pk_tb_caixa_cod_venda PRIMARY KEY(cod_venda),
CONSTRAINT fk_tb_caixa_id_func FOREIGN KEY(id_func) REFERENCES tb_funcionario(id_func));

SELECT * FROM tb_caixa;

drop table tb_caixa;

DELETE FROM tb_caixa;
