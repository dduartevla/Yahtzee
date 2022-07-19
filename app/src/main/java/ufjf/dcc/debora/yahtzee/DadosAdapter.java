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

public class DadosAdapter extends RecyclerView.Adapter<DadosAdapter.DadosViewHolder> {

    private List<Integer> dados;
    private DadosAdapter.OnDadosClickListener listener;

    public DadosAdapter(List<Integer> dados, DadosAdapter.OnDadosClickListener listener) {
        this.dados = dados;
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
        //como vou colocar os dados
        //uma imagem?
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder{



        public DadosViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    public interface OnDadosClickListener{
        void onDadosClick(View view,int position);
    }
}
