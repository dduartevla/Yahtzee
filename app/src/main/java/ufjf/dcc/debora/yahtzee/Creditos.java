package ufjf.dcc.debora.yahtzee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Creditos extends AppCompatActivity {
    Button buttonVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        buttonVoltar = findViewById(R.id.buttonVoltar);
    }

    public void buttonVoltarClick(View view){
        finish();
    }
}