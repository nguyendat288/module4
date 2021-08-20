package model;

public class TaiKhoan {
    private int idtk;
    private String username;
    private String password;
    private String email;
    private String address;
    private int loaitk;

    public TaiKhoan(int idtk, String username, String password, String email, String address, int loaitk) {
        this.idtk = idtk;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.loaitk = loaitk;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLoaitk() {
        return loaitk;
    }

    public void setLoaitk(int loaitk) {
        this.loaitk = loaitk;
    }

    public TaiKhoan() {
    }
}
