package ufjf.dcc.debora.yahtzee;

public class Jogada {
    private final String nome;
    private int pontos;

    public Jogada (String nome, int pontos){
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
