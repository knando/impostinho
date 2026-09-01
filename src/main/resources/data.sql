insert into paciente(alergia,nome,data_nascimento,cpf,endereco,sexo,telefone)
values ('ovo,nozes','Jorge Matos', '1991-04-11', '043.213.456-90','Porto Alegre','m','998756045'),
 ('gluten,grama,carne','Jorge Ben Jor', '1973-09-22', '043.215.456-90','Campinas','m','992342711'),
 ('na','Marta Almeida','1995-09-22', '043.215.987-90','Joinville','f','992789711'),
 ('manga,ovo','Edílson Viriato', '1983-06-24', '008.528.350-94','Manaus','m','920338696'),
 ('leite,manga','Teresa Josefina', '1983-09-17', '305.091.900-06','Boa Vista','f','929329669'),
 ('camarão,abelha','Luiz Vital','2003-07-10','195.544.440-44','Campo Grande','m','933329013'),
 ('na','Matheus Adriele', '1978-03-16', '177.960.150-62','Porto Alegre','m','927692791'),
 ('latex','Poliana Maicon', '1999-05-15', '445.847.490-19','Florianópolis','f','934516933'),
 ('melão','Cristiana Jaime', '1997-09-30', '727.731.190-61','São Paulo','f','937666826'),
 ('soja,nozes','Lucila Cleide', '2000-02-10', '530.608.710-86','Pelotas','f','938600731'),
 ('leite,soja','Airton Renan', '2007-11-01', '820.721.590-91','Maceió','m','928124106'),
 ('nozes,latex','Gabi Thales', '2009-06-22', '080.386.780-87','Pelotas','f','922046536');

insert into medico(cpf, data_admissao, nome, ativo)
values ('123.456.789-11', '2018-01-03', 'Marcos Paulo','true'),
('123.456.789-33', '2013-03-12', 'Carla Maria','true'),
('584.679.714-84', '2002-01-15', 'Rogerio Lima','true'),
('048.501.290-13', '1995-10-11', 'Bárbara Alves','true'),
('559.277.250-58', '2001-05-30', 'Fernanda Firmino','true'),
('459.184.880-90', '2000-05-26', 'Mário Elder','true'),
('936.059.990-50', '2013-06-24', 'Geraldo Assunção','true'),
('428.707.090-99', '2013-07-02', 'Mônica Cristina','true'),
('058.489.320-50', '2005-01-20', 'Mayara Esperança','true'),
('987.743.680-95', '2006-03-19', 'Thiago Xavier','true');

insert into medico(cpf, data_admissao, nome, data_demissao, ativo)
values ('541.555.560-90', '2013-08-05', 'Núbia Lara', '2018-01-03', 'false'),
('331.830.640-14', '2013-04-14', 'Túlio Wanderson', '2013-03-12', 'false');

insert into especialidade(medico_id, nome_especialidade)
values (1, 'Fisioterapeuta'),
(1, 'Neurocirurgião'),
(2, 'Cardiologista'),
(2, 'Pediatria');

insert into consulta (horario, medico_id, paciente_id)
values ('2026-08-25 09:00:00', 1, 1),
('2026-08-25 10:30:00', 1, 1),
('2026-08-26 14:00:00', 2, 3);
