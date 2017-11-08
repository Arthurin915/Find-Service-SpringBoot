
--AUTHENTICATION
INSERT into user(id, username, password, nome, email, active, TIPO_USER) VALUES
(100, 'pf@pf.com', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars', TRUE, 'PessoaFisica');

INSERT into user(id, username, password, nome, email, active, TIPO_USER, CATEGORIA, NOTA, CEP, CNPJ, DESCRICAO) VALUES
(101, 'pj@pj.com', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Darth Vader','darth@stars.wars', TRUE, 'PessoaJuridica', 13, 5, 123456, 123456, 'Descrição');

INSERT into user(id, username, password, nome, email, active, TIPO_USER, CATEGORIA, NOTA, CEP, CNPJ, DESCRICAO) VALUES
(102, 'pj2@pj.com', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Darth Vader 2','darth2@stars.wars', TRUE, 'PessoaJuridica', 13, 5, 123456, 123456, 'Descrição');

INSERT INTO TELEFONE (ID, DDD, NUMERO) VALUES (100, 51, 123456);
INSERT INTO TELEFONE (ID, DDD, NUMERO) VALUES (101, 51, 123456);
INSERT INTO TELEFONE (ID, DDD, NUMERO) VALUES (102, 51, 123456);

INSERT INTO ENDERECO (ID, CIDADE, ENDERECO, NUMERO, UF) VALUES (100, 'Canoas', 'Avenida Açucena', 50, 'RS');
INSERT INTO ENDERECO (ID, CIDADE, ENDERECO, NUMERO, UF) VALUES (101, 'Canoas', 'Rua Nautas', 123, 'RS');
INSERT INTO ENDERECO (ID, CIDADE, ENDERECO, NUMERO, UF) VALUES (102, 'Esteio', 'Rua Soledade', 1049, 'RS');

INSERT INTO USER_ENDERECOS (USER_ID, ENDERECOS_ID) VALUES (100, 100), (101, 101), (102, 102);
INSERT INTO USER_TELEFONES (USER_ID, TELEFONES_ID) VALUES (100, 100), (101, 101), (102, 102);


--ROLES
insert into role(id, role) values
(1, 'ROLE_PESSOA_FISICA'),
(2, 'ROLE_PESSOA_JURIDICA');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(100, 1);
insert into user_roles (user_id, roles_id) values
(101, 2);
insert into user_roles (user_id, roles_id) values
(102, 2);


