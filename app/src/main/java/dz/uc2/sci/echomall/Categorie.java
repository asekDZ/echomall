package dz.uc2.sci.echomall;

public class Categorie {
    private  int idCategory;
    private String Category ;
    private static int co=0 ;
    public Categorie( String category) {
        this.idCategory = co++;
        Category = category;
    }

    public int getIdCategory() {
        return idCategory;
    }



    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
