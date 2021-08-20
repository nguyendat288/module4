package dao;

import models.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class ManagerProduct {
    static Connection connection;
    static ArrayList<SanPham> list =new ArrayList<>();

    static {
        connection = ConnectMySQL.getConnect();
    }

    public static ArrayList<SanPham> select() throws SQLException, ClassNotFoundException {
        String select = "select * from product";
        // tạo ra Statement bằng connection.
        Statement statement = connection.createStatement();
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("idsanpham"));
            String nameproduct = resultSet.getString("nameproduct");
            Float price = Float.parseFloat(resultSet.getString("price"));
            int soluong = Integer.parseInt(resultSet.getString("soluong"));
            String color = resultSet.getString("color");
            int loaisp = Integer.parseInt(resultSet.getString("idloaisanpham"));
            list.add(new SanPham(id,nameproduct,price,soluong,color,loaisp));
        }
        return list;
    }
    public static  void create(SanPham sp) throws SQLException {
        String create="insert into product value(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(create);
        preparedStatement.setInt(1,sp.getIdsp());
        preparedStatement.setString(2,sp.getNameproduct());
        preparedStatement.setFloat(3,sp.getPrice());
        preparedStatement.setInt(4,sp.getSoluong());
        preparedStatement.setString(5,sp.getColor());
        preparedStatement.setInt(6,sp.getLoaisp());
        preparedStatement.execute();
    }
    public static  void edit(SanPham sp) throws SQLException {
        String edit="update product set nameproduct=? , price =?,soluong=?,color=?,idloaisanpham=? where idsanpham =?";
        PreparedStatement preparedStatement=connection.prepareStatement(edit);
        preparedStatement.setInt(6,sp.getIdsp());
        preparedStatement.setString(1,sp.getNameproduct());
        preparedStatement.setFloat(2,sp.getPrice());
        preparedStatement.setInt(3,sp.getSoluong());
        preparedStatement.setString(4,sp.getColor());
        preparedStatement.setInt(5,sp.getLoaisp());
        preparedStatement.execute();
    }
    public static  void delete(int idsp) throws SQLException {
        String delete="delete from product  where idsanpham =?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,idsp);
        preparedStatement.execute();
    }
    public static ArrayList<SanPham> findByName(String findName) throws SQLException {
        ArrayList<SanPham> findList = new ArrayList<>();
        String edit = "select * from product where nameproduct like '%" + findName +"%'";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("idsanpham"));
            String nameproduct = resultSet.getString("nameproduct");
            Float price = Float.parseFloat(resultSet.getString("price"));
            int soluong = Integer.parseInt(resultSet.getString("soluong"));
            String color = resultSet.getString("color");
            int loaisp = Integer.parseInt(resultSet.getString("idloaisanpham"));
            findList.add(new SanPham(id,nameproduct,price,soluong,color,loaisp));;
        }
        return findList;
    }
}
