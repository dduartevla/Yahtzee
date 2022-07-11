package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogadas;
    private RecyclerView recyclerViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewJogadas = findViewById(R.id.recyclerViewJogadas);
        recyclerViewDados = findViewById(R.id.recyclerViewDados);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewDados.setLayoutManager(layoutManager);
        recyclerViewJogadas.setLayoutManager(layoutManager);
    }
}