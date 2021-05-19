##Projeto que simula um jogo

[Link arquivos .java](src/mc322/lab06)


Este projeto é uma versão em console de um jogo denominado "Mundo do Wumpus", que consiste
em um herói entrar em uma caverna e tentar coletar seu tesouro sem ser morto pelo Wumpus ou
por armadilhas.
Para acionar o jogo é simples: Ao iniciá-lo deve ser passado por parâmetro o caminho de um arquivo .csv
que representa o labirinto. Após isso, o jogo já está funcional.
Para começar a jogar será solicitado um nome de usuário, em seguida, poderão ser dados comandos via console;
cada comando indica uma ação.
-'w','a','s','d'->Movimentam o personagem de acordo com sua disposição no teclado
-'q'-> fecha o jogo
-'c'->coleta o tesouro caso o jogador esteja na casa certa
-'k'->equipa uma flecha para se defender do Wumpus.
Sabendo do funcionamento do jogo, basta apenas jogar e recuperar o tesouro em segurança.


##TRECHOS INTERESSANTES DE CÓDIGO

TRECHO 01:

```
public char haEncontro() {
		if(caverna.estaoNaMesmaSala('W',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'W';
		}
		if(caverna.estaoNaMesmaSala('B',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'B';
		}
		if(caverna.estaoNaMesmaSala('O',heroi.getIdentificador(), heroi.getLinha(), heroi.getColuna())) {
			return 'O';
		}
		if(heroi.getPegouTesouro() && heroi.getColuna() == 0 && heroi.getLinha() == 0){
			return 'A';
		}
		return '-';
	}
```

Esta função verifica se o jogador está na mesma sala de um outro componente, se sim, ela retorna uma letra que identifica o componente. 
Este trecho de código está totalmente de acordo com o item 6- Ela permite que novos componentes
sejam acrescentados sem que seja preciso alterar muito o código.
Como no exemplo, caso fosse adicionado um teletransporte, seria fácil saber se o jogador está acessando acessando
a sala do teletransporte: bastaria colocar um outro condicional que verificaria se ambos estão na mesma sala.


TRECHO 02:

```
public class Heroi extends Componente{
    

	private int qtdFlechas=1;
	private boolean isFlechaEquipada=false;
	private boolean pegouTesouro = false;
	private String nome;

	...

```
Embora simples, este trecho está de acordo com o item 3 e 4, em especial com o item 3, pois o herói é o componente
que deve ter conhecimento de suas condições.


TRECHO 3:

```
public class Sala {
    ...
    List<Componente> listaComponentes;
    Sala(){
        listaComponentes = new ArrayList<>();
	...
    }
	```
	
Este trecho de código é um bom exemplo de polimorfismo e de como o uso de estruturas já conhecidas em conjuto com ele
permitem um código mais expansível.
Esta lista de componente armazena todos os componentes de forma polimórfica, pois nele serão armazenadas as classes: Ouro, Wumpus,Buraco e Heroi.
Caso um novo componente seja implementado, isso não irá alterar em nada o funcionamento da Sala.