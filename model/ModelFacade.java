package model;

public class ModelFacade {
    private static ModelFacade instance;
    private Tabuleiro t;

    // Construtor privado para evitar instanciação externa
    private ModelFacade() {
        t = new Tabuleiro();
        System.out.println("Passei por aqui");
    }

    // Método estático para acessar a instância única
    public static ModelFacade getInstance() {
        if (instance == null) {
            instance = new ModelFacade();
        }
        return instance;
    }
}