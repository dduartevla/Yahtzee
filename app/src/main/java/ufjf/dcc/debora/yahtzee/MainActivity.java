package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPontos;
    private TextView textViewJogadasRestantes;
    private TextView textViewLancamentosRestantes;


    private RecyclerView recyclerViewJogadas;
    private RecyclerView recyclerViewDados;
    private List<Dado> dados;
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

    int contadorLancamentos = 3;
    int contadorJogadas = 13;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPontos = findViewById(R.id.textViewPontosMain);
        textViewJogadasRestantes = findViewById(R.id.textViewJogadas);
        textViewLancamentosRestantes = findViewById(R.id.textViewLancamentos);

        viewClicked = new boolean[13];
        iniciaViewClicked();

        buttonLancar = findViewById(R.id.buttonLancar);

        repo = new JogadasRepositorio(getApplicationContext());

        textViewPontos.setText(repo.getPontos().toString());
        textViewJogadasRestantes.setText(repo.getJogadasRestantes().toString());
        textViewLancamentosRestantes.setText(repo.getLancamentosRestantes().toString());

        criaJogadas();
        dados = new ArrayList<Dado>();
        iniciaDados();

        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        layoutManagerJogada = new LinearLayoutManager(this);
        recyclerViewJogadas.setLayoutManager(layoutManagerJogada);


        layoutManagerDados = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true);
        recyclerViewDados.setLayoutManager(layoutManagerDados);

        //listener de dados
        listenerDados = new DadosAdapter.OnDadosClickListener() {
            @Override
            public void onDadosClick(View view, int position, View imageView) {

                if (contaDadosTravados() < 4) {

                    if (dados.get(position).travado == false) {
                        dados.get(position).travado = true;
                    } else {
                        dados.get(position).travado = false;
                    }

                    if (dados.get(position).travado == false) {
                        imageView.setVisibility(View.INVISIBLE);
                    } else {
                        imageView.setVisibility(View.VISIBLE);
                    }

                }
            }
        };

        dadosAdapter = new DadosAdapter(dados,listenerDados);
        recyclerViewDados.setAdapter(dadosAdapter);

        //listener de Jogadas
        listenerJogadas = new JogadaAdapter.OnJogadaClickListener() {
            @Override
            public void onJogadaClick(View view, int position) {

                repo.setLancamentosRestantes(3);
                repo.decJogadasRestantes();

                textViewJogadasRestantes.setText(repo.getJogadasRestantes().toString());

                iniciaDados(); //reinicia os dados, mas não muda as imagens
                destravaDados(); //destrava os dados travados

                //reinicia o recylerView dos dados
                dadosAdapter = new DadosAdapter(dados,listenerDados);
                recyclerViewDados.setAdapter(dadosAdapter);

                if (viewClicked[position] == true){ // impede mais de um clicque na mesma jogada
                    //lançar mensagem para usuário aqui
                } else {
                    viewClicked[position] = true;

                    switch (position) {
                        case 0:
                            jogadas.get(position).setPontos(jogadaDeUm);
                            repo.setJogadaDeUm(jogadaDeUm);
                            repo.incPontos(jogadaDeUm);
                            break;

                        case 1:
                            jogadas.get(position).setPontos(jogadaDeDois);
                            repo.setJogadaDeDois(jogadaDeDois);
                            repo.incPontos(jogadaDeDois);
                            break;

                        case 2:
                            jogadas.get(position).setPontos(jogadaDeTres);
                            repo.setJogadaDeTres(jogadaDeTres);
                            repo.incPontos(jogadaDeTres);
                            break;

                        case 3:
                            jogadas.get(position).setPontos(jogadaDeQuatro);
                            repo.setJogadaDeQuatro(jogadaDeQuatro);
                            repo.incPontos(jogadaDeQuatro);
                            break;

                        case 4:
                            jogadas.get(position).setPontos(jogadaDeCinco);
                            repo.setJogadaDeCinco(jogadaDeCinco);
                            repo.incPontos(jogadaDeCinco);
                            break;

                        case 5:
                            jogadas.get(position).setPontos(jogadaDeSeis);
                            repo.setJogadaDeSeis(jogadaDeSeis);
                            repo.incPontos(jogadaDeSeis);
                            break;

                        case 6:
                            jogadas.get(position).setPontos(trinca);
                            repo.setTrinca(trinca);
                            repo.incPontos(trinca);
                            break;

                        case 7:
                            jogadas.get(position).setPontos(quadra);
                            repo.setQuadra(quadra);
                            repo.incPontos(quadra);
                            break;

                        case 8:
                            jogadas.get(position).setPontos(fullhouse);
                            repo.setFullhouse(fullhouse);
                            repo.incPontos(fullhouse);
                            break;

                        case 9:
                            jogadas.get(position).setPontos(sequenciaAlta);
                            repo.setSequenciaAlta(sequenciaAlta);
                            repo.incPontos(sequenciaAlta);
                            break;

                        case 10:
                            jogadas.get(position).setPontos(sequenciaBaixa);
                            repo.setSequenciaBaixa(sequenciaBaixa);
                            repo.incPontos(sequenciaBaixa);
                            break;

                        case 11:
                            jogadas.get(position).setPontos(general);
                            repo.setGeneral(general);
                            repo.incPontos(general);
                            break;
                    }
                    textViewPontos.setText(repo.getPontos().toString());
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

    private int contaDadosTravados(){
        int cont = 0;
        for (int i=0; i<dados.size(); i++){
            if (dados.get(i).travado ==true)
                cont++;
        }
       return cont;
    }

    private void iniciaViewClicked(){
        for (int i=0; i<viewClicked.length; i++){
            viewClicked[i] = false;
        }
    }

    private void destravaDados(){
        for (int i=0; i<dados.size(); i++){
            dados.get(i).travado = false;
        }
    }

    private void iniciaDados(){

        for (int i=0; i<5;i++){
            Dado novoDado = new Dado();
            dados.add(novoDado);
        }
    }

    public void tempImprimeDados(List coisas){
        for(int i=0; i<coisas.size();i++){
            System.out.println(coisas.get(i) + "temp " +i);
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

        if (repo.getLancamentosRestantes() > 0) {
            repo.decLancamentosRestantes();
            textViewLancamentosRestantes.setText(repo.getLancamentosRestantes().toString());

            //lança os dados
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                Integer valor = rand.nextInt(6);
                if (dados.get(i).travado == false)
                    dados.get(i).valor = valor + 1;

            }

            CalculaJogadas calculaJogadas = new CalculaJogadas(dados);

            //atualiza os dados
            dadosAdapter.notifyDataSetChanged();


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