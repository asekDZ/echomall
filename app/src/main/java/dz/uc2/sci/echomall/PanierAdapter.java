package dz.uc2.sci.echomall;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.MyViewHolder>{


    private Context mContext ;
    private List<Produit> mData ;


    public PanierAdapter(Context context, List<Produit> mData) {
        this.mContext=context;
        this.mData = mData;
    }

    @Override
    public PanierAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardveiw_item_product,viewGroup,false);
        // return new CategoryAdapter.ViewHolder(view);
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.panier_item,parent,false);
        return new PanierAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PanierAdapter.MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.prix.setText(String.valueOf(mData.get(position).getPrix()));
        holder.marque.setText(mData.get(position).getMarque());





    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        TextView prix;
        TextView marque;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.namePanier) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.panierImg);
            cardView = (CardView) itemView.findViewById(R.id.cardViewPanier);
            prix = (TextView) itemView.findViewById(R.id.prixpanier);
            marque = (TextView) itemView.findViewById(R.id.marquepanier);


        }
    }




}
