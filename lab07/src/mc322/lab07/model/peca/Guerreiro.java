package mc322.lab07.model.peca;

public class Guerreiro extends Peca {

    public Guerreiro(){
        this.vida = 10;
        this.mobilidade = 5;
    }

    public static Peca construirPeca(){
        Guerreiro guerreiro = new Guerreiro();
        return guerreiro;
    }

    public int validarMovimento(){
        return 0;
    }

    public int atacar(){
        return 0;
    }
    public boolean efeito(){
        return false;
    }
}
