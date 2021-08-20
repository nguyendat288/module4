package dao;

import models.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;

public class ManagerAcc {
    static Connection connection;
    static ArrayList<TaiKhoan> list =new ArrayList<>();

    static {
        connection = ConnectMySql.getConnect();
    }

    public static ArrayList<TaiKhoan> select() throws SQLException, ClassNotFoundException {
        String select = "select * from customer";
        // tạo ra Statement bằng connection.
        Statement statement = connection.createStatement();
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");

            list.add(new TaiKhoan(id,username,password,email));
        }
        return list;
    }
    public static  void create(TaiKhoan tk) throws SQLException {
        String create="insert into customer value(?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(create);
        preparedStatement.setInt(1,tk.getId());
        preparedStatement.setString(2,tk.getUsername());
        preparedStatement.setString(3,tk.getPassword());
        preparedStatement.setString(4,tk.getEmail());
        preparedStatement.execute();
    }
    public static  void edit(TaiKhoan tk) throws SQLException {
        String edit="update customer set username =? , password=? , email =? where id =?";
        PreparedStatement preparedStatement=connection.prepareStatement(edit);
        preparedStatement.setInt(4,tk.getId());
        preparedStatement.setString(1,tk.getUsername());
        preparedStatement.setString(2,tk.getPassword());
        preparedStatement.setString(3,tk.getEmail());
        preparedStatement.execute();
    }
    public static  void delete(int id) throws SQLException {
        String delete="delete from customer  where id =?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
    public static ArrayList<TaiKhoan> findByName(String findName) throws SQLException {
        ArrayList<TaiKhoan> findList = new ArrayList<>();
        String edit = "select * from customer where username like '%" + findName +"%'";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");

            findList.add(new TaiKhoan(id,username,password,email));
        }
        return findList;
    }
}
