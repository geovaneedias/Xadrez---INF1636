package model;

public class ModelFacade {
    private static ModelFacade instance;
    private Tabuleiro t;

    // Construtor privado para evitar instanciação externa
    private ModelFacade() {
        t = new Tabuleiro();
        System.out.println("Tabuleiro Iniciado");
    }

    // Método estático para acessar a instância única
    public static ModelFacade getInstance() {
        if (instance == null) {
            instance = new ModelFacade();
        }
        return instance;
    }
    
    public boolean moverPeca(String coordenadaAtual, String coordenadaDestino) {
        // Obtém a peça na posição atual (usando a conversão já existente no Tabuleiro)
        Peca peca = t.getPeca(
            8 - Character.getNumericValue(coordenadaAtual.charAt(1)),  // linha
            coordenadaAtual.toLowerCase().charAt(0) - 'a'              // coluna
        );

        if (peca == null) {
            System.out.println("Não há peça na posição de origem.");
            return false;
        }

        // Delega o movimento para a peça (ela já faz a conversão internamente)
        return peca.mover(coordenadaAtual, coordenadaDestino, t);
    }
    
    public void imprimirTabuleiro() {
        t.imprimirTabuleiro();
    }
}