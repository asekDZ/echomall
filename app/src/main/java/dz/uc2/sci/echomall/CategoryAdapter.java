package dz.uc2.sci.echomall;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {


    private Context mContext ;
    private List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList, Context macontex) {
        this.categoryModelList = categoryModelList;
        mContext = macontex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.ViewHolder viewHolder, int position) {

        int icon = categoryModelList.get(position).getCategoryIconLink();
        String name = categoryModelList.get(position).getCategoryName();
        viewHolder.setCategoryName(name);
        viewHolder.setCategoryIcon(icon);



    }


    @Override
    public int getItemCount() {
        return categoryModelList.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView categoryIcon;
        private TextView categoryName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.category_icon);
            categoryName = itemView.findViewById(R.id.category_name);

        }

        private void setCategoryIcon(int icon){

            //// todo:set Categoryicons here
            categoryIcon.setImageResource(icon);
        }
        private void setCategoryName(String name){

            categoryName.setText(name);


        }
    }
}
