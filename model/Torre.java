package model;

class Torre extends Peca {
	
    public Torre(String cor) {
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

        // Verifica movimento em linha reta
        boolean movimentoHorizontal = (linhaAtual == linhaDestino);
        boolean movimentoVertical = (colunaAtual == colunaDestino);

        if (!(movimentoHorizontal || movimentoVertical)) {
            System.out.println("Movimento inválido! A torre só pode andar em linha reta.");
            return false;
        }

        // Verifica peças no caminho
        if (movimentoHorizontal) {
            int passo = colunaDestino > colunaAtual ? 1 : -1;
            for (int c = colunaAtual + passo; c != colunaDestino; c += passo) {
                if (tabuleiro.getPeca(linhaAtual, c) != null) {
                    System.out.println("Há peças no caminho!");
                    return false;
                }
            }
        } else { // movimentoVertical
            int passo = linhaDestino > linhaAtual ? 1 : -1;
            for (int l = linhaAtual + passo; l != linhaDestino; l += passo) {
                if (tabuleiro.getPeca(l, colunaAtual) != null) {
                    System.out.println("Há peças no caminho!");
                    return false;
                }
            }
        }

        // Verifica se o destino está vazio ou tem peça adversária
        Peca pecaNoDestino = tabuleiro.getPeca(linhaDestino, colunaDestino);
        if (pecaNoDestino != null) {
            if (pecaNoDestino.getCor().equals(this.cor)) {
                System.out.println("Movimento inválido: destino ocupado por peça da mesma cor.");
                return false;
            } else {
                System.out.println("Peça inimiga removida");
                // Aqui poderia haver lógica para remoção/captura
            }
        }

        // Atualiza tabuleiro
        tabuleiro.atualizarPosicao(linhaAtual, colunaAtual, linhaDestino, colunaDestino, this);
        return true;
    }
}