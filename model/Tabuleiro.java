package model;

class Tabuleiro {
    Peca[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new Peca[8][8];
        inicializarPecasJogador(0, "preta"); // Jogador 1 (peças brancas)
        inicializarPecasJogador(7, "branca");  // Jogador 2 (peças pretas)
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
        // Peões brancos (linha 6)
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[6][coluna] = new Peao("branca");
        }

        // Peões pretos (linha 1)
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[1][coluna] = new Peao("preta");
        }
    }

    public Peca getPeca(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    void atualizarPosicao(int linhaAtual, int colunaAtual, int novaLinha, int novaColuna, Peca peca) {
        tabuleiro[linhaAtual][colunaAtual] = null;
        tabuleiro[novaLinha][novaColuna] = peca;
    }
    
    public void imprimirTabuleiro() {
        System.out.println("  a b c d e f g h");
        for (int linha = 0; linha < 8; linha++) {
            System.out.print((8 - linha) + " ");
            for (int coluna = 0; coluna < 8; coluna++) {
                Peca peca = tabuleiro[linha][coluna];
                if (peca == null) {
                    System.out.print(". ");
                } else {
                    String letra = peca.getTipo().substring(0, 1);
                    if (peca.getCor().equals("branca")) {
                        System.out.print(letra.toUpperCase() + " ");
                    } else {
                        System.out.print(letra.toLowerCase() + " ");
                    }
                }
            }
            System.out.println(8 - linha);
        }
        System.out.println("  a b c d e f g h");
    }
}