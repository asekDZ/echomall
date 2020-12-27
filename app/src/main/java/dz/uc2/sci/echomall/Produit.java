package dz.uc2.sci.echomall;

public class Produit {



        private String Motscle[];
        private String Title;
        private String Category ;
        private String Description ;
        private String Marque;
        private int NumExmpRes ;
        private double Prix ;
        private float Evaluation;
        private int Thumbnail ;

        public Produit() {
        }

        public Produit(String title, String category, String description, int thumbnail, String[] motscle,  String marque, int numExmpRes, double prix, float evaluation) {
            Motscle = motscle;
            Title = title;
            Category = new Categorie(category).getCategory();
            Description = description;
            Marque = new Marque(marque).getMarque();
            NumExmpRes = numExmpRes;
            Prix = prix;
            Evaluation = evaluation;
            Thumbnail = thumbnail;
        }
        /*
            public Produit(String title, String category, String description, int thumbnail, String[] kyword) {
                Title = title;
                Motscle = kyword;
                Category = category;
                Description = description;
                Thumbnail = thumbnail;
            }
        */
        public String[] getMotscle() {
            return Motscle;
        }

        public void setMotscle(String[] kyword) {
            Motscle = kyword;
        }

        public String getTitle() {
            return Title;
        }

        public String getCategory() {
            return Category;
        }

        public String getDescription() {
            return Description;
        }

        public int getThumbnail() {
            return Thumbnail;
        }

        public String getMarque() {
            return Marque;
        }

        public void setMarque(String marque) {
            Marque = marque;
        }

        public int getNumExmpRes() {
            return NumExmpRes;
        }

        public void setNumExmpRes(int numExmpRes) {
            NumExmpRes = numExmpRes;
        }

        public double getPrix() {
            return Prix;
        }

        public void setPrix(float prix) {
            Prix = prix;
        }

        public float getEvaluation() {
            return Evaluation;
        }

        public void setEvaluation(int evaluation) {
            Evaluation = evaluation;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public void setThumbnail(int thumbnail) {
            Thumbnail = thumbnail;
        }
    }


