# API-gerenciador-de-beneficios
Implementação feita com API Rest(Spring boot).
Considerações:
- JDK 1.8, Maven.
- Testes automatizados. 
- Conceitos de arquitetura baseada no livro Clean Code(Robert Cecil Martin).
- Design patterns ultilizado: Strategy Pattern.

======================//======================
# Seleção de famílias aptas a ganharem uma casa popular
Temos um produto e recebemos o desafio de gerar uma lista de pessoas aptas a ganhar uma casa popular do governo, tendo como única exigência que essa lista esteja ordenada de forma mais justa possível com um somatório de pontos, analisando aspectos das famílias que estão participando. São considerados os seguintes critérios para a construção das pontuações:
- Renda total da família até 900 reais - valendo 5 pontos;
- Renda total da família de 901 à 1500 reais - valendo 3 pontos;
- Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
- Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos.
### missão
O resultado esperado é que as famílias, na listagem, estejam pontuadas de acordo com os critérios que foram atendidos (cada família pode pontuar uma única vez por critério, além de poder atender todos os critérios ou nenhum deles) e ordenadas pela pontuação, favorecendo as famílias melhores pontuadas.