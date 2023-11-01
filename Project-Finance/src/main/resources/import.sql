insert into categoria_despesa (descricao) values ('imposto'), ('Materia prima'), ('Alimentação'), ('Limpeza');


insert into despesa (descricao, dt_vencimento, formapgto, fornecedor, valor, dt_lancamento, categoria_despesa_cod) values ('nescauball', '2023-10-23', 'Boleto', 'Governo', 52000, '2023-10-12', 1), ('Cafe', '2022-10-23', 'Boleto', 'Governo', 100, '2023-10-12', 2), ('nescauball', '2023-10-25', 'Boleto', 'Governo', 10000, '2023-10-12', 3), ('nescauball', '2023-10-10', 'Boleto', 'Governo', 356.45, '2023-10-12', 4);





insert into categoria_receita (descricao) values ('Serviços Prestados');
insert into categoria_receita (descricao) values ('Rendimento de Aplicação');
insert into categoria_receita (descricao) values ('Atendimento Realizado');
insert into categoria_receita (descricao) values ('Outros');


insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Boleto', '2023-10-22', 'Apoio Administrativo', 10000, 1);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Banco BX','2022-09-02', 'Transferencia', 592, 2);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Pix', '2023-10-21', 'Consultoria',5000, 3);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Pix', '2023-04-20', 'Adiantamento',880, 4);
