package model;

class Cavalo extends Peca {
	
    public Cavalo(String cor) {
        super(cor); // <-- chama o construtor da superclasse Peca
    }
    
    public String getTipo() {
        return "Cavalo";
    }

    public boolean mover(String coordenadaAtual, String coordenadaDestino, Tabuleiro tabuleiro) {
        // Converte coordenadas para índices da matriz
        char colunaAtualChar = coordenadaAtual.toLowerCase().charAt(0);
        char linhaAtualChar = coordenadaAtual.charAt(1);
        int colunaAtual = colunaAtualChar - 'a';
        int linhaAtual = 8 - Character.getNumericValue(linhaAtualChar);

        char colunaDestinoChar = coordenadaDestino.toLowerCase().charAt(0);
        char linhaDestinoChar = coordenadaDestino.charAt(1);
        int colunaDestino = colunaDestinoChar - 'a';
        int linhaDestino = 8 - Character.getNumericValue(linhaDestinoChar);

        int diferencaLinha = Math.abs(linhaDestino - linhaAtual);
        int diferencaColuna = Math.abs(colunaDestino - colunaAtual);

        // Verifica movimento em "L" (2x1 ou 1x2)
        if (!((diferencaLinha == 2 && diferencaColuna == 1) || 
              (diferencaLinha == 1 && diferencaColuna == 2))) {
            System.out.println("Movimento inválido para o cavalo.");
            return false;
        }

        // Verifica se o destino está vazio ou tem peça adversária
        Peca pecaNoDestino = tabuleiro.getPeca(linhaDestino, colunaDestino);
        if (pecaNoDestino != null && (pecaNoDestino).getCor().equals(this.cor)) {
            System.out.println("Movimento inválido: destino ocupado por peça da mesma cor.");
            return false;
        }

        // Atualiza tabuleiro
        tabuleiro.atualizarPosicao(linhaAtual, colunaAtual, linhaDestino, colunaDestino, this);
        return true;
    }
}