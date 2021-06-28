package mc322.lab07.model;

import mc322.lab07.controller.Controle;
import mc322.lab07.vision.JLabelCelula;
import mc322.lab07.vision.ScreenInGame;

public class Tabuleiro {
    private int altura;
    private int largura;
    private int maximoPecasPorPlayer;
    private int[] qtdPecasPlayer;
    private Controle controle;
    private Casa[][] casas;
    
    public Tabuleiro(int altura,int largura,int maximoPecasPorPlayer){
        this.altura = altura;
        this.largura = largura;
        this.maximoPecasPorPlayer = maximoPecasPorPlayer;
        this.qtdPecasPlayer = new int[2];
        this.qtdPecasPlayer[0] = 0;
        this.qtdPecasPlayer[1] = 0;
        this.casas= new Casa[altura][largura];

        for(int coluna=0;coluna<altura;coluna++){
            this.casas[coluna][0] = new Casa(1,0);
        }
    
        for(int coluna=0;coluna<altura;coluna++){
            this.casas[coluna][1] = new Casa(-1,0);
        }

        for (int linha = 0;linha<altura;linha++){
            for(int coluna=2;coluna<largura-2;coluna++){
                this.casas[linha][coluna] = new Casa(-1,-1);
            }
        }

        for(int coluna=0;coluna<altura;coluna++){
            this.casas[coluna][largura-2] = new Casa(-1,1);
        }

        for(int coluna=0;coluna<altura;coluna++){
            this.casas[coluna][largura-1] = new Casa(0,1);
        }
       

    }

    public boolean deveSerSacrificada(int[] coords){
        return casaAt(coords).deveSerSacrificada(); 
    }

    public void atualizarCasaTabuleiroVisual(int linha,int coluna){
    	//Isso vai atualizar a interface com base no que tem no tabuleiro
    	controle.getJanelaInGame().atualizarCasaTabuleiroVisual(linha, coluna);
    	
    }
    private boolean posicaoValida(int[] pos){
        if ((0>pos[0]||this.altura-1<pos[0])||(0>pos[1]||this.largura-1<pos[1])){
            return false;
        }
        return true;
    }
    public Casa casaAt(int[] pos){
        return casas[pos[0]][pos[1]];
    }

    public boolean casaVazia(int[] pos){
        return casaAt(pos).vazia();
    } 

    public Peca pecaAt(int[] coords){
        return casaAt(coords).getPeca();
    }

    public void removerPeca(Peca peca){
        casaAt(peca.getCoords()).esvaziar();
        qtdPecasPlayer[peca.getPlayer()] -= 1;
    }

    public void setControle(Controle controle) {
    	this.controle=controle;
    }
    public boolean moverPeca(int[] pos1,int[] pos2 ){
        // MOVE UMA PEÇA DE pos1 PARA pos2
        if ( !(posicaoValida(pos1) && posicaoValida(pos2)) )  {
            System.out.println("Posicoes Invalidas");
            return false;
        }
        if (casaVazia(pos1)){
            System.out.println("Nao há peça na casa escolhida");
            return false;
        }
        Peca pecaEscolhida = casaAt(pos1).getPeca();
        if(pecaEscolhida.validarMovimento(pos2)){
            casaAt(pos2).colocarPeca(pecaEscolhida);
            casaAt(pos1).esvaziar();
            pecaEscolhida.setPosicao(pos2);
            return true;
        }
        System.out.println("peca nao validou o movimento");
        return false;
    }

    public boolean ataquePeca(int[] pos1,int[] pos2 ){
        // REALIZA O ATAQUE DA PEÇA EM pos1 SOBRE A PEÇA EM pos2
        if ( !(posicaoValida(pos1) && posicaoValida(pos2)) )  {
            System.out.println("Posicoes Invalidas");
            return false;
        }
        if (casaVazia(pos1) || casaVazia(pos2)){
            System.out.println("Nao há peça na casa escolhida");
            return false;
        }
        Peca pecaEscolhida = casaAt(pos1).getPeca();
        if(!pecaEscolhida.validarAtaque(pos2)){
            System.out.println("A peca falou que o ataque é inválido!");
            return false;
        }

        pecaEscolhida.atacar(casaAt(pos2).getPeca());
        return true;
    }

    public boolean colocarPeca(ICarta tipo_de_peca,int[] pos,int numeroPlayer){
        // COLOCA UMA PEÇA EM pos2
        if (!casaVazia(pos)){
            System.out.println("Já há uma peça na casa escolhida");
            return false;
        }
        if (this.qtdPecasPlayer[numeroPlayer]>=this.maximoPecasPorPlayer){
            System.out.println("Player já está no limite máximo de peças");
            return false;
        }

        if (!casaAt(pos).podePorPeca(numeroPlayer)){
            System.out.println("Player tentando colocar peças fora da zona permitida");
            return false;
        }
        casaAt(pos).setPeca(tipo_de_peca,numeroPlayer);
        casaAt(pos).getPeca().setPosicao(pos);
        this.qtdPecasPlayer[numeroPlayer] += 1;
        return true;
    }


    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return this.largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getMaximoPecasPorPlayer() {
        return this.maximoPecasPorPlayer;
    }

    public void setMaximoPecasPorPlayer(int maximoPecasPorPlayer) {
        this.maximoPecasPorPlayer = maximoPecasPorPlayer;
    }

    public Casa[][] getCasas() {
        return this.casas;
    }

    public void setCasas(Casa[][] casas) {
        this.casas = casas;
    }
    public void mostrarNoTerminal(){
        // FUNÇÃO USADA NAS VERSOES INICIAIS DO PROGRAMA
        System.out.println("Estado atual:");
        for(int i = 0;i<altura;i++){
            for(int j=0;j<largura;j++){
                int[] coord = {i,j};
                if(casaVazia(coord))
                    System.out.print("-");
                else
                    System.out.print("P");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}