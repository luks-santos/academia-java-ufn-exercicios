/* 1-*/
create table tb_departamento (
	departamento_id SERIAL primary key, 
	departamento_nome VARCHAR(50)
)
/* */
create table tb_funcionario (
	funcionario_id SERIAL primary key, 
	departamento_id INT,
	funcionario_nome VARCHAR(50),
	cargo VARCHAR(50), 
	salario DECIMAL(10, 2),
	data_contratacao DATE,
	
	constraint fk_departamento  
		foreign key(departamento_id)
			references tb_departamento(departamento_id) 
);

/* 2-*/
insert into tb_departamento (departamento_nome) 
	values
	('Recursos Humanos'),
	('Marketing'),
	('Tecnologia da Informação'),
	('Vendas')	
/* */
insert into tb_funcionario (departamento_id, funcionario_nome, cargo, salario, data_contratacao)
	values 
	(1, 'João Silva', 'Gerente', 2000.00, '2020-01-01'),
	(2, 'Maria Santos', 'Assistente', 2000.00, '2019-05-05'),
	(3, 'Pedro Costa', 'Analista', 2000.00, '2020-03-20'),
	(2, 'Ana Pereira', 'Gerente', 7000.00, '2021-01-01'),
	(null, 'Julia Costa', 'Analista', 2500.00, '2022-01-01')
		
/* 3-*/
select * from tb_funcionario;

/* 4-*/
select * from tb_funcionario tf where tf.salario > 3000;

/* 5-*/
update tb_funcionario set salario = 3500.00
	where funcionario_id  = 3;

/* 6-*/
delete from tb_funcionario
	where funcionario_id  = 2;

/* 7-*/
select funcionario_nome, salario 
	from tb_funcionario 
	order by salario desc;

/* 8-*/
select cargo, trunc(avg(salario), 2) as media_salario 
	from tb_funcionario
	group by cargo;
	
/* 9-*/
select funcionario_nome, departamento_nome  
	from tb_funcionario tf, tb_departamento td 
	where tf.departamento_id = td.departamento_id;

/* 10-*/
select td.departamento_nome, count(tf.departamento_id) as num_funcionarios
	from tb_departamento td
	left join tb_funcionario tf 
		on tf.departamento_id = td.departamento_id 
	group by td.departamento_nome
	order by num_funcionarios;