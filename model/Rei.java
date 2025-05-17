package model;

class Rei extends Peca {
	
    public Rei(String cor) {
        super(cor); // <-- chama o construtor da superclasse Peca
    }
    
    public String getTipo() {
        return "Torre";
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

        int diferencaLinha = linhaDestino - linhaAtual;
        int diferencaColuna = colunaDestino - colunaAtual;

        // Verifica movimento de uma casa em qualquer direção
        if (Math.abs(diferencaLinha) > 1 || Math.abs(diferencaColuna) > 1) {
            System.out.println("Movimento inválido! O rei só pode mover uma casa em qualquer direção.");
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