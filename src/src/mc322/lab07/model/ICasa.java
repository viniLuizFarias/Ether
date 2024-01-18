package mc322.lab07.model;

public interface ICasa {
    public Peca getPeca();
    public boolean deveSerSacrificada();
    public boolean podePorPeca(int nPlayer);
    public void colocarPeca(Peca peca);
    public void esvaziar();
    public void setPeca(Peca tipo_de_peca,int nPlayer);
    public boolean vazia();
}
