import model.ModelFacade;

public class Main {
    public static void main(String[] args) {
        ModelFacade v = ModelFacade.getInstance(); // Usando Singleton
        System.out.println("Passei por aqui");
    }
}