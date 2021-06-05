package mc322.lab07.model;
import mc322.lab07.model.peca.*;

public class Tabuleiro {
    int altura;
    int largura;
    Casa[][] casas;
    public Tabuleiro(int altura,int largura){
        this.altura = altura;
        this.largura = largura;
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
    private Casa casaAt(int[] pos){
        return casas[pos[0]][pos[1]];
    }

    public boolean casaVazia(int[] pos){
        return casas[pos[0]][pos[1]].vazia();
    } 

    public int executarAcaoPeca(int[] pos1,int[] pos2 ){

        if ( !(posicaoValida(pos1) && posicaoValida(pos2)) )  {
            System.out.println("Posicoes Invalidas");
            return 0;
        }
        if (casaVazia(pos1)){
            System.out.println("Nao há peça na casa escolhida");
            return 0;
        }
        Peca pecaEscolhida = this.casas[pos1[0]][pos1[1]].getPeca();
        return pecaEscolhida.validarMovimento();
    }

    public boolean colocarPeca(Peca tipo_de_peca,int[] pos){
        if (casaVazia(pos)){
            System.out.println("Nao há peça na casa escolhida");
            return false;
        }
        casaAt(pos).setPeca(tipo_de_peca);
        return true;
    }
}