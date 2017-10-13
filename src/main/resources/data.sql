
--AUTHENTICATION
INSERT into user(id, username, password, name, email, active) VALUES
(100, 'pf', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars', TRUE);

INSERT into user(id, username, password, name, email, active) VALUES
(101, 'pj', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars', TRUE);


--ROLES
insert into role(id, role) values
(1, 'ROLE_PESSOA_FISICA'),
(2, 'ROLE_PESSOA_JURIDICA');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(100, 1);
insert into user_roles (user_id, roles_id) values
(101, 2);


