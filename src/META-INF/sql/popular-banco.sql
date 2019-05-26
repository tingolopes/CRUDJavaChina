INSERT INTO `usuario` ( `login`, `nome`, `senha`) VALUES
( 'admin', 'admin', 'ISMvKXpXpadDiUoOSoAfww==');

INSERT INTO `categoria` (`descricao`, `nome`) VALUES
( 'Gêneros alimentícios', 'Alimentos'),
( 'Roupas diversas', 'Roupa'),
( 'Calçados diversos', 'Calçados');

INSERT INTO `produto` ( `datacadastro`, `nome`, `preco`, `id_categoria`) VALUES
( '2019-04-26', 'Picanha', 45, 1),
( '2019-04-26', 'Alcatra', 28, 1),
( '2019-04-26', 'Filé', 34, 1),
( '2019-04-26', 'Blusa', 78, 2),
( '2019-04-26', 'Calça', 99, 2),
( '2019-04-26', 'Tenis', 340, 3),
( '2019-04-26', 'Chinelo', 23.5, 3);

INSERT INTO `cliente` ( `endereco`, `nome`) VALUES
('Rua A', 'Michell'),
('Rua B', 'Kleber'),
('Rua C', 'Gabriel');

INSERT INTO `venda` ( `datavenda`, `id_cliente`) VALUES
('2019-04-26', 2),
('2019-04-26', 2);

INSERT INTO `itensvenda` ( `precoProduto`, `qtd`, `totalProduto`, `id_produto`, `id_venda`) VALUES
( 59, 4, 236, 1, 1),
( 28, 2, 56, 2, 1),
( 34, 3, 102, 3, 1),
( 45, 2, 90, 1, 2),
( 34, 3, 102, 3, 2);