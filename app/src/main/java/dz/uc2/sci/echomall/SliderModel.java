package dz.uc2.sci.echomall;

public class SliderModel {
    int banner;
    String Title;

    public SliderModel(int banner, String title) {
        this.banner = banner;
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public SliderModel(int banner) {
        this.banner = banner;
    }
}
