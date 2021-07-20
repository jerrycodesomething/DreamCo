/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreamco;

/**
 *
 * @author Raihan
 */
public class NodeTree {

    double money=0;
    String name;
    java.util.ArrayList<NodeTree> child = new java.util.ArrayList<>();
    NodeTree prev;
    String ID;
    String password;
    int level=0;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public NodeTree(String name){
        this.name=name;
    }
    
    public NodeTree(String name, NodeTree prev, int id){
        this.name=name;
        this.prev = prev;
        this.ID=String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public NodeTree(String name, String password, double Money, int id){
        this.name=name;
        this.money=Money;
        this.password=password;
        this.ID=String.valueOf(id);
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public NodeTree(){
        this.name=null;
        this.prev = null;
    }
    
    public void addMoney(double money){
        this.money +=  money;
    }
    
    public void setMoney(double money){
        this.money=money;
    }

    public double getMoney() {
        return money;
    }
   
    
    
}
