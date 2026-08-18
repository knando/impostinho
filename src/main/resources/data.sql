insert into paciente(alergia,nome,data_nascimento,cpf,endereco,sexo,telefone)
values ('ovo,nozes','Jorge Matos', '1991-04-11', '043.213.456-90','Porto Alegre','m','998756045'),
 ('gluten,grama,carne','Jorge Ben Jor', '1973-09-22', '043.215.456-90','Campinas','m','992342711'),
 ('na','Marta Almeida', '1995-09-22', '043.215.987-90','Minas Gerais','f','992789711');

insert into medico(cpf, data_admissao, nome)
values ('123.456.789-11', '2018-01-03', 'Marcos Paulo'),
('123.456.789-33', '2013-03-12', 'Carla Maria');

insert into especialidade (medico_id, nome_especialidade)
values (1, 'Fisioterapia'),
(1, 'Neurocirurgia'),
(2, 'Cardiologia'),
(2, 'Pediatria');