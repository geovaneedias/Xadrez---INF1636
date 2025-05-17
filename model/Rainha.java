package model;

class Rainha extends Peca {
	
    public Rainha(String cor) {
        super(cor); // <-- chama o construtor da superclasse Peca
    }
    
    public String getTipo() {
        return "Rainha";
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

        // Verifica movimento válido (diagonal ou reto)
        boolean movimentoDiagonal = Math.abs(diferencaLinha) == Math.abs(diferencaColuna);
        boolean movimentoReto = diferencaLinha == 0 || diferencaColuna == 0;

        if (!(movimentoDiagonal || movimentoReto)) {
            System.out.println("Movimento inválido para a rainha!");
            return false;
        }

        // Direção do movimento
        int direcaoLinha = Integer.signum(diferencaLinha);
        int direcaoColuna = Integer.signum(diferencaColuna);

        int linha = linhaAtual + direcaoLinha;
        int coluna = colunaAtual + direcaoColuna;

        // Verifica peças no caminho
        while (linha != linhaDestino || coluna != colunaDestino) {
            if (tabuleiro.getPeca(linha, coluna) != null) {
                System.out.println("Caminho bloqueado! Não é possível mover a rainha.");
                return false;
            }
            linha += direcaoLinha;
            coluna += direcaoColuna;
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