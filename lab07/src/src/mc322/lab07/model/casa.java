package mc322.lab07.model;

public class Casa{
    private Peca peca;
    private int playerSacr; // ARMAZENA QUAL PLAYER PODE SACRIFICAR PECAS NESTA CASA
                        // -1 CASO NÃO SEJA CASA DE SACRIFÍCIO
    private int playerDono;
    public Casa(int playerSacr,int playerDono){
        this.peca = null;
        this.playerSacr = playerSacr;
        this.playerDono = playerDono;
    }

 
    public Peca getPeca() {
    	if(this.peca == null) return null;
        return this.peca;
    }

    public boolean deveSerSacrificada(){
        return this.playerSacr == this.peca.getPlayer();
    }

    public boolean podePorPeca(int nPlayer){
        return this.playerDono == nPlayer;
    }

    public void colocarPeca(Peca peca){
        this.peca = peca;
    }

    public void esvaziar(){
        this.peca = null;
    }

    public void setPeca(ICarta tipo_de_peca,int nPlayer) {
        this.peca = tipo_de_peca.gerarPeca();
        this.peca.setPlayer(nPlayer);
    }

    public boolean vazia(){
        if (peca == null){
            return true;
        }
        return false;
    }
    
}