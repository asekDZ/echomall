package dz.uc2.sci.echomall;



public class CategoryModel {
    private int CategoryIconLink;
    private String CategoryName;

    public CategoryModel(int categoryIconLink, String categoryName) {
        CategoryIconLink = categoryIconLink;
        CategoryName = categoryName;
    }

    public int getCategoryIconLink() {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(int categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
