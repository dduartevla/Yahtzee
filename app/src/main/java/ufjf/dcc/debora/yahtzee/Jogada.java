package ufjf.dcc.debora.yahtzee;

public class Jogada {
    private final String nome;
    private Integer pontos;
    private Integer visualisaPontos;
    private boolean lancada;

    public Jogada (String nome, int pontos){
        this.nome = nome;
        this.pontos = pontos;
        this.visualisaPontos = 0;
        this.lancada = false;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos += pontos;
    }

    public void setVisualisaPontos(Integer pontos) {this.visualisaPontos = pontos;}

    public Integer getVisualisaPontos() {return this.visualisaPontos;}

    public boolean isLancada() {
        return lancada;
    }

    public void setLancada(boolean lancada) {
        this.lancada = lancada;
    }
}
