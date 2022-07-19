package ufjf.dcc.debora.yahtzee;

public class Jogada {
    private final String nome;
    private Integer pontos;

    public Jogada (String nome){
        this.nome = nome;
        this.pontos = 0;
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
}
