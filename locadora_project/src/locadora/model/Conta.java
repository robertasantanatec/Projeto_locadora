package locadora.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    private Cliente cliente;
    private double saldoDevedor;
    private List<Locacao> historicoLocacao;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldoDevedor = 0.0; // conforme enunciado
        this.historicoLocacao = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public List<Locacao> getHistoricoLocacao() {
        return historicoLocacao;
    }

    // locar vários filmes de uma vez (array de até 10 conforme enunciado)
    public void locarFilmes(Filme[] filmes) {
        Locacao loc = new Locacao(new Date());
        if (filmes != null) {
            for (Filme f : filmes) {
                if (f != null) {
                    loc.addFilme(f);
                }
            }
        }
        // adiciona ao histórico e atualiza saldo devedor
        historicoLocacao.add(loc);
        saldoDevedor += loc.getValorTotalApagar();
    }

    // retorna extrato histórico formatado
    public String extratoHistorico() {
        StringBuilder sb = new StringBuilder();
        sb.append(".:: Histórico de Locações de ").append(cliente.getNome()).append("::.\n");
        for (Locacao l : historicoLocacao) {
            sb.append(l.toString()).append("\n");
        }
        sb.append("Saldo Devedor: ").append(saldoDevedor).append("\n");
        return sb.toString();
    }

    // paga parte do débito
    public void pagarDebito(double valor) {
        if (valor <= 0) return;
        saldoDevedor -= valor;
        if (saldoDevedor < 0) saldoDevedor = 0;
    }
}
