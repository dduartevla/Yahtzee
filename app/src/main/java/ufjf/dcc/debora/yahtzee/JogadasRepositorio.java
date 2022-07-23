package ufjf.dcc.debora.yahtzee;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

public class JogadasRepositorio {
    private List<Jogada> jogadas;
    private Context context;
    private SharedPreferences preferences;
    private  final String PREFERENCES_NAME = "ufjf.dcc.debora.yahtzee";
    private final String JOGADA_DE_UM_KEY = "JOGADA_DE_UM_KEY";
    private final String JOGADA_DE_DOIS_KEY = "JOGADA_DE_DOIS_KEY";
    private final String JOGADA_DE_TRES_KEY = "JOGADA_DE_TRES_KEY";
    private final String JOGADA_DE_QUATRO_KEY = "JOGADA_DE_QUATRO_KEY";
    private final String JOGADA_DE_CINCO_KEY = "JOGADA_DE_CINCO_KEY";
    private final String JOGADA_DE_SEIS_KEY = "JOGADA_DE_SEIS_KEY";
    private final String TRINCA_KEY = "TRINCA_KEY";
    private final String QUADRA_KEY = "QUADRA_KEY";
    private final String FULLHOUSE_KEY = "FULLHOUSE_KEY";
    private final String SEQUENCIA_BAIXA_KEY = "SEQUENCIA_BAIXA_KEY";
    private final String SEQUENCIA_ALTA_KEY = "SEQUENCIA_ALTA_KEY";
    private final String GENERAL_KEY = "GENERAL_KEY";
    private final String PONTOS_KEY = "PONTOS_KEY";
    private final String NOME_JOGADOR_KEY = "NOME_JOGADOR_KEY";
    private final String JOGADAS_RESTANTES_KEY = "JOGADAS_RESTANTES_KEY";
    private final String LANCAMENTOS_RESTANTES_KEY = "LANCAMENTOS_RESTANTES_KEY";



    public JogadasRepositorio(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        setJogadasRestantes(13);
        setLancamentosRestantes(3);
    }

    //limparepositorio

    public void limpaRepositorio(){

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        /*
        setJogadasRestantes(13);
        setLancamentosRestantes(3);
        zeraPontos();



        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_UM_KEY, 0);
        editor.apply();
        editor.putInt(JOGADA_DE_DOIS_KEY, 0);
        editor.apply();
        editor.putInt(JOGADA_DE_TRES_KEY, 0);
        editor.apply();
        editor.putInt(JOGADA_DE_QUATRO_KEY, 0);
        editor.apply();
        editor.putInt(JOGADA_DE_CINCO_KEY, 0);
        editor.apply();
        editor.putInt(JOGADA_DE_SEIS_KEY, 0);
        editor.apply();
        editor.putInt(TRINCA_KEY, 0);
        editor.apply();
        editor.putInt(QUADRA_KEY, 0);
        editor.apply();
        editor.putInt(FULLHOUSE_KEY, 0);
        editor.apply();
        editor.putInt(SEQUENCIA_ALTA_KEY, 0);
        editor.apply();
        editor.putInt(SEQUENCIA_BAIXA_KEY, 0);
        editor.apply();
        editor.putInt(GENERAL_KEY, 0);
        editor.apply();

         */


    }

    // gets

    public Integer getJogadaDeUm(){
        return preferences.getInt(JOGADA_DE_UM_KEY,0);
    }

    public Integer getJogadaDeDois(){
        return preferences.getInt(JOGADA_DE_DOIS_KEY,0);
    }

    public Integer getJogadaDeTres(){
        return preferences.getInt(JOGADA_DE_TRES_KEY,0);
    }

    public Integer getJogadaDeQuatro(){
        return preferences.getInt(JOGADA_DE_QUATRO_KEY,0);
    }

    public Integer getJogadaDeCinco(){
        return preferences.getInt(JOGADA_DE_CINCO_KEY,0);
    }

    public Integer getJogadaDeSeis(){
        return preferences.getInt(JOGADA_DE_SEIS_KEY,0);
    }

    public Integer getTrinca(){
        return preferences.getInt(TRINCA_KEY,0);
    }

    public Integer getQuadra(){
        return preferences.getInt(QUADRA_KEY,0);
    }

    public Integer getFullhouse(){
        return preferences.getInt(FULLHOUSE_KEY,0);
    }

    public Integer getSequenciaBaixa(){
        return preferences.getInt(SEQUENCIA_BAIXA_KEY,0);
    }

    public Integer getSequenciaAlta(){
        return preferences.getInt(SEQUENCIA_ALTA_KEY,0);
    }

    public Integer getGeneral(){
        return preferences.getInt(GENERAL_KEY,0);
    }

    public Integer getPontos() {return preferences.getInt(PONTOS_KEY,0);}

    public String getNome() {return preferences.getString(NOME_JOGADOR_KEY, " ");}

    public Integer getJogadasRestantes() {return preferences.getInt(JOGADAS_RESTANTES_KEY,0);}

    public Integer getLancamentosRestantes() {return preferences.getInt(LANCAMENTOS_RESTANTES_KEY,0);}



    //Sets

    public void zeraPontos(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PONTOS_KEY,0);
        editor.apply();
    }

    public  void setJogadasRestantes(int jogadasRestantes){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADAS_RESTANTES_KEY,jogadasRestantes);
        editor.apply();
    }

    public void setLancamentosRestantes(int lancamentosRestantes){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(LANCAMENTOS_RESTANTES_KEY,lancamentosRestantes);
        editor.apply();
    }

    public void incJogadasRestantes(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADAS_RESTANTES_KEY,getJogadasRestantes()+1);
        editor.apply();
    }

    public void decJogadasRestantes(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADAS_RESTANTES_KEY,getJogadasRestantes()-1);
        editor.apply();
    }

    public void incLancamentosRestantes(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(LANCAMENTOS_RESTANTES_KEY,getLancamentosRestantes()+1);
        editor.apply();
    }

    public void decLancamentosRestantes(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(LANCAMENTOS_RESTANTES_KEY,getLancamentosRestantes()-1);
        editor.apply();
    }

    public void setNome(String nome){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NOME_JOGADOR_KEY, nome);
        editor.apply();
        editor.apply();
    }

    public void incPontos(int pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PONTOS_KEY, getPontos()+pontos);
        System.out.println(getPontos()+pontos + "repoPontos");
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeUm(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_UM_KEY, getJogadaDeUm()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeDois(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_DOIS_KEY, getJogadaDeDois()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeTres(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_TRES_KEY, getJogadaDeTres()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeQuatro(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_QUATRO_KEY, getJogadaDeQuatro()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeCinco(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_CINCO_KEY, getJogadaDeCinco()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setJogadaDeSeis(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(JOGADA_DE_SEIS_KEY, getJogadaDeSeis()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setTrinca(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TRINCA_KEY, getTrinca()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setQuadra(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(QUADRA_KEY, getQuadra()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setFullhouse(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(FULLHOUSE_KEY, getFullhouse()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setSequenciaBaixa(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SEQUENCIA_BAIXA_KEY, getSequenciaBaixa()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setSequenciaAlta(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SEQUENCIA_ALTA_KEY, getSequenciaAlta()+pontos);
        editor.apply();
        editor.apply();
    }

    public void setGeneral(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(GENERAL_KEY, getGeneral()+pontos);
        editor.apply();
        editor.apply();
    }
}
