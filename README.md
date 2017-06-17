# recomenda-o

Grupo: Rodrigo Lampier e Gustavo Grimaldi

Esse pequeno sistema foi desenvolvido como nota parcial para a disciplina de Comércio Eletrônico. O sistema apresenta um menu onde podemos:

1. Dado um par (usuário, item) informar a classificação do item.
2. Dado um usuário, recomendar um conjunto de itens baseado em uma lista de classificação de itens criadas pelo sistema de recomendação.
3. Dado um item, obter uma lista de perfis de usuários que são recomendados para este item. 

Foi utilizado como base um curso da Duke University para sistemas de recomendação que pode ser encontrado no link abaixo:

http://www.dukelearntoprogram.com/course5/index.php

As devidas adaptações foram feitas para atender a demanda do trabalho.

A base utilizada foi o IMDB, porém a mesma base foi filtrada pela Duke, logo não temos uma base muito grande. Além disso, não foi usado um banco de dados, utilizamos os arquivos CSVs cedidos e um parser para transferir os dados para um HashMap, assim ficando mais prática e rápida a manipulação dos dados.

Foi implementado na interface gráfica somente o pedido pelo professor, mas no código fonte temos outras funções de similaridade baseada em outros filtros além do Rating.
