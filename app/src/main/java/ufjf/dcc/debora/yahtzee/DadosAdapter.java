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
        System.out.println(dados.size());
        setImageViewDado1(holder,dados.get(0));
        setImageViewDado2(holder,dados.get(1));
        setImageViewDado3(holder,dados.get(2));
        setImageViewDado4(holder,dados.get(3));
        setImageViewDado5(holder,dados.get(4));
    }

    private void setImageViewDado1(@NonNull DadosAdapter.DadosViewHolder holder,int num){
        switch (num){
            case 1:
                holder.imageViewDado1.setImageResource(R.drawable.d1);
                break;

            case 2:
                holder.imageViewDado1.setImageResource(R.drawable.d2);
                break;

            case 3:
                holder.imageViewDado1.setImageResource(R.drawable.d3);
                break;

            case 4:
                holder.imageViewDado1.setImageResource(R.drawable.d4);
                break;

            case 5:
                holder.imageViewDado1.setImageResource(R.drawable.d5);
                break;

            case 6:
                holder.imageViewDado1.setImageResource(R.drawable.d6);
                break;
        }

    }

    private void setImageViewDado2(@NonNull DadosAdapter.DadosViewHolder holder,int num){
        switch (num){
            case 1:
                holder.imageViewDado2.setImageResource(R.drawable.d1);
                break;

            case 2:
                holder.imageViewDado2.setImageResource(R.drawable.d2);
                break;

            case 3:
                holder.imageViewDado2.setImageResource(R.drawable.d3);
                break;

            case 4:
                holder.imageViewDado2.setImageResource(R.drawable.d4);
                break;

            case 5:
                holder.imageViewDado2.setImageResource(R.drawable.d5);
                break;

            case 6:
                holder.imageViewDado2.setImageResource(R.drawable.d6);
                break;
        }

    }

    private void setImageViewDado3(@NonNull DadosAdapter.DadosViewHolder holder,int num){
        switch (num){
            case 1:
                holder.imageViewDado3.setImageResource(R.drawable.d1);
                break;

            case 2:
                holder.imageViewDado3.setImageResource(R.drawable.d2);
                break;

            case 3:
                holder.imageViewDado3.setImageResource(R.drawable.d3);
                break;

            case 4:
                holder.imageViewDado3.setImageResource(R.drawable.d4);
                break;

            case 5:
                holder.imageViewDado3.setImageResource(R.drawable.d5);
                break;

            case 6:
                holder.imageViewDado3.setImageResource(R.drawable.d6);
                break;
        }

    }

    private void setImageViewDado4(@NonNull DadosAdapter.DadosViewHolder holder,int num){
        switch (num){
            case 1:
                holder.imageViewDado4.setImageResource(R.drawable.d1);
                break;

            case 2:
                holder.imageViewDado4.setImageResource(R.drawable.d2);
                break;

            case 3:
                holder.imageViewDado4.setImageResource(R.drawable.d3);
                break;

            case 4:
                holder.imageViewDado4.setImageResource(R.drawable.d4);
                break;

            case 5:
                holder.imageViewDado4.setImageResource(R.drawable.d5);
                break;

            case 6:
                holder.imageViewDado4.setImageResource(R.drawable.d6);
                break;
        }

    }

    private void setImageViewDado5(@NonNull DadosAdapter.DadosViewHolder holder,int num){
        switch (num){
            case 1:
                holder.imageViewDado5.setImageResource(R.drawable.d1);
                break;

            case 2:
                holder.imageViewDado5.setImageResource(R.drawable.d2);
                break;

            case 3:
                holder.imageViewDado5.setImageResource(R.drawable.d3);
                break;

            case 4:
                holder.imageViewDado5.setImageResource(R.drawable.d4);
                break;

            case 5:
                holder.imageViewDado5.setImageResource(R.drawable.d5);
                break;

            case 6:
                holder.imageViewDado5.setImageResource(R.drawable.d6);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewDado1;
        ImageView imageViewDado2;
        ImageView imageViewDado3;
        ImageView imageViewDado4;
        ImageView imageViewDado5;

        public DadosViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDado1 = itemView.findViewById(R.id.imageViewDado1);
            imageViewDado2 = itemView.findViewById(R.id.imageViewDado2);
            imageViewDado3 = itemView.findViewById(R.id.imageViewDado3);
            imageViewDado4 = itemView.findViewById(R.id.imageViewDado4);
            imageViewDado5 = itemView.findViewById(R.id.imageViewDado5);

        }
    }

    public interface OnDadosClickListener{
        void onDadosClick(View view,int position);
    }
}
