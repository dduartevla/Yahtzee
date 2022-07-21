package ufjf.dcc.debora.yahtzee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DadosAdapter extends RecyclerView.Adapter<DadosAdapter.DadosViewHolder> {

    private List<Dado> dados;
    private DadosAdapter.OnDadosClickListener listener;
    private DadosAdapter.DadosViewHolder viewHolder;

    public DadosAdapter(List<Dado> dados, DadosAdapter.OnDadosClickListener listener) {
        this.dados = dados;
        System.out.println(dados.size());
        this.listener = listener;
    }

    @NonNull
    @Override
    public DadosAdapter.DadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View dadosView = inflater.inflate(R.layout.dado_layout,parent,false);
        viewHolder = new DadosAdapter.DadosViewHolder(dadosView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DadosAdapter.DadosViewHolder holder, int position) {

            switch (dados.get(position).valor) {
                case 1:
                    holder.imageViewDado.setImageResource(R.drawable.d1);
                    break;

                case 2:
                    holder.imageViewDado.setImageResource(R.drawable.d2);
                    break;

                case 3:
                    holder.imageViewDado.setImageResource(R.drawable.d3);
                    break;

                case 4:
                    holder.imageViewDado.setImageResource(R.drawable.d4);
                    break;

                case 5:
                    holder.imageViewDado.setImageResource(R.drawable.d5);
                    break;

                case 6:
                    holder.imageViewDado.setImageResource(R.drawable.d6);
                    break;
            }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public DadosViewHolder getViewHolder() {
        return viewHolder;
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewDado;
        ImageView imageViewFiltro;

        public DadosViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDado= itemView.findViewById(R.id.imageViewDado);
            imageViewFiltro = itemView.findViewById(R.id.imageViewFiltro);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   listener.onDadosClick(v, getAdapterPosition(), imageViewFiltro);
                }
            });

        }
    }

    public interface OnDadosClickListener{
        void onDadosClick(View view,int position, View imageView);

    }
}
