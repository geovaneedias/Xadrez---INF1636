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

    public boolean mover(int tipoMovimento, String coordenadaAtual, Tabuleiro tabuleiro) {
        if (tipoMovimento == 2 && !posicao.equals("original")) {
            System.out.println("Erro: Peão só pode avançar 2 casas na posição inicial.");
            return false;
        }

        // Converte coordenada (ex: "e2") para índices da matriz
        char colunaChar = coordenadaAtual.toLowerCase().charAt(0);
        char linhaChar = coordenadaAtual.charAt(1);
        int coluna = colunaChar - 'a';  // 'a' -> 0, 'b' -> 1, etc.
        int linha = 8 - Character.getNumericValue(linhaChar);  // '2' -> 6, '7' -> 1, etc.

        // Direção do movimento (peões brancos sobem, pretos descem)
        int direcao = cor.equals("branca") ? -1 : 1;

        // Valida movimento
        if (tipoMovimento == 1 || tipoMovimento == 2) {
            int novaLinha = linha + (direcao * tipoMovimento);

            // Verifica se a nova posição está dentro do tabuleiro
            if (novaLinha >= 0 && novaLinha < 8) {
                tabuleiro.atualizarPosicao(linha, coluna, novaLinha, coluna, this);
                posicao = "diferente";
                return true;
            }
        }

        System.out.println("Movimento inválido para o peão.");
        return false;
    }
}