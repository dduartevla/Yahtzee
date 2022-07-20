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


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLancar = findViewById(R.id.buttonLancar);

        criaJogadas();

        repo = new JogadasRepositorio(getApplicationContext());
        dados = new ArrayList<Integer>();
        iniciaDados();
        System.out.println(dados.size());
        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        layoutManagerJogada = new LinearLayoutManager(this);
        recyclerViewJogadas.setLayoutManager(layoutManagerJogada);
        jogadaAdapter = new JogadaAdapter(jogadas,listenerJogadas);
        recyclerViewJogadas.setAdapter(jogadaAdapter);

        layoutManagerDados = new LinearLayoutManager(this);
        recyclerViewDados.setLayoutManager(layoutManagerDados);
        dadosAdapter = new DadosAdapter(dados,listenerDados);
        recyclerViewDados.setAdapter(dadosAdapter);

    }

    public void iniciaDados(){
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

    }

    public void lancar(View view){

        //lança os dados
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            Integer valor = rand.nextInt(6);
            dados.set(i,valor+1);
        }

        CalculaJogadas calculaJogadas = new CalculaJogadas(dados);

        //atualiza os dados
        dadosAdapter = new DadosAdapter(dados,listenerDados);
        recyclerViewDados.setAdapter(dadosAdapter);



        // calcula as possíveis jogadas
        int jogadaDeUm = calculaJogadas.jogadaNum(1);

        int jogadaDeDois = calculaJogadas.jogadaNum(2);

        int jogadaDeTres = calculaJogadas.jogadaNum(3);

        int jogadaDeQuatro = calculaJogadas.jogadaNum(4);

        int jogadaDeCinco = calculaJogadas.jogadaNum(5);

        int jogadaDeSeis = calculaJogadas.jogadaNum(6);

        int trinca = calculaJogadas.trinca();

        int quadra = calculaJogadas.quadra();

        int fullhouse = calculaJogadas.fullHouse();

        int sequenciaAlta = calculaJogadas.sequenciaAlta();

        int sequenciaBaixa = calculaJogadas.sequenciaBaixa();

        int general = calculaJogadas.general();


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
        jogadaAdapter = new JogadaAdapter(jogadas,listenerJogadas);
        recyclerViewJogadas.setAdapter(jogadaAdapter);



    }


}