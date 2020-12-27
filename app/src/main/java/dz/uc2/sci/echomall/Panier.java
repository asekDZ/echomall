package dz.uc2.sci.echomall;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    static  List<Produit> panierList = new ArrayList<>();

    public Panier(List<Produit> panierList) {
        this.panierList = panierList;
    }

    public static void  ajouterproduit(Produit produit){

        panierList.add(produit);
    }
    public static void spprimerproduit(int index){
        panierList.remove(index);
    }
}
