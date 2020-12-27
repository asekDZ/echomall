package dz.uc2.sci.echomall;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {



        private Context mContext ;
        private List<Produit> mData ;


        public MenuAdapter(Context context, List<Produit> mData) {
            this.mContext=context;
            this.mData = mData;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardveiw_item_product,viewGroup,false);
           // return new CategoryAdapter.ViewHolder(view);
            View view ;
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            view = mInflater.inflate(R.layout.cardveiw_item_product,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.tv_book_title.setText(mData.get(position).getTitle());
            holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, ProductActivity.class);

                    // passing data to the book activity
                    intent.putExtra("Title",mData.get(position).getTitle());
                    intent.putExtra("Description",mData.get(position).getDescription());
                    intent.putExtra("Marque",mData.get(position).getMarque());
                    intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                    intent.putExtra("Prix",mData.get(position).getPrix());
                    intent.putExtra("Evaluation",mData.get(position).getEvaluation());

                    // start the activity
                    mContext.startActivity(intent);

                }
            });



        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv_book_title;
            ImageView img_book_thumbnail;
            CardView cardView ;

            public MyViewHolder(View itemView) {
                super(itemView);

                tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id) ;
                img_book_thumbnail = (ImageView) itemView.findViewById(R.id.panierImg);
                cardView = (CardView) itemView.findViewById(R.id.cardview_id);


            }
        }


    }


