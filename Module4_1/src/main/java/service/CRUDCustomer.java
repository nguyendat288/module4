package service;

import models.Customer;

import java.util.ArrayList;

public class CRUDCustomer {
    public ArrayList<Customer> list=new ArrayList<>();
    public CRUDCustomer(){
        list.add(new Customer(1,"toan","toan@gmail.com"));
        list.add(new Customer(2,"nam","nam@gmail.com"));
        list.add(new Customer(3,"tám","tam@gmail.com"));
    }
    public void save(Customer customer){
        list.add(customer);
    }
    public void delete(int index){
        list.remove(index);
    }
    public void edit(Customer customer,int index){
        list.set(index,customer);
    }
}
