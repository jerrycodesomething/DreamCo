/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreamco;

/**
 *
 * @author Raihan
 * @param <E>
 */
public class MyStack <E> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    
    public int getSize(){
        return list.size();
    }
    
    public E peek(){
        return list.get(getSize()-1);
    }
    
    public void push(E o){
        list.add(o);
    }
    
    public E pop (){
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public String toString(){
        return "Stack: " + list.toString();
    }
    
    public boolean search(E o){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(o)){
                return true;
            }
        }
        return false;
    }
    

    
}
