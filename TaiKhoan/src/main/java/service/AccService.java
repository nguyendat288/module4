package service;

import dao.ManagerAcc;
import models.TaiKhoan;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccService {
    public ArrayList<TaiKhoan> list=new ArrayList<>();
    public AccService() {
        try {
            list=ManagerAcc.select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void add(TaiKhoan tk) throws SQLException {
        ManagerAcc.create(tk);
        list.add(tk);
    }
    public void edit(TaiKhoan tk,int index) throws SQLException {
        ManagerAcc.edit(tk);
        list.set(index,tk);
    }
    public void delete(int index) throws SQLException {
        ManagerAcc.delete(list.get(index).getId());
        list.remove(index);
    }
    public TaiKhoan findById(int id){
        for(TaiKhoan x:list){
            if(x.getId()==id){
                return x;
            }
        }
        return null;
    }
    public ArrayList<TaiKhoan> findByName(String name) throws SQLException {
        return  ManagerAcc.findByName(name);
    }
}
