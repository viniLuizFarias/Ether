package mc322.lab07.model;

public class Tabuleiro {
    int altura;
    int largura;
    int maximoPecasPorPlayer;
    int[] qtdPecasPlayer;
    Casa[][] casas;

    public Tabuleiro(int altura,int largura,int maximoPecasPorPlayer){
        this.altura = altura;
        this.largura = largura;
        this.maximoPecasPorPlayer = maximoPecasPorPlayer;
        this.qtdPecasPlayer = new int[2];
        this.qtdPecasPlayer[0] = 0;
        this.qtdPecasPlayer[1] = 0;
        this.casas= new Casa[altura][largura];
        for (int linha = 0;linha<altura;linha++){
            for(int coluna=0;coluna<largura;coluna++){
                this.casas[linha][coluna] = new Casa();
            }
        }

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

    public boolean moverPeca(int[] pos1,int[] pos2 ){

        if ( !(posicaoValida(pos1) && posicaoValida(pos2)) )  {
            System.out.println("Posicoes Invalidas");
            return false;
        }
        if (casaVazia(pos1)){
            System.out.println("Nao há peça na casa escolhida");
            return false;
        }
        Peca pecaEscolhida = this.casas[pos1[0]][pos1[1]].getPeca();
        if(!pecaEscolhida.validarMovimento(pos2)){
            casaAt(pos2).setPeca(pecaEscolhida);
            casaAt(pos1).esvaziar();
            return true;
        }
        System.out.println("peca nao validou o movimento");
        return false;
    }

    public boolean ataquePeca(int[] pos1,int[] pos2 ){

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
            System.out.println("A peca falou que o ataque [e] inválido");
            return false;
        }
        pecaEscolhida.atacar(casaAt(pos2).getPeca());
        if(casaAt(pos2).getPeca().getVida()<0){
            casaAt(pos2).esvaziar();
        }
        return true;
    }

    public boolean colocarPeca(Peca tipo_de_peca,int[] pos,int numeroPlayer){
        if (!casaVazia(pos)){
            System.out.println("Já há uma peça na casa escolhida");
            return false;
        }
        if (this.qtdPecasPlayer[numeroPlayer]>=this.maximoPecasPorPlayer){
            System.out.println("Player já está no limite máximo de peças");
            return false;
        }
        atualizarInterfaceGrafica(pos);
        casaAt(pos).setPeca(tipo_de_peca);
        return true;
    }

    public void atualizarInterfaceGrafica(int[] coords){

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
        for(int i = 0;i<altura;i++){
            for(int j=0;j<largura;j++){
                int[] coord = {i,j};
                if(casaVazia(coord))
                    System.out.println("-");
                else
                    System.out.println("P");
            }
        }
    }
}