package model;

class Bispo extends Peca {
	
    public Bispo(String cor) {
        super(cor); // <-- chama o construtor da superclasse Peca
    }
   
    public String getTipo() {
        return "Bispo";
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

        // Verifica movimento diagonal
        if (Math.abs(diferencaLinha) != Math.abs(diferencaColuna)) {
            System.out.println("Movimento inválido! O bispo só pode se mover na diagonal.");
            return false;
        }

        // Direção do movimento
        int direcaoLinha = Integer.signum(diferencaLinha);
        int direcaoColuna = Integer.signum(diferencaColuna);

        int linha = linhaAtual + direcaoLinha;
        int coluna = colunaAtual + direcaoColuna;

        // Verifica peças no caminho
        while (linha != linhaDestino && coluna != colunaDestino) {
            if (tabuleiro.getPeca(linha, coluna) != null) {
                System.out.println("Caminho bloqueado! Não é possível mover o bispo.");
                return false;
            }
            linha += direcaoLinha;
            coluna += direcaoColuna;
        }

        // Atualiza tabuleiro (delega para o Tabuleiro.java)
        tabuleiro.atualizarPosicao(linhaAtual, colunaAtual, linhaDestino, colunaDestino, this);
        return true;
    }
}