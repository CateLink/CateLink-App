package id.kharisma.studio.catelink.Model;

public class CateMenu {

    String menuName, vendorName, menuPrice;
    int poster;

    public CateMenu(String menuName, String vendorName, String menuPrice, int poster) {
        this.menuName = menuName;
        this.vendorName = vendorName;
        this.menuPrice = menuPrice;
        this.poster = poster;
    }

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

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
