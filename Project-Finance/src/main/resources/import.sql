insert into natureza_despesa (descricao) values ('Imposto'), ('Materia prima'), ('Alimentação'), ('Limpeza');

insert into parceiro (nome, nomefantasia, cnpj, cpf, fornecedor, cliente) values ('Coppi Solutions', 'Coppi', '000000000000100', '00000000000', 1, 1), ('Bravo Solutions', 'Bravo', '003003005000100', null, 1, 0), ('Raphael Alves', 'Raphael SAP', null, '30060050040', 0, 1);

insert into despesa (descricao, dt_vencimento, formapgto, fornecedor, valor, dt_lancamento, categoria_despesa_cod) values ('nescauball', '2023-10-23', 'Boleto', 'Governo', 52000, '2023-10-12', 1), ('Cafe', '2022-10-23', 'Boleto', 'Governo', 100, '2023-10-12', 2), ('nescauball', '2023-10-25', 'Boleto', 'Governo', 10000, '2023-10-12', 3), ('nescauball', '2023-10-10', 'Boleto', 'Governo', 356.45, '2023-10-12', 4);

insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Boleto', '2023-10-22', 'Apoio Administrativo', 10000, 1);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Banco BX','2022-09-02', 'Transferencia', 592, 2);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Pix', '2023-10-21', 'Consultoria',5000, 3);
insert into receita (formapgto, data_lancamento, descricao, valor, categoria_receita_cod) values ('Ted', '2023-04-20', 'Adiantamento',880, 4);

INSERT INTO usuario (celular, cep, cidade, cnpj, conta_bancaria, cpf, data_inclusao, email, endereco, estado, nome, senha)
VALUES ('1234567890', '12345-678', 'Cidade1', '12344', '123467', '123.456.789-01', '2023-01-01', 'usuario1@email.com', 'Rua 1', 'Estado1', 'Nome1', 'senha1'),
       ('9876543210', '98765-432', 'Cidade2', '567878', '56701', '234.567.890-12', '2023-02-01', 'usuario2@email.com', 'Rua 2', 'Estado2', 'Nome2', 'senha2'),
       ('1112223333', '11111-222', 'Cidade3', '9876', '9876543', '345.678.901-23', '2023-03-01', 'usuario3@email.com', 'Rua 3', 'Estado3', 'Nome3', 'senha3'),
       ('9998887777', '99999-888', 'Cidade4', '345656', '345689', '456.789.012-34', '2023-04-01', 'usuario4@email.com', 'Rua 4', 'Estado4', 'Nome4', 'senha4');