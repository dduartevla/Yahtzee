package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogadas;
    private RecyclerView recyclerViewDados;
    private List<Integer> dados;
    private List<Jogada> jogadas;
    private JogadasRepositorio repo;
    private Button buttonLancar;
    JogadaAdapter jogadaAdapter;
    JogadaAdapter.OnJogadaClickListener listenerJogadas;
    DadosAdapter dadosAdapter;
    DadosAdapter.OnDadosClickListener listenerDados;
    LinearLayoutManager layoutManagerJogada;
    LinearLayoutManager layoutManagerDados;

    boolean[] viewClicked;

    // pontos das jogadas
    int jogadaDeUm;
    int jogadaDeDois;
    int jogadaDeTres;
    int jogadaDeQuatro;
    int jogadaDeCinco;
    int jogadaDeSeis;
    int trinca;
    int quadra;
    int fullhouse;
    int sequenciaAlta;
    int sequenciaBaixa;
    int general;

    int contadorLancamentos = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewClicked = new boolean[13];
        iniciaViewClicked();

        buttonLancar = findViewById(R.id.buttonLancar);

        repo = new JogadasRepositorio(getApplicationContext());
        criaJogadas();
        dados = new ArrayList<Integer>();
        iniciaDados();
        System.out.println(dados.size());
        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        layoutManagerJogada = new LinearLayoutManager(this);
        recyclerViewJogadas.setLayoutManager(layoutManagerJogada);


        layoutManagerDados = new LinearLayoutManager(this);
        recyclerViewDados.setLayoutManager(layoutManagerDados);
        dadosAdapter = new DadosAdapter(dados,listenerDados);
        recyclerViewDados.setAdapter(dadosAdapter);

        listenerJogadas = new JogadaAdapter.OnJogadaClickListener() {
            @Override
            public void onJogadaClick(View view, int position) {

                contadorLancamentos = 0;

                if (viewClicked[position] == true){ // impede mais de um clicque na mesma jogada
                    //lançar mensagem para usuário aqui
                } else {
                    viewClicked[position] = true;

                    switch (position) {
                        case 0:
                            jogadas.get(position).setPontos(jogadaDeUm);
                            repo.setJogadaDeUm(jogadaDeUm);
                            break;

                        case 1:
                            jogadas.get(position).setPontos(jogadaDeDois);
                            repo.setJogadaDeDois(jogadaDeDois);
                            break;

                        case 2:
                            jogadas.get(position).setPontos(jogadaDeTres);
                            repo.setJogadaDeTres(jogadaDeTres);
                            break;

                        case 3:
                            jogadas.get(position).setPontos(jogadaDeQuatro);
                            repo.setJogadaDeQuatro(jogadaDeQuatro);
                            break;

                        case 4:
                            jogadas.get(position).setPontos(jogadaDeCinco);
                            repo.setJogadaDeCinco(jogadaDeCinco);
                            break;

                        case 5:
                            jogadas.get(position).setPontos(jogadaDeSeis);
                            repo.setJogadaDeSeis(jogadaDeSeis);
                            break;

                        case 6:
                            jogadas.get(position).setPontos(trinca);
                            repo.setTrinca(trinca);
                            break;

                        case 7:
                            jogadas.get(position).setPontos(quadra);
                            repo.setQuadra(quadra);
                            break;

                        case 8:
                            jogadas.get(position).setPontos(fullhouse);
                            repo.setFullhouse(fullhouse);
                            break;

                        case 9:
                            jogadas.get(position).setPontos(sequenciaAlta);
                            repo.setSequenciaAlta(sequenciaAlta);
                            break;

                        case 10:
                            jogadas.get(position).setPontos(sequenciaBaixa);
                            repo.setSequenciaBaixa(sequenciaBaixa);
                            break;

                        case 11:
                            jogadas.get(position).setPontos(general);
                            repo.setGeneral(general);
                            break;
                    }
                    jogadaAdapter.notifyItemChanged(position);
                    jogadaAdapter.setClickable(false);
                }

            }

            @Override
            public void setCliclableView(View view, int position) {

            }

        };

        jogadaAdapter = new JogadaAdapter(jogadas,listenerJogadas);
        recyclerViewJogadas.setAdapter(jogadaAdapter);

    }

    private void iniciaViewClicked(){
        for (int i=0; i<viewClicked.length; i++){
            viewClicked[i] = false;
        }
    }

    private void iniciaDados(){
        for (int i=0; i<5;i++){
            dados.add(1);
        }
    }

    public void tempImprimeDados(){
        for(int i=0; i<dados.size();i++){
            System.out.println(dados.get(i) + "temp");
        }
    }

    public void criaJogadas(){
        jogadas = new ArrayList<Jogada>();

        jogadas.add(new Jogada("Jogada de 1: "));
        jogadas.add(new Jogada("Jogada de 2: "));
        jogadas.add(new Jogada("Jogada de 3: "));
        jogadas.add(new Jogada("Jogada de 4: "));
        jogadas.add(new Jogada("Jogada de 5: "));
        jogadas.add(new Jogada("Jogada de 6: "));
        jogadas.add(new Jogada("Trinca: "));
        jogadas.add(new Jogada("Quadra: "));
        jogadas.add(new Jogada("Full-House: "));
        jogadas.add(new Jogada("Sequencia Alta: "));
        jogadas.add(new Jogada("Sequencia Baixa: "));
        jogadas.add(new Jogada("General: "));

        //sharedpreferences aqui testa null no início

    }

    public void lancar(View view){

        if (jogadaAdapter.getClickable() == false){
            jogadaAdapter.setClickable(true);
        }

        if (contadorLancamentos <3) {
            contadorLancamentos++;

            //lança os dados
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                Integer valor = rand.nextInt(6);
                dados.set(i, valor + 1);
            }

            CalculaJogadas calculaJogadas = new CalculaJogadas(dados);

            //atualiza os dados
            dadosAdapter = new DadosAdapter(dados, listenerDados);
            recyclerViewDados.setAdapter(dadosAdapter);


            // calcula as possíveis jogadas
            jogadaDeUm = calculaJogadas.jogadaNum(1);

            jogadaDeDois = calculaJogadas.jogadaNum(2);

            jogadaDeTres = calculaJogadas.jogadaNum(3);

            jogadaDeQuatro = calculaJogadas.jogadaNum(4);

            jogadaDeCinco = calculaJogadas.jogadaNum(5);

            jogadaDeSeis = calculaJogadas.jogadaNum(6);

            trinca = calculaJogadas.trinca();

            quadra = calculaJogadas.quadra();

            fullhouse = calculaJogadas.fullHouse();

            sequenciaAlta = calculaJogadas.sequenciaAlta();

            sequenciaBaixa = calculaJogadas.sequenciaBaixa();

            general = calculaJogadas.general();


            // coloca os pontos para visualização nas Jogadas
            jogadas.get(0).setVisualisaPontos(jogadaDeUm);
            jogadas.get(1).setVisualisaPontos(jogadaDeDois);
            jogadas.get(2).setVisualisaPontos(jogadaDeTres);
            jogadas.get(3).setVisualisaPontos(jogadaDeQuatro);
            jogadas.get(4).setVisualisaPontos(jogadaDeCinco);
            jogadas.get(5).setVisualisaPontos(jogadaDeSeis);
            jogadas.get(6).setVisualisaPontos(trinca);
            jogadas.get(7).setVisualisaPontos(quadra);
            jogadas.get(8).setVisualisaPontos(fullhouse);
            jogadas.get(9).setVisualisaPontos(sequenciaAlta);
            jogadas.get(10).setVisualisaPontos(sequenciaBaixa);
            jogadas.get(11).setVisualisaPontos(general);

            //apresenta os pontos para visualização para o usuário
            for (int i=0; i<jogadas.size(); i++){
                jogadaAdapter.notifyItemChanged(i);
            }

        }
    }


}