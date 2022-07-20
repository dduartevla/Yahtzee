package ufjf.dcc.debora.yahtzee;

public class Jogada {
    private final String nome;
    private Integer pontos;
    private Integer visualisaPontos;

    public Jogada (String nome){
        this.nome = nome;
        this.pontos = 0;
        this.visualisaPontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public void setVisualisaPontos(Integer pontos) {this.visualisaPontos = pontos;}

    public Integer getVisualisaPontos() {return this.visualisaPontos;}
}
