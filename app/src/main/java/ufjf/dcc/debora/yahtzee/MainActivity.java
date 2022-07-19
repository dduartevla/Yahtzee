package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogadas;
    private RecyclerView recyclerViewDados;
    private int[] dados;
    private List<Jogada> jogadas;
    private JogadasRepositorio repo;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criaJogadas();

        repo = new JogadasRepositorio(getApplicationContext());
        dados = new int[5];
        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewDados.setLayoutManager(layoutManager);
        recyclerViewJogadas.setLayoutManager(layoutManager);
    }

    public void criaJogadas(){
        jogadas = new ArrayList<Jogada>();

        jogadas.add(new Jogada("Jogada de 1"));
        jogadas.add(new Jogada("Jogada de 2"));
        jogadas.add(new Jogada("Jogada de 3"));
        jogadas.add(new Jogada("Jogada de 4"));
        jogadas.add(new Jogada("Jogada de 5"));
        jogadas.add(new Jogada("Jogada de 6"));
        jogadas.add(new Jogada("Trinca"));
        jogadas.add(new Jogada("Quadra"));
        jogadas.add(new Jogada("Full-House"));
        jogadas.add(new Jogada("Sequencia Alta"));
        jogadas.add(new Jogada("Sequencia Baixa"));
        jogadas.add(new Jogada("General"));

    }
}