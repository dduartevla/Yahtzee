package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogadas;
    private RecyclerView recyclerViewDados;
    private int[] dados;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dados = new int[5];
        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewDados.setLayoutManager(layoutManager);
        recyclerViewJogadas.setLayoutManager(layoutManager);
    }
}