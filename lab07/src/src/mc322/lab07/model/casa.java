package mc322.lab07.model;

public class Casa{
    private Peca peca;

    public Casa(){
        this.peca = null;
    }

 
    public Peca getPeca() {
        return this.peca;
    }

    public void colocarPeca(Peca peca){
        this.peca = peca;
    }

    public void esvaziar(){
        this.peca = null;
    }

    public void setPeca(Peca tipo_de_peca) {
        this.peca = tipo_de_peca.gerarPeca();
    }

    public boolean vazia(){
        if (peca == null){
            return true;
        }
        return false;
    }
    
}