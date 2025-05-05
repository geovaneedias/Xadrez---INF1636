package model;

class Tabuleiro {
    Object[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new Object[8][8];
        tabuleiro[1][1] = new Peao("branca");
    }
}
