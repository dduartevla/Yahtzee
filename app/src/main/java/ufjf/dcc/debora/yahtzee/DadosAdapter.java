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

    private List<Integer> dados;
    private DadosAdapter.OnDadosClickListener listener;

    public DadosAdapter(List<Integer> dados, DadosAdapter.OnDadosClickListener listener) {
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
        DadosAdapter.DadosViewHolder viewHolder = new DadosAdapter.DadosViewHolder(dadosView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DadosAdapter.DadosViewHolder holder, int position) {
        //for (int i=0; i<dados.size();i++){

            switch (dados.get(position)){
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
        //}

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewDado;

        public DadosViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDado= itemView.findViewById(R.id.imageViewDado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   listener.onDadosClick(v, getAdapterPosition());
                }
            });

        }
    }

    public interface OnDadosClickListener{
        void onDadosClick(View view,int position);

    }
}
