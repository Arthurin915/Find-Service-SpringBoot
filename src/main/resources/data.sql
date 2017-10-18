
--AUTHENTICATION
INSERT into user(id, username, password, nome, email, active, TIPO_USER) VALUES
(100, 'pf@pf.com', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars', TRUE, 'PessoaFisica');

INSERT into user(id, username, password, nome, email, active, TIPO_USER) VALUES
(101, 'pj@pj.com', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Darth Vader','darth@stars.wars', TRUE, 'PessoaJuridica');


--ROLES
insert into role(id, role) values
(1, 'ROLE_PESSOA_FISICA'),
(2, 'ROLE_PESSOA_JURIDICA');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(100, 1);
insert into user_roles (user_id, roles_id) values
(101, 2);


