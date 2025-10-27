package locadora.app;

import locadora.model.Cliente;
import locadora.model.Conta;
import locadora.model.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        // criar filmes (ao menos 10)
        List<Filme> catalogo = new ArrayList<>();
        catalogo.add(new Filme("Salt", "Ação", 100, 3.5));
        catalogo.add(new Filme("Heroes", "Ação", 45, 2.0));
        catalogo.add(new Filme("X-Men First Class", "Ficção", 110, 5.0));
        catalogo.add(new Filme("Inception", "Ficção", 148, 6.0));
        catalogo.add(new Filme("The Shawshank Redemption", "Drama", 142, 4.5));
        catalogo.add(new Filme("The Godfather", "Drama", 175, 5.5));
        catalogo.add(new Filme("Toy Story", "Animação", 81, 2.5));
        catalogo.add(new Filme("Finding Nemo", "Animação", 100, 2.5));
        catalogo.add(new Filme("Interstellar", "Ficção", 169, 6.5));
        catalogo.add(new Filme("Parasite", "Suspense", 132, 4.0));

        // criar clientes (3 a 5)
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Danilo Farias", "11111111111"));
        clientes.add(new Cliente("Maria Silva", "22222222222"));
        clientes.add(new Cliente("João Souza", "33333333333"));
        clientes.add(new Cliente("Ana Pereira", "44444444444"));

        // criar contas e associar
        for (Cliente c : clientes) {
            Conta conta = new Conta(c);
            c.setConta(conta);
        }

        Random rnd = new Random(12345);

        // para cada cliente criar 4 a 6 locações, cada locação 1 a 5 filmes
        for (Cliente c : clientes) {
            int numLocacoes = 4 + rnd.nextInt(3); // 4..6
            for (int i = 0; i < numLocacoes; i++) {
                int numFilmes = 1 + rnd.nextInt(5); // 1..5
                Filme[] filmesParaLocacao = new Filme[numFilmes];
                for (int f = 0; f < numFilmes; f++) {
                    // escolher aleatoriamente do catálogo
                    Filme escolhido = catalogo.get(rnd.nextInt(catalogo.size()));
                    filmesParaLocacao[f] = escolhido;
                }
                c.getConta().locarFilmes(filmesParaLocacao);
            }
        }

        // imprimir extrato de cada cliente
        for (Cliente c : clientes) {
            System.out.println(c.getConta().extratoHistorico());
        }

        // exemplo de pagamento em um cliente
        Cliente exemplo = clientes.get(0);
        System.out.println("Antes do pagamento, saldo devedor de " + exemplo.getNome() + ": " + exemplo.getConta().getSaldoDevedor());
        exemplo.getConta().pagarDebito(10.0);
        System.out.println("Após pagamento de 10.0, saldo devedor: " + exemplo.getConta().getSaldoDevedor());
    }
}
