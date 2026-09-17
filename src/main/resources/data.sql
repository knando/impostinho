-- USUÁRIOS BASE (contas sem vínculo com médico/paciente)
insert into usuario (id, username, senha, role, nome, data_criacao, ativo)
values (1, 'admin', '$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ADMIN', 'Administrador', '2020-01-01 08:00:00', true),
(2, 'usuario', '$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_ATENDENTE', 'Atendente Padrão', '2020-01-01 08:00:00', true);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

-- PACIENTES (cada um também é uma linha em usuario, ids 3 a 14)
insert into usuario (id, nome, data_criacao, ativo)
values (3, 'Marta Almeida', '2020-01-01 08:00:00', true), (4, 'Edílson Viriato', '2020-01-01 08:00:00', true), (5, 'Teresa Josefina', '2020-01-01 08:00:00', true),
(6, 'Luiz Vital', '2020-01-01 08:00:00', true), (7, 'Matheus Adriele', '2020-01-01 08:00:00', true), (8, 'Poliana Maicon', '2020-01-01 08:00:00', true),
(9, 'Cristiana Jaime', '2020-01-01 08:00:00', true), (10, 'Lucila Cleide', '2020-01-01 08:00:00', true), (11, 'Airton Renan', '2020-01-01 08:00:00', true),
(12, 'Gabi Thales', '2020-01-01 08:00:00', true), (13, 'Jorge Matos', '2020-01-01 08:00:00', true), (14, 'Jorge Ben Jor', '2020-01-01 08:00:00', true);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into paciente (id, alergia, data_nascimento, cpf, endereco, sexo, telefone)
values (3, 'na','1995-09-22','043.215.987-90','Joinville','f','992789711'),
(4, 'manga,ovo','1983-06-24','008.528.350-94','Manaus','m','920338696'),
(5, 'leite,manga','1983-09-17','305.091.900-06','Boa Vista','f','929329669'),
(6, 'camarão,abelha','2003-07-10','195.544.440-44','Campo Grande','m','933329013'),
(7, 'na','1978-03-16','177.960.150-62','Porto Alegre','m','927692791'),
(8, 'latex','1999-05-15','445.847.490-19','Florianópolis','f','934516933'),
(9, 'melão','1997-09-30','727.731.190-61','São Paulo','f','937666826'),
(10, 'soja,nozes','2000-02-10','530.608.710-86','Pelotas','f','938600731'),
(11, 'leite,soja','2007-11-01','820.721.590-91','Maceió','m','928124106'),
(12, 'nozes,latex','2009-06-22','080.386.780-87','Pelotas','f','922046536'),
(13, 'ovo,nozes','1991-04-11','043.213.456-90','Porto Alegre','m','998756045'),
(14, 'gluten,grama,carne','1973-09-22','043.215.456-90','Campinas','m','992342711');
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

-- MÉDICOS (ids 15 a 26; 15 a 22 e 25/26 sem login ainda; 23 e 24 com conta)
insert into usuario (id, nome, data_criacao, ativo)
values (15, 'Marcos Paulo', '2018-01-03 08:00:00', true), (16, 'Carla Maria', '2013-03-12 08:00:00', true), (17, 'Fernanda Firmino', '2001-05-30 08:00:00', true),
(18, 'Mário Elder', '2000-05-26 08:00:00', true), (19, 'Geraldo Assunção', '2013-06-24 08:00:00', true), (20, 'Mônica Cristina', '2013-07-02 08:00:00', true),
(21, 'Mayara Esperança', '2005-01-20 08:00:00', true), (22, 'Thiago Xavier', '2006-03-19 08:00:00', true);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into usuario (id, username, senha, role, nome, data_criacao, ativo)
values (23, 'medico', '$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_USUARIO', 'Rogerio Lima', '2002-01-15 08:00:00', true),
(24, 'barbara', '$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_USUARIO', 'Bárbara Alves', '1995-10-11 08:00:00', true);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into usuario (id, nome, data_criacao, ativo)
values (25, 'Núbia Lara', '2013-08-05 08:00:00', false), (26, 'Túlio Wanderson', '2013-04-14 08:00:00', false);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into medico (id, cpf, data_admissao)
values (15, '123.456.789-11', '2018-01-03'), (16, '123.456.789-33', '2013-03-12'),
(17, '559.277.250-58', '2001-05-30'), (18, '459.184.880-90', '2000-05-26'),
(19, '936.059.990-50', '2013-06-24'), (20, '428.707.090-99', '2013-07-02'),
(21, '058.489.320-50', '2005-01-20'), (22, '987.743.680-95', '2006-03-19'),
(23, '584.679.714-84', '2002-01-15'), (24, '048.501.290-13', '1995-10-11');
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into medico (id, cpf, data_admissao, data_demissao)
values (25, '541.555.560-90', '2013-08-05', '2018-01-03'),
(26, '331.830.640-14', '2013-04-14', '2013-03-12');
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into especialidade (medico_id, nome_especialidade)
values (15,'Fisioterapeuta'),(15,'Neurocirurgião'),(16,'Cardiologista'),(16,'Pediatria'),
(17,'Anestesiologia'),(17,'Nutrologia'),(18,'Infectologia'),(18,'Acupuntura'),
(19,'Anestesiologia'),(19,'Geriatria'),(20,'Oftalmologia'),(20,'Cardiologista'),
(21,'Coloproctologia'),(21,'Gastroenterologia'),(22,'Geriatria'),(22,'Radioterapia'),
(23,'Psiquiatria'),(24,'Mastologia'),(24,'Radioterapia'),(25,'Homeopatia'),(25,'Dermatologia'),(26,'Urologia');
alter table usuario alter column id restart with (select max(id) + 1 from usuario);

insert into consulta (horario, medico_id, paciente_id)
values ('2026-08-25 09:00:00', 15, 3),
('2026-08-25 10:30:00', 15, 3),
('2026-08-26 14:00:00', 16, 5);
alter table usuario alter column id restart with (select max(id) + 1 from usuario);
