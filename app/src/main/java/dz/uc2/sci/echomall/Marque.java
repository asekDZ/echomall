package dz.uc2.sci.echomall;

public class Marque {
    private String Marque;
    private  int idMarque;
    private static int co =0;
    public Marque(String marque) {
        Marque = marque;
        this.idMarque = co++;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public int getIdMarque() {
        return idMarque;
    }


}
