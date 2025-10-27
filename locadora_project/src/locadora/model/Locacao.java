package locadora.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao {
    private Date dataLocacao;
    private List<Filme> listaFilmes;
    private double valorTotalApagar;

    public Locacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
        this.listaFilmes = new ArrayList<>();
        this.valorTotalApagar = 0.0;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public double getValorTotalApagar() {
        return valorTotalApagar;
    }

    // adiciona um filme na locação e incrementa o valor total
    public void addFilme(Filme filme) {
        if (filme == null) return;
        listaFilmes.add(filme);
        valorTotalApagar += filme.getValorLocacao();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dataLocacao.toString()).append(" ");
        for (int i = 0; i < listaFilmes.size(); i++) {
            sb.append(listaFilmes.get(i).getTitulo());
            if (i < listaFilmes.size() - 1) sb.append(", ");
        }
        sb.append(" ").append(valorTotalApagar);
        return sb.toString();
    }
}
