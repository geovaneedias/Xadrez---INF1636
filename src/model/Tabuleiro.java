package model;

class Tabuleiro {
    Object[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new Object[8][8];
        inicializarPecasJogador(0, "branca"); // Jogador 1 (peças brancas)
        inicializarPecasJogador(7, "preta");  // Jogador 2 (peças pretas)
        inicializarPeoes();
    }

    private void inicializarPecasJogador(int linha, String cor) {
        // Torres
        tabuleiro[linha][0] = new Torre(cor);
        tabuleiro[linha][7] = new Torre(cor);
        
        // Cavalos
        tabuleiro[linha][1] = new Cavalo(cor);
        tabuleiro[linha][6] = new Cavalo(cor);
        
        // Bispos
        tabuleiro[linha][2] = new Bispo(cor);
        tabuleiro[linha][5] = new Bispo(cor);
        
        // Rainha e Rei
        tabuleiro[linha][3] = new Rainha(cor);
        tabuleiro[linha][4] = new Rei(cor);
    }

    private void inicializarPeoes() {
        // Peões brancos (linha 1)
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[1][coluna] = new Peao("branca");
        }
        
        // Peões pretos (linha 6)
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[6][coluna] = new Peao("preta");
        }
    }
}