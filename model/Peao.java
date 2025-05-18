package model;

class Peao extends Peca {
    private String posicao;  // "original" ou "diferente" (APENAS para peão)
    
    public Peao(String cor) {
        super(cor);
        this.posicao = "original";  // Inicializa aqui
    }
    
    public String getTipo() {
        return "Peao";
    }

    public boolean mover(String coordenadaAtual, String coordenadaDestino, Tabuleiro tabuleiro) {
        char colunaAtualChar = coordenadaAtual.toLowerCase().charAt(0);
        char linhaAtualChar = coordenadaAtual.charAt(1);
        int colunaAtual = colunaAtualChar - 'a';
        int linhaAtual = 8 - (linhaAtualChar - '0');

        char colunaDestinoChar = coordenadaDestino.toLowerCase().charAt(0);
        char linhaDestinoChar = coordenadaDestino.charAt(1);
        int colunaDestino = colunaDestinoChar - 'a';
        int linhaDestino = 8 - (linhaDestinoChar - '0');

        int diferencaLinha = linhaDestino - linhaAtual;
        int diferencaColuna = colunaDestino - colunaAtual;

        if (diferencaColuna != 0) {
            System.out.println("Movimento inválido para o peão: não pode mover na horizontal.");
            return false;
        }

        int direcao = cor.equals("branca") ? -1 : 1;

        if (diferencaLinha == direcao) {
            if (tabuleiro.getPeca(linhaDestino, colunaDestino) == null) {
                tabuleiro.atualizarPosicao(linhaAtual, colunaAtual, linhaDestino, colunaDestino, this);
                posicao = "diferente";
                return true;
            } else {
                System.out.println("Movimento inválido: destino ocupado.");
                return false;
            }
        }

        if (diferencaLinha == 2 * direcao && posicao.equals("original")) {
            int linhaIntermediaria = linhaAtual + direcao;

            if (tabuleiro.getPeca(linhaIntermediaria, colunaAtual) == null &&
                tabuleiro.getPeca(linhaDestino, colunaDestino) == null) {
                tabuleiro.atualizarPosicao(linhaAtual, colunaAtual, linhaDestino, colunaDestino, this);
                posicao = "diferente";
                return true;
            } else {
                System.out.println("Movimento inválido: caminho bloqueado.");
                return false;
            }
        }

        System.out.println("Movimento inválido para o peão.");
        return false;
    }

}