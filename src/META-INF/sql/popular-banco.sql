INSERT INTO `usuario` (`id`, `login`, `nome`, `senha`) VALUES
(1, 'admin', 'admin', 'ISMvKXpXpadDiUoOSoAfww==');

INSERT INTO `categoria` (`id`, `descricao`, `nome`) VALUES
(1, 'Gêneros alimentícios', 'Alimentos'),
(2, 'Roupas diversas', 'Roupa'),
(3, 'Calçados diversos', 'Calçados');

INSERT INTO `produto` (`id`, `datacadastro`, `nome`, `preco`, `id_categoria`) VALUES
(1, '2019-04-26', 'Picanha', 45, 1),
(2, '2019-04-26', 'Alcatra', 28, 1),
(3, '2019-04-26', 'Filé', 34, 1),
(4, '2019-04-26', 'Blusa', 78, 2),
(5, '2019-04-26', 'Calça', 99, 2),
(6, '2019-04-26', 'Tenis', 340, 3),
(7, '2019-04-26', 'Chinelo', 23.5, 3);

INSERT INTO `cliente` (`id`, `endereco`, `nome`) VALUES
(1, 'Rua A', 'Michell'),
(2, 'Rua B', 'Kleber'),
(3, 'Rua C', 'Gabriel');

INSERT INTO `venda` (`id`, `datavenda`, `id_cliente`) VALUES
(1, '2019-04-26', 2),
(2, '2019-04-26', 2);

INSERT INTO `itensvenda` (`id`, `precoProduto`, `qtd`, `totalProduto`, `id_produto`, `id_venda`) VALUES
(1, 59, 4, 236, 1, 1),
(2, 28, 2, 56, 2, 1),
(3, 34, 3, 102, 3, 1),
(4, 45, 2, 90, 1, 2),
(5, 34, 3, 102, 3, 2);