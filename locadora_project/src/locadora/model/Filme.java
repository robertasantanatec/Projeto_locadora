package locadora.model;

public class Filme {
    private String titulo;
    private String genero;
    private int duracaoMinutos;
    private double valorLocacao;

    public Filme(String titulo, String genero, int duracaoMinutos, double valorLocacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoMinutos = duracaoMinutos;
        this.valorLocacao = valorLocacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
