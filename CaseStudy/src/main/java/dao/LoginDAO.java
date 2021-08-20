package dao;

import model.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;

public class LoginDAO {
    static Connection connection;
    static ArrayList<TaiKhoan> list =new ArrayList<>();

    static {
        connection = DAO.getConnect();
    }
    public static ArrayList<TaiKhoan> select() throws SQLException, ClassNotFoundException {
        String select = "select * from account";
        // tạo ra Statement bằng connection.
        Statement statement = connection.createStatement();
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");

            int loaitk = Integer.parseInt(resultSet.getString("loaitk"));

            list.add(new TaiKhoan(id,username,password,email,address,loaitk));
        }
        return list;
    }
    public static  void create(TaiKhoan tk) throws SQLException {
        String create="insert into customer value(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(create);
        preparedStatement.setInt(1,tk.getIdtk());
        preparedStatement.setString(2,tk.getUsername());
        preparedStatement.setString(3,tk.getPassword());
        preparedStatement.setString(4,tk.getEmail());
        preparedStatement.setString(5,tk.getAddress());
        preparedStatement.setInt(6,tk.getLoaitk());
        preparedStatement.execute();
    }
}
