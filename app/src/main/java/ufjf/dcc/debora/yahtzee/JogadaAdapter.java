package ufjf.dcc.debora.yahtzee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JogadaAdapter extends RecyclerView.Adapter<JogadaAdapter.JogadaViewHolder>{
    private List<Jogada> jogadas;
    private OnJogadaClickListener listener;

    public JogadaAdapter(List<Jogada> jogadas, OnJogadaClickListener listener) {
        this.jogadas = jogadas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JogadaAdapter.JogadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View jogadaView = inflater.inflate(R.layout.jogada_layout,parent,false);
        JogadaViewHolder viewHolder = new JogadaViewHolder(jogadaView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JogadaAdapter.JogadaViewHolder holder, int position) {
        Jogada jogada = jogadas.get(position);
        holder.textViewJogadaNome.setText(jogada.getNome().toString());
        holder.textViewPontos.setText(jogada.getPontos().toString());

    }

    @Override
    public int getItemCount() {
        return jogadas.size();
    }

    public class JogadaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewJogadaNome;
        private TextView textViewPontos;
        private TextView textViewCalculaPontos;
        private CheckBox checkBoxJogar;

        public JogadaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJogadaNome = itemView.findViewById(R.id.textViewJogadaNome);
            textViewPontos = itemView.findViewById(R.id.textViewPontos);
            textViewCalculaPontos = itemView.findViewById(R.id.textViewCalculoPontos);
            checkBoxJogar = itemView.findViewById(R.id.checkBoxJogar);
        }
    }

    public interface OnJogadaClickListener{
        void onJogadaClick(View view,int position);
    }
}


