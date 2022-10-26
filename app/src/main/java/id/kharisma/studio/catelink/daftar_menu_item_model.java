package id.kharisma.studio.catelink;

public class daftar_menu_item_model {

    String menuName, vendorName, vendorAddress, menuPrice, rateValue;
    int poster;

    public daftar_menu_item_model(String menuName, String vendorName, String vendorAddress, String menuPrice, String rateValue, int poster) {
        this.menuName = menuName;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.menuPrice = menuPrice;
        this.rateValue = rateValue;
        this.poster = poster;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public String getRateValue() {
        return rateValue;
    }

    public int getPoster() {
        return poster;
    }
}