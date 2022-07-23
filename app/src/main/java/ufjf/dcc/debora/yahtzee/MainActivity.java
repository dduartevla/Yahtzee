package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPontos;
    private TextView textViewJogadasRestantes;
    private TextView textViewLancamentosRestantes;
    private ImageView imageViewFiltroJogadas;


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


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPontos = findViewById(R.id.textViewPontosMain);
        textViewJogadasRestantes = findViewById(R.id.textViewJogadas);
        textViewLancamentosRestantes = findViewById(R.id.textViewLancamentos);
        imageViewFiltroJogadas = findViewById(R.id.imageViewFiltroJogadas);

        viewClicked = new boolean[13];
        iniciaViewClicked();

        buttonLancar = findViewById(R.id.buttonLancar);

        repo = new JogadasRepositorio(getApplicationContext());

        textViewPontos.setText(repo.getPontos().toString());
        textViewJogadasRestantes.setText(repo.getJogadasRestantes().toString());
        textViewLancamentosRestantes.setText(repo.getLancamentosRestantes().toString());


        dados = new ArrayList<Dado>();
        iniciaDados();
        setJogadasRepo();
        criaJogadas();

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

                jogadas.get(position).setLancada(true);



                imageViewFiltroJogadas.setVisibility(View.VISIBLE);
                imageViewFiltroJogadas.bringToFront();

                repo.setLancamentosRestantes(3);
                repo.decJogadasRestantes();

                textViewJogadasRestantes.setText(repo.getJogadasRestantes().toString());


                iniciaDados(); //reinicia os dados, mas não muda as imagens
                dadosAdapter = new DadosAdapter(dados,listenerDados);
                recyclerViewDados.setAdapter(dadosAdapter);


                //reinicia o recylerView dos dados
                dadosAdapter.notifyDataSetChanged();

                if (jogadas.get(position).isLancada() == true){ // impede mais de um clicque na mesma jogada
                    Toast.makeText(MainActivity.this,"Jogada já marcada!" ,Toast.LENGTH_SHORT).show();
                } else {


                    switch (position) {
                        case 0:
                            jogadas.get(position).setPontos(jogadaDeUm);
                            repo.setJogadaDeUm(jogadaDeUm);
                            repo.incPontos(jogadaDeUm);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeUm + " pontos na Jogada de Um." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            jogadas.get(position).setPontos(jogadaDeDois);
                            repo.setJogadaDeDois(jogadaDeDois);
                            repo.incPontos(jogadaDeDois);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeDois + " pontos na Jogada de Dois." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 2:
                            jogadas.get(position).setPontos(jogadaDeTres);
                            repo.setJogadaDeTres(jogadaDeTres);
                            repo.incPontos(jogadaDeTres);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeTres + " pontos na Jogada de Três." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 3:
                            jogadas.get(position).setPontos(jogadaDeQuatro);
                            repo.setJogadaDeQuatro(jogadaDeQuatro);
                            repo.incPontos(jogadaDeQuatro);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeQuatro + " pontos na Jogada de Quatro." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 4:
                            jogadas.get(position).setPontos(jogadaDeCinco);
                            repo.setJogadaDeCinco(jogadaDeCinco);
                            repo.incPontos(jogadaDeCinco);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeCinco + " pontos na Jogada de Cinco." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 5:
                            jogadas.get(position).setPontos(jogadaDeSeis);
                            repo.setJogadaDeSeis(jogadaDeSeis);
                            repo.incPontos(jogadaDeSeis);
                            Toast.makeText(MainActivity.this,"Você marcou " + jogadaDeSeis + " pontos na Jogada de Seis." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 6:
                            jogadas.get(position).setPontos(trinca);
                            repo.setTrinca(trinca);
                            repo.incPontos(trinca);
                            Toast.makeText(MainActivity.this,"Você marcou " + trinca + " pontos na jagada Trinca." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 7:
                            jogadas.get(position).setPontos(quadra);
                            repo.setQuadra(quadra);
                            repo.incPontos(quadra);
                            Toast.makeText(MainActivity.this,"Você marcou " + quadra + " pontos na jogada Quadra." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 8:
                            jogadas.get(position).setPontos(fullhouse);
                            repo.setFullhouse(fullhouse);
                            repo.incPontos(fullhouse);
                            Toast.makeText(MainActivity.this,"Você marcou " + fullhouse + " pontos na jogada Full-House." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 9:
                            jogadas.get(position).setPontos(sequenciaAlta);
                            repo.setSequenciaAlta(sequenciaAlta);
                            repo.incPontos(sequenciaAlta);
                            Toast.makeText(MainActivity.this,"Você marcou " + sequenciaAlta + " pontos na jogada Sequência Alta." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 10:
                            jogadas.get(position).setPontos(sequenciaBaixa);
                            repo.setSequenciaBaixa(sequenciaBaixa);
                            repo.incPontos(sequenciaBaixa);
                            Toast.makeText(MainActivity.this,"Você marcou " + sequenciaBaixa + " pontos na jogada Sequência Baixa." ,Toast.LENGTH_SHORT).show();
                            break;

                        case 11:
                            jogadas.get(position).setPontos(general);
                            repo.setGeneral(general);
                            repo.incPontos(general);
                            Toast.makeText(MainActivity.this,"Você marcou " + general + " pontos na jogada General." ,Toast.LENGTH_SHORT).show();
                            break;
                    }

                    textViewPontos.setText(repo.getPontos().toString());
                    jogadaAdapter.notifyItemChanged(position);
                    System.out.println(repo.getJogadasRestantes() + "Jogadas Restantes");
                    if (repo.getJogadasRestantes() == 0){
                        reinicia();
                    }
                }

            }

            @Override
            public void setCliclableView(View view, int position) {

            }

        };

        jogadaAdapter = new JogadaAdapter(jogadas,listenerJogadas);
        recyclerViewJogadas.setAdapter(jogadaAdapter);

    }

    public void setJogadasRepo(){
         jogadaDeUm = repo.getJogadaDeUm();
         jogadaDeDois = repo.getJogadaDeDois();
         jogadaDeTres = repo.getJogadaDeTres();
         jogadaDeQuatro = repo.getJogadaDeQuatro();
         jogadaDeCinco = repo.getJogadaDeCinco();
         jogadaDeSeis = repo.getJogadaDeSeis();
         trinca = repo.getTrinca();
         quadra = repo.getQuadra();
         fullhouse = repo.getFullhouse();
         sequenciaAlta = repo.getSequenciaAlta();
         sequenciaBaixa = repo.getSequenciaBaixa();
         general = repo.getGeneral();

    }

    public void botaoReiniciarClick(View view){
        reinicia();
    }

    public void reinicia(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Reiniciar o Jogo");
        dialogBuilder.setMessage("Deseja reiniciar o jogo?");
        dialogBuilder.setPositiveButton("Reiniciar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        iniciaJogo();
                    }
                }
        );
        dialogBuilder.create();
        dialogBuilder.show();
    }

    private void iniciaJogo(){
        repo.limpaRepositorio();
        System.out.println(repo.getJogadaDeUm());
        jogadas.clear();
        setJogadasRepo();
        criaJogadas();
        dados.clear();
        iniciaDados();


        jogadaAdapter = new JogadaAdapter(jogadas,listenerJogadas);
        recyclerViewJogadas.setAdapter(jogadaAdapter);

        textViewJogadasRestantes.setText(repo.getJogadasRestantes().toString());
        textViewLancamentosRestantes.setText(repo.getLancamentosRestantes().toString());
        textViewPontos.setText(repo.getPontos().toString());


        if (jogadaAdapter.getClickable() == false){
            jogadaAdapter.setClickable(true);
        }

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

    public void destravaDados(View view){
    }

    private void iniciaDados(){
        dados.clear();
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

        jogadas.add(new Jogada("Jogada de 1: ", jogadaDeUm));
        jogadas.add(new Jogada("Jogada de 2: ", jogadaDeDois));
        jogadas.add(new Jogada("Jogada de 3: ", jogadaDeTres));
        jogadas.add(new Jogada("Jogada de 4: ", jogadaDeQuatro));
        jogadas.add(new Jogada("Jogada de 5: ", jogadaDeCinco));
        jogadas.add(new Jogada("Jogada de 6: ", jogadaDeSeis));
        jogadas.add(new Jogada("Trinca: ", trinca));
        jogadas.add(new Jogada("Quadra: ", quadra));
        jogadas.add(new Jogada("Full-House: ", fullhouse));
        jogadas.add(new Jogada("Sequencia Alta: ", sequenciaAlta));
        jogadas.add(new Jogada("Sequencia Baixa: ", sequenciaBaixa));
        jogadas.add(new Jogada("General: ", general));

        //sharedpreferences aqui testa null no início

    }

    public void lancar(View view){

        imageViewFiltroJogadas.setVisibility(View.GONE);

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
            jogadaAdapter.notifyDataSetChanged();

        }
    }


}