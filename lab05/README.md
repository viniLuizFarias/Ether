##Projeto que simula um jogo de damas

[Link arquivos .java da versão 'a'](src/mc322/lab05a)

[Link arquivos .java da versão 'b'](src/mc322/lab05b)

Este projeto apresenta duas versões de um simulador de jogo
de damas, a versão 'a' é feita de forma menos sofisticada, considerando
que cada tipo de peça pertença a um tabuleiro. O tipo 'b' usa conceitos
de herança e polimorfismo.
Sobre o funcionamento, o simulador detecta movimentos inválidos e
imprime em um arquivo o estado final do tabuleiro, se este for inválido a 
saída é 'erro'.
Para fazer o jogo funcionar, é necessário um arquivo .csv, da forma A:B,onde A
é a coordenada da peça alvo e B a coordenada da casa na qual esta peça será
movida. Também é necessário passar 2 argumentos na inicialização, o caminho do .csv
de entrada e o arquivo de saída.
