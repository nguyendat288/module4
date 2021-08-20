package models;

public class NhanVien {
    private int idnv;
    private String namenv;
    private String birthday;
    private String address;
    private String phonenumber;
    private String email;

    public NhanVien() {
    }

    public int getIdnv() {
        return idnv;
    }

    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }

    public String getNamenv() {
        return namenv;
    }

    public void setNamenv(String namenv) {
        this.namenv = namenv;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhanVien(int idnv, String namenv, String birthday, String address, String phonenumber, String email) {
        this.idnv = idnv;
        this.namenv = namenv;
        this.birthday = birthday;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }
}
