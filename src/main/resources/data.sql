insert into usuario (username, nome, senha, role, ativo, datacriacao)
values ('admin', 'Carlos Almeida','$2a$10$ch/P1YLVS.qsHVNT1Jasd.3fdGGlivKbZ7kRSOYG33rgx2dLwi6KC', 'ROLE_ADMIN', 'true', '2020-01-01 08:00:00'),
('joao', 'Carlos Almeidaaa','$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_USUARIO', 'true', '2020-01-01 08:00:00'),
('barbara', 'Carlos Almeidaaaa','$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_USUARIO', 'true', '2020-01-01 08:00:00'),
('paciente', 'Carlos Almeidaaaaa','$2a$10$QLw1A.3gEGj27rSua/ij2ebnd8wXRj2hxebqwQdWwr7sedGp4t7f2', 'ROLE_USUARIO', 'false', '2020-01-01 08:00:00');

insert into paciente(id, alergia, data_nascimento, cpf, endereco, sexo, telefone)
values (1, 'na', '1995-09-22', '043.215.987-90','Joinville','f','992789711'),
 (4, 'manga,ovo', '1983-06-24', '008.528.350-94','Manaus','m','920338696');
 /*('leite,manga', '1983-09-17', '305.091.900-06','Boa Vista','f','929329669'),
 ('camarão,abelha','2003-07-10','195.544.440-44','Campo Grande','m','933329013'),
 ('na', '1978-03-16', '177.960.150-62','Porto Alegre','m','927692791'),
 ('latex','1999-05-15', '445.847.490-19','Florianópolis','f','934516933'),
 ('melão', '1997-09-30', '727.731.190-61','São Paulo','f','937666826'),
 ('soja,nozes', '2000-02-10', '530.608.710-86','Pelotas','f','938600731'),
 ('leite,soja', '2007-11-01', '820.721.590-91','Maceió','m','928124106'),
 ('nozes,latex', '2009-06-22', '080.386.780-87','Pelotas','f','922046536'),
 ('ovo,nozes','1991-04-11', '043.213.456-90','Porto Alegre','m','998756045'),
 ('gluten,grama,carne', '1973-09-22', '043.215.456-90','Campinas','m','992342711');*/

insert into medico(id, cpf, data_admissao)
values (2, '123.456.789-11', '2018-01-03');
/*('123.456.789-33', '2013-03-12', 'true'),
('559.277.250-58', '2001-05-30', 'true'),
('459.184.880-90', '2000-05-26', 'true'),
('936.059.990-50', '2013-06-24', 'true'),
('428.707.090-99', '2013-07-02', 'true'),
('058.489.320-50', '2005-01-20', 'true'),
('987.743.680-95', '2006-03-19', 'true');*/

/*insert into medico(cpf, data_admissao, ativo)
values ('584.679.714-84', '2002-01-15', 'true'),
('048.501.290-13', '1995-10-11', 'true');*/

insert into medico(id, cpf, data_admissao, data_demissao)
values (3, '541.555.560-90', '2013-08-05', '2018-01-03');
/*('331.830.640-14', '2013-04-14', '2013-03-12', 'false');*/

insert into especialidade(medico_id, nome_especialidade)
values (2, 'Fisioterapeuta'),
(3, 'Neurocirurgião'),
(3, 'Cardiologista');
/*(2, 'Pediatria'),
(2, 'Anestesiologia'),
(2, 'Nutrologia'),
(3, 'Infectologia'),
(2, 'Acupuntura'),
(3, 'Anestesiologia'),
(2, 'Geriatria'),
(3, 'Oftalmologia'),
(2, 'Cardiologista'),
(2,'Coloproctologia'),
(3, 'Gastroenterologia'),
(3, 'Geriatria'),
(2, 'Radioterapia'),
(2, 'Psiquiatria'),
(2, 'Mastologia'),
(3, 'Radioterapia'),
(3, 'Homeopatia'),
(3, 'Dermatologia'),
(2, 'Urologia');*/

insert into consulta (horario, medico_id, paciente_id)
values ('2026-08-25 09:00:00', 2, 1),
('2026-08-25 10:30:00', 3, 1),
('2026-08-26 14:00:00', 2, 1);