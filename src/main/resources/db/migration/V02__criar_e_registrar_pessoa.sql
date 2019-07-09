CREATE TABLE pessoa (codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
						nome VARCHAR(50) NOT NULL,
						ativo Boolean not null,
						logradouro VARCHAR (100),
						numero VARCHAR (10),
						complemento VARCHAR (100),
						bairro VARCHAR (100),
						cep VARCHAR (12),
						cidade VARCHAR (50),
						estado Char (2)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

						
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Alexandre Assis de Lima", true,"Av Miguel Frias e Vasconcelos","1200", "APTO26- Bloco Milão","Jaguare", "05.345-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Lucas Alves", true,"Rua da Pinga","50", "Casa","Paulista", "08.754-620","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Ze Augusto", true,"Rua da consolação","100", "Casa","Paulista", "04.567-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Willian Shakespeare", true,"Rua da pistola de ouro","130", "Casa","Paulista", "04.567-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Bete Ramalho", true,"Avenida churupita","320", "Casa","Paulista", "04.567-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Zinho", true,"Rua da paz","304", "Casa","Paulista", "09.345-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Alex",true,"Rua da consolação","301", "Casa","Paulista", "05.436-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Ademir da Guia",true,"Rua da consolação","340", "Casa","Paulista", "09.873-000","São Paulo", "SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
VALUES ("Edmundo", true,"Rua da consolação","30", "Casa","Paulista", "04.567-000","São Paulo", "SP");