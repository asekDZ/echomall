package dz.uc2.sci.echomall;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PanierActivity extends AppCompatActivity {

    Intent intent ;
    String Title ;
    String Categorie;
    String Description;
    int image;
    double Prix ;
    float evaluation ;
    Button btn_add;

    private RecyclerView menuRecyclerView;
    String[] keywordwatch = {"watch","electronique","time"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);


        btn_add = findViewById(R.id.addpanier);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

       /* btn_add.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
              //  Panier.spprimerproduit(1);



            }
        });
*/

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerviewpanier);
        PanierAdapter myAdapter = new PanierAdapter(this, Panier.panierList);
        myrv.setLayoutManager(new GridLayoutManager(this, 1));
        myrv.setAdapter(myAdapter);


    }
}
