package dz.uc2.sci.echomall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }

    private RecyclerView menuRecyclerView;
    private MenuAdapter menuAdapter;
    ////////////BannerSlider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private List<SliderModel> sliderModelList1;
    private int currentPage = 2;
    List<Produit> lstProduit3;
    SearchView az;
    String azaz;
    //////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        menuRecyclerView = view.findViewById(R.id.menu_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        menuRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        az = (SearchView) view.findViewById(R.id.simpleSearchView);
        String[] keywordtv = {"full", "tv", "screen"};
        String[] keywordsheo = {"shoe", "feet", "sneaker"};
        String[] keywordphone = {"phone", "electronique", "smarth"};
        String[] keywordwhatch = {"time", "smarth", "watch"};
        String[] keywordrunner = {"sport", "electronique", "smarth"};
        String[] keywordxbox = {"jeux", "play", "games"};
        final List<Produit> menuModelList = new ArrayList<Produit>();
        menuModelList.add(new Produit("FULL TV", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.tvvv, keywordtv, "SAMSUNG", 5, 23.17, 2));
        menuModelList.add(new Produit("SHOE NIKE", "wear", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.shoe, keywordsheo, "NIKE", 10, 42.32, 5));
        menuModelList.add(new Produit("APPLE PHONE", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.phoneecom, keywordphone, "APPLE", 7, 16.34, 1));
        menuModelList.add(new Produit("SMARTH WATCH", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.watch, keywordwhatch, "HEIWIE", 5, 23.17, 2));
        menuModelList.add(new Produit("SPORT RUNNER", "alkoholic", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.sport, keywordrunner, "FITIN", 10, 42.32, 5));
        menuModelList.add(new Produit("XPOX 360", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.xbox, keywordxbox, "MICROSOFT", 7, 16.34, 1));
        menuModelList.add(new Produit("FULL TV", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.tvvv, keywordtv, "SAMSUNG", 5, 23.17, 2));
        menuModelList.add(new Produit("SHOE NIKE", "wear", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.shoe, keywordsheo, "NIKE", 10, 42.32, 5));
        menuModelList.add(new Produit("APPLE PHONE", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.phoneecom, keywordphone, "APPLE", 7, 16.34, 1));
        menuModelList.add(new Produit("SMARTH WATCH", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.watch, keywordwhatch, "HEIWIE", 5, 23.17, 2));
        menuModelList.add(new Produit("SPORT RUNNER", "alkoholic", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.sport, keywordrunner, "FITIN", 10, 42.32, 5));
        menuModelList.add(new Produit("XPOX 360", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.xbox, keywordxbox, "MICROSOFT", 7, 16.34, 1));
        menuModelList.add(new Produit("FULL TV", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.tvvv, keywordtv, "SAMSUNG", 5, 23.17, 2));
        menuModelList.add(new Produit("SHOE NIKE", "wear", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.shoe, keywordsheo, "NIKE", 10, 42.32, 5));
        menuModelList.add(new Produit("APPLE PHONE", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.phoneecom, keywordphone, "APPLE", 7, 16.34, 1));
        menuModelList.add(new Produit("SMARTH WATCH", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.watch, keywordwhatch, "HEIWIE", 5, 23.17, 2));
        menuModelList.add(new Produit("SPORT RUNNER", "alkoholic", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.sport, keywordrunner, "FITIN", 10, 42.32, 5));
        menuModelList.add(new Produit("XPOX 360", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.xbox, keywordxbox, "MICROSOFT", 7, 16.34, 1));
        menuModelList.add(new Produit("FULL TV", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.tvvv, keywordtv, "SAMSUNG", 5, 23.17, 2));
        menuModelList.add(new Produit("SHOE NIKE", "wear", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.shoe, keywordsheo, "NIKE", 10, 42.32, 5));
        menuModelList.add(new Produit("APPLE PHONE", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.phoneecom, keywordphone, "APPLE", 7, 16.34, 1));
        menuModelList.add(new Produit("SMARTH WATCH", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.watch, keywordwhatch, "HEIWIE", 5, 23.17, 2));
        menuModelList.add(new Produit("SPORT RUNNER", "alkoholic", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.sport, keywordrunner, "FITIN", 10, 42.32, 5));
        menuModelList.add(new Produit("XPOX 360", "electroniqs", "This is one of the best product youl ever buy so what do you wait herry up and add it to basket", R.drawable.xbox, keywordxbox, "MICROSOFT", 7, 16.34, 1));

        az.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                azaz = newText;

                lstProduit3 = new ArrayList<>();
                for (int i = 0; i < menuModelList.size(); i++) {
                    if ((((menuModelList.get(i)).getTitle()).toLowerCase()).equals(newText.toLowerCase())) {
                        lstProduit3.add(new Produit(((menuModelList.get(i)).getTitle()), ((menuModelList.get(i)).getCategory()), ((menuModelList.get(i)).getDescription()), ((menuModelList.get(i)).getThumbnail()), ((menuModelList.get(i)).getMotscle()), ((menuModelList.get(i)).getMarque()), ((menuModelList.get(i)).getNumExmpRes()), ((menuModelList.get(i)).getPrix()), ((menuModelList.get(i)).getEvaluation())));

                    } else if ((((menuModelList.get(i)).getCategory()).toLowerCase()).equals(newText.toLowerCase())) {
                        lstProduit3.add(new Produit(((menuModelList.get(i)).getTitle()), ((menuModelList.get(i)).getCategory()), ((menuModelList.get(i)).getDescription()), ((menuModelList.get(i)).getThumbnail()), ((menuModelList.get(i)).getMotscle()), ((menuModelList.get(i)).getMarque()), ((menuModelList.get(i)).getNumExmpRes()), ((menuModelList.get(i)).getPrix()), ((menuModelList.get(i)).getEvaluation())));

                    } else
                        for (int j = 0; j < 3; j++) {
                            if ((((menuModelList.get(i)).getMotscle())[j]).equals(newText.toLowerCase())) {
                                lstProduit3.add(new Produit(((menuModelList.get(i)).getTitle()), ((menuModelList.get(i)).getCategory()), ((menuModelList.get(i)).getDescription()), ((menuModelList.get(i)).getThumbnail()), ((menuModelList.get(i)).getMotscle()), ((menuModelList.get(i)).getMarque()), ((menuModelList.get(i)).getNumExmpRes()), ((menuModelList.get(i)).getPrix()), ((menuModelList.get(i)).getEvaluation())));

                            }
                        }

                }
                menuAdapter = new MenuAdapter(getContext(), lstProduit3);
                menuRecyclerView.setAdapter(menuAdapter);
                menuAdapter.notifyDataSetChanged();

                if (newText.equals("")) {

                    menuAdapter = new MenuAdapter(getContext(), menuModelList);
                    menuRecyclerView.setAdapter(menuAdapter);
                    menuAdapter.notifyDataSetChanged();
                }

                return false;
            }
        });


        menuAdapter = new MenuAdapter(getContext(), menuModelList);
        menuRecyclerView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();


        //////////Banner Slider - Begin -

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>() {
        };
        sliderModelList1 = new ArrayList<SliderModel>() {
        };
        sliderModelList.add(new SliderModel((R.drawable.tvvv), "FULL TV"));
        sliderModelList.add(new SliderModel((R.drawable.xbox), "XPOX 360"));
        sliderModelList.add(new SliderModel((R.drawable.tvvv), "FULL TV"));
        sliderModelList.add(new SliderModel((R.drawable.xbox), "XPOX 360"));



                //this will log the page number that was click
                for (int i = 0; i < 4; i++) {

                    if ((((sliderModelList.get(i)).getTitle()).toLowerCase()).equals((Wishlist.getTitle()).toLowerCase())  ) {
                        sliderModelList1.add(new SliderModel(((sliderModelList.get(i)).getBanner()), (sliderModelList.get(i)).getTitle()));

                    }
                }


            //bannerSliderViewPager.setClipToPadding(false);
            //bannerSliderViewPager.setPageMargin(10);

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList1);
        bannerSliderViewPager.setAdapter(sliderAdapter);
         ///////////// banner slider


            return view;


    }
 }


