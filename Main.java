import model.ModelFacade;

public class Main {
    public static void main(String[] args) {
        ModelFacade v = ModelFacade.getInstance(); // Usando Singleton
        System.out.println("Instancia Iniciada");
        
        // Testes de movimento com Tabuleiro
        boolean movimentoValido = v.moverPeca("c2", "c3");
        System.out.println("Movimento c2 -> c3: " + movimentoValido);
        v.imprimirTabuleiro();
        
   
    }
}