package ufjf.dcc.debora.yahtzee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        holder.textViewCalculaPontos.setText(jogada.getVisualisaPontos().toString());

    }

    @Override
    public int getItemCount() {
        return jogadas.size();
    }

    public class JogadaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewJogadaNome;
        private TextView textViewPontos;
        private TextView textViewCalculaPontos;
        private Button buttonJogar;

        public JogadaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJogadaNome = itemView.findViewById(R.id.textViewJogadaNome);
            textViewPontos = itemView.findViewById(R.id.textViewPontos);
            textViewCalculaPontos = itemView.findViewById(R.id.textViewCalculoPontos);
            buttonJogar = itemView.findViewById(R.id.buttonJogar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onJogadaClick(v,getAdapterPosition());
                }
            });

            itemView.findViewById(R.id.buttonJogar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCheckBoxClick(v,getAdapterPosition());
                    buttonJogar.setClickable(false);
                }
            });
        }
    }

    public interface OnJogadaClickListener{
        void onJogadaClick(View view,int position);
        void onCheckBoxClick(View view, int position);
    }
}


