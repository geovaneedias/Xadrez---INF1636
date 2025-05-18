import model.ModelFacade;

public class Main {
    public static void main(String[] args) {
        ModelFacade v = ModelFacade.getInstance(); // Usando Singleton
        System.out.println("Passei por aqui");
        
        // Testes de movimento com Tabuleiro
        boolean movimentoValido = v.moverPeca("e2", "e3");
        System.out.println("Movimento e2 -> e3: " + movimentoValido);
        v.imprimirTabuleiro();
   
    }
}