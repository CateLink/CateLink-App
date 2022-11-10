package id.kharisma.studio.catelink.Model;

public class CateMenu {

    // Model Class
    private String menuName, vendorName, poster;
    private long menuPrice;

    //Constructor

    public CateMenu(String menuName, String vendorName, String poster, long menuPrice) {
        this.menuName = menuName;
        this.vendorName = vendorName;
        this.poster = poster;
        this.menuPrice = menuPrice;
    }

    public CateMenu() {
    }

    // Getter and Setter

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public long getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(long menuPrice) {
        this.menuPrice = menuPrice;
    }
}

