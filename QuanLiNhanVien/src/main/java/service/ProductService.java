package service;

import dao.ManagerProduct;
import models.SanPham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductService {
    public ArrayList<SanPham> list=new ArrayList<>();
    public ProductService() {
        try {
            list=ManagerProduct.select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void add(SanPham sp) throws SQLException {
        ManagerProduct.create(sp);
        list.add(sp);
    }
    public void edit(SanPham tk,int index) throws SQLException {
        ManagerProduct.edit(tk);
        list.set(index,tk);
    }
    public void delete(int index) throws SQLException {
        ManagerProduct.delete(list.get(index).getIdsp());
        list.remove(index);
    }
    public SanPham findById(int id){
        for(SanPham x:list){
            if(x.getIdsp()==id){
                return x;
            }
        }
        return null;
    }
    public ArrayList<SanPham> findByName(String name) throws SQLException {
        return  ManagerProduct.findByName(name);
    }
}



