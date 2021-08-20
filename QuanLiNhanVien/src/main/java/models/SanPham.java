package models;

public class SanPham {
    private int idsp;
        private String nameproduct;
    private float price;
    private int soluong;
    private String color;
    private int loaisp;

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(int loaisp) {
        this.loaisp = loaisp;
    }

    public SanPham(int idsp, String nameproduct, float price, int soluong, String color, int loaisp) {
        this.idsp = idsp;
        this.nameproduct = nameproduct;
        this.price = price;
        this.soluong = soluong;
        this.color = color;
        this.loaisp = loaisp;
    }

    public SanPham() {
    }
}
