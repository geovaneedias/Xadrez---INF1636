package model;

abstract class Peca {
    protected String cor;
    
    public Peca(String cor) {
        this.cor = cor;
    }
    
    public String getCor() {
        return cor;
    }
    
    public abstract String getTipo();

}
