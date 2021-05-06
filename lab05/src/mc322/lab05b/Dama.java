package mc322.lab05b;

public class Dama extends Peca{

    public Dama(int linha, int coluna, int player) {
        super(linha, coluna, player);
    }


    String String(){
        if (player == 0) return ("B");
        return ("P");
    }

    boolean caminho_livre(int linha2, int coluna2,int[] caminho){
        // VE SE O CAMINHO ATE O DESTINO EST� VAZIO
        // SE NÃO HOUVEREM PEÇAS NO CAMINHO, O CAMINHO ESTÁ LIVRE
        // SE HOUVEREM 2 OU MAIS PEÇAS, ELE NÃO ESTÁ LIVRE
        // CASO HAJA 1 PEÇA, ESTA DEVE SER A PENULTIMA DO CAMINHO, SENÃO ELE NÃO ESTÁ LIVRE
        //System.out.println("caminho_livre");
        int nPecasCaminho=0;
        for(int i = 0;i< caminho.length;i++){
            if(caminho[i] != -1){
                nPecasCaminho++;
            }
        }
        if(nPecasCaminho==0) {
            return true;
        }
        else if(nPecasCaminho==1 && caminho[caminho.length-2]==ehPecaInimiga()){
            return true;
        }
        return false;
    }

    boolean ehMovimentoValido(int[] caminho,int[] coordsAlvo) {
        //System.out.println("movValido");
        if(!caminho_livre(coordsAlvo[0],coordsAlvo[1], caminho)){
            //System.out.println("B");
            return false;
        }

        //System.out.println("C");

        return true;
    }
}
