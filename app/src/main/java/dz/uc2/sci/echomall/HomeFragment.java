package dz.uc2.sci.echomall;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
/*
        categoryRecyclerView = view.findViewById(R.id.category_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();

        categoryModelList.add(new CategoryModel(R.drawable.icon_home,"Maison"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_mobile,"Mobiles"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_electronic,"Electronic"));
        categoryModelList.add(new CategoryModel(R.drawable.icon_vetements,"vêtements"));

        categoryAdapter = new CategoryAdapter(categoryModelList, this.getContext());
        categoryRecyclerView.setAdapter(categoryAdapter);

        categoryAdapter.notifyDataSetChanged();
*/



        return view;
    }
    ///////////// banner slider
   /* private void pagelooper(){

        if(currentPage == sliderModelList.size() -2 ){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);

        }
        if(currentPage == sliderModelList.size() -2 ){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);

        }

    }*/
    ///////////// banner slider

}
