
package dreamco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Raihan
 */
public class MyTree {

    ///////////////////////////////////////////////////////////// Static VARIABLE and OBJECT declarations //////////////////////////////////////////////////////////////////////

    public NodeTree root = new NodeTree("DreamCo",new NodeTree("Admin"),0);
    public static String adminid, adminpass;
    public static int idCounter;    
    private static double classvariablefee;
    private static double commission_gen1, commission_gen2, commission_gen3, commission_gen4, commission_gen5;
    
    
    //private double hello=root.getMoney();

   ////////////////////////////////////////////////////////////////////////////////// CONSTRUCTOR for variable instatiation upon calling NEW CBJECT /////////////////////////////////////////////////// 
    public MyTree(){
        idCounter=0;
        classvariablefee=50;
        commission_gen1=0.5;
        commission_gen3=0.12;
        commission_gen2=0.09;
        commission_gen4=0.06;
        commission_gen5=0.03;
        startupAdminConfigFiles();
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////// SETTERS are all here !!! /////////////////////////////////////
    public static void setAdminID(String id){
        adminid=id;
    }
    public static void setAdminPass(String pass){
        adminpass=pass;
    }
    
    public static void setIDCounter(int idcounter){
        idCounter=idcounter;
    }
    
    public static void setParent(String parent){
        
    }
    
    public static void setFee(double fee) {
        classvariablefee = fee;
    }
    
    public static void setGen1Commission(double commission){
        commission_gen1= commission;
    }
            
    public static void setGen2Commission(double commission){
        commission_gen2= commission;
    }
    
    public static void setGen3Commission(double commission){
        commission_gen3=commission;
    }
            
    public static void setGen4Commission(double commission){
        commission_gen4=commission;
    }
    public static void setGen5Commission(double commission){
        commission_gen5=commission;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////// GETTERS are all here!!! /////////////////////////////////////////////////
    public static String getAdminID(){
        return adminid;
    }    
    public static String getAdminPass(){
        return adminpass;
    }
    public static int getIDCounter(){
        return idCounter;
    }    
    public static double getFee() {
        return classvariablefee;
    } 
    public static double getGen1Commission(){
        return commission_gen1;
    }
    public static double getGen2Commission(){
        return commission_gen2;
    }
    public static double getGen3Commission(){
        return commission_gen3;
    }
    public static double getGen4Commission(){
        return commission_gen4;
    }
    public static double getGen5Commission(){
        return commission_gen5;
    }
    
    public void addUser(){
        try{
            Scanner scan = new Scanner(new FileInputStream("Userdata.txt"));
            while (scan.hasNextLine()) {
                String ID=scan.nextLine();
                String password = scan.nextLine();
                String parent=scan.nextLine();
                String username = scan.nextLine();
                String moneys=scan.nextLine();
                idCounter++;
                addFromFile(username,password,parent,Double.parseDouble(moneys),ID);
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: "+e);
        } 
    }
    
 
    private void addFromFile(String name,String password, String parentid, double Money, String id){
        int idint = Integer.parseInt(id);
        if(parentid.equals("Admin")){
            NodeTree temp = new NodeTree(name, password, Money, idint);
            temp.prev=new NodeTree("Admin");
            root=temp;
        }
        else{
            if(contain(parentid)){
            NodeTree temp = new NodeTree(name, password, Money, idint);
           temp.setLevel(getNode(parentid).level+1);
            getNode(parentid).child.add(temp);
            temp.prev=getNode(parentid);
            }
            else
                System.out.println("Cannot add, parent not found");
        }
    }
    
     public void appendUserClearFile() throws IOException{
       // DFSdisplayAll();
        DataEncryptionFile.clearFile();
        MyStack<NodeTree> s = new MyStack();
        
        if(root==null)
            System.out.println("No user");
        else{        
            s.push(root);
            NodeTree temp = root;
            while(s.getSize()!=0){
                temp = s.pop();
                if(temp==null){
                    continue;}
                if(temp.name.equals("DreamCo")){
                    DataEncryptionFile.appendUserIntoFile(temp.ID, "123", "Admin", temp.name, temp.money);
                }else{
                    DataEncryptionFile.appendUserIntoFile(temp.ID, temp.password, temp.prev.ID, temp.name, temp.money);
                }
                    for (int i = 0; i < temp.child.size(); i++) {
                        s.push(temp.child.get(i));
                    }
            }
        System.out.println("");
        }
    }
    
     public void appendUser() throws IOException{
        
        MyStack<NodeTree> s = new MyStack();
        if(root==null)
            System.out.println("No user");
        else{        
            s.push(root);
            NodeTree temp = root;
            while(s.getSize()!=0){
                temp = s.pop();
                if(temp==null){
                    continue;}
                if(temp.name.equals("DreamCo")){
                    DataEncryptionFile.appendUserIntoFile(temp.ID, "123", "Admin", temp.name, temp.money);
                }else{
                    DataEncryptionFile.appendUserIntoFile(temp.ID, temp.password, temp.prev.ID, temp.name, temp.money);
                }
                    for (int i = 0; i < temp.child.size(); i++) {
                        s.push(temp.child.get(i));
                    }
            }
        System.out.println("");
        }
    }
     
     
    // add method to use when to create new user
    public void add(String name,String password, String parentId) /*throws IOException*/{
       
        if(root.child.isEmpty()){
            idCounter++;
            NodeTree temp = new NodeTree(name, null, idCounter);
            temp.setPassword(password);
            root.child.add(temp);
            temp.prev=root;
            root.addMoney(classvariablefee*getGen1Commission());
        }
        else{
            if(contain(parentId)){
                 idCounter++;
            NodeTree temp = new NodeTree(name, null, idCounter);
            temp.setLevel(getNode(parentId).level+1);
            temp.setPassword(password);
            getNode(parentId).child.add(temp);
            temp.prev=getNode(parentId);
            
            NodeTree current = temp;
                    int level = 1;
                    while(current.prev!=null){
                    current = current.prev;
                    
                        switch (level) {
                            case 1:
                                current.addMoney(classvariablefee*getGen1Commission());
                                level++;
                                break;
                            case 2:
                                current.addMoney(classvariablefee*getGen2Commission());
                                level++;
                                break;
                            case 3:
                                current.addMoney(classvariablefee*getGen3Commission());
                                level++;
                                break;
                            case 4:
                                current.addMoney(classvariablefee*getGen4Commission());
                                level++;
                                break;
                            case 5:
                                current.addMoney(classvariablefee*getGen5Commission());
                                level++;
                                break;
                            case 6:
                                root.addMoney(classvariablefee*(100-getGen1Commission()-getGen2Commission()-getGen3Commission()-getGen4Commission()-getGen5Commission()));
                                level++;
                                break;
                            default:
                                level++;
                                break;
                        }
                    }
            }
            else
                System.out.println("Cannot add, parent not found");
        }
    }
    
    // get money balance from user, return 0 if user not exist
    public double getMoney(String id){
        return getNode(id).money;
    }
    
    public boolean contain (String id){
        MyStack<NodeTree> s = new MyStack();
        s.push(root);
        NodeTree temp = root;;
        while(s.getSize()!=0){
            temp = s.pop();
            if(temp==null)
                continue;
            else if(temp.equals(getNode(id))){
                return true;
            }
            for (int i = 0; i < temp.child.size(); i++) {
                s.push(temp.child.get(i));
            }
        }
        return false;
    }
    
    public NodeTree getNode(String id){
        MyStack<NodeTree> s = new MyStack();
        
        s.push(root);
        NodeTree temp = root;
        while(s.getSize()!=0){
            temp = s.pop();
            if(temp==null)
                continue;
            else if(temp.ID.equalsIgnoreCase(id))
                return temp;
            for (int i = 0; i < temp.child.size(); i++) {
                s.push(temp.child.get(i));
            }
        }
        return null;
    }
    
    public double getTotalMoney(){
        if(root==null)
            return 0;
        else{
            
            return 0;
        }
    }
    
    public void displayAllNodes(){
        DFSdisplayAll();
    }
    
    //display all parents from the child
    public void displayAncestor(String id){
        NodeTree temp = getNode(id);
        if(contain(id)){
            while(temp.prev!=null){
                System.out.print(' '+temp.name + " -RM" + temp.money);        
                temp = temp.prev;
            }
            System.out.print(temp.name);
        }
        else
            System.out.println("Node not found");
    }

    public void dfstackUser(String name){
        MyStack<NodeTree> s = new MyStack();
        
        s.push(getNode(name));
        NodeTree temp = getNode(name);
        
        while(s.getSize()!=0){
            temp = s.pop();
            if(temp==null)
                continue;
            System.out.print(' '+ temp.name + " -RM" + temp.money);
            for (int i = 0; i < temp.child.size(); i++) {
                s.push(temp.child.get(i));
            }
        }System.out.println("");
    }
    
    private void DFSdisplayAll(){
        MyStack<NodeTree> s = new MyStack();
        
        if(root==null)
            System.out.println("No user");
        else{        
            s.push(root);
            NodeTree temp = root;
            while(s.getSize()!=0){
                temp = s.pop();
                if(temp==null)
                    continue;
               System.out.println(" "+ temp.name + " -RM " + temp.money  + " ID: " + temp.ID  + " password: " + temp.password  + " parents: " + temp.prev.ID  );
                for (int i = 0; i < temp.child.size(); i++) {
                    s.push(temp.child.get(i));
                }

            }
        System.out.println("");
        }
    }
    
    
    private void clear(){
        root= new NodeTree("DreamCo",new NodeTree("Admin"),0);
        idCounter=0;
    }
    
    public void remove(String id) throws IOException{
        if(contain(id)){
            if(root==getNode(id)){
                clear();
            }else{
                
                NodeTree []temp=new NodeTree[1]; 
                boolean remove=false;
                String prevID = getNode(id).prev.ID;
                
                if(!getNode(id).child.isEmpty()){
                    temp= new NodeTree[getNode(id).child.size()];
                    remove=true;
                        for (int i = 0; i < getNode(id).child.size(); i++) {
                            temp[i] = getNode(id).child.get(i);
                        }
                }
                
                    int numbtemp=-1;
                        for (int i = 0; i < getNode(id).prev.child.size(); i++) {
                            if(getNode(getNode(id).prev.ID).child.get(i)==(getNode(id))){
                                numbtemp = i;
                                break;
                            }
                        }
                    if(numbtemp!=-1){    
                        System.out.println(getNode(id).ID);
                        getNode(id).prev.child.remove(numbtemp);
                        
                    }
                    if(remove){
                        for (int i = 0; i < temp.length; i++) {
                            System.out.println(prevID);
                            getNode(prevID).child.add(temp[i]);
                            temp[i].prev=getNode(prevID);
                        }
                    }
                    System.out.println("Removed: "+ id);
                appendUserClearFile();
            }
        }else
            System.out.println("User not found");
    }
    
    //method to be used for password reset
    public void setPassword(String name, String password){
        getNode(name).setPassword(password);
    }
    
    //method to read FEE from textfile upon startup
    public static void startupAdminConfigFiles(){
        try{
        Scanner s= new Scanner(new FileReader("AdminConfig.txt"));
        while(s.hasNextLine()){
            setIDCounter(Integer.parseInt(s.next()));
            setFee(Double.parseDouble(s.next()));
            setGen1Commission(Double.parseDouble(s.next()));
            setGen2Commission(Double.parseDouble(s.next()));
            setGen3Commission(Double.parseDouble(s.next()));
            setGen4Commission(Double.parseDouble(s.next()));
            setGen5Commission(Double.parseDouble(s.next()));          
        }
        s.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "System File Not Found!", "  System Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        try{
        Scanner f= new Scanner(new FileReader("Metadata.txt"));
        while(f.hasNextLine()){
            setAdminID(f.next());
            setAdminPass(f.next());
            break;

        }
        f.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "System File Not Found!", "  System Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void updateAdminConfigFile() {  //called by my adminframe class 
        try{
        PrintWriter pw= new PrintWriter(new FileWriter(new File("AdminConfig.txt")));
        pw.print(getIDCounter());
        pw.print("\n"+getFee());
        pw.print("\n"+getGen1Commission());
        pw.print("\n"+getGen2Commission());
        pw.print("\n"+getGen3Commission());
        pw.print("\n"+getGen4Commission());
        pw.print("\n"+getGen5Commission());
        pw.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "System File Not Found!", "  System Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
/////////////////////////display graph in visual///////////////////////////////////////////
    public void displayGraph(){
        clear();
        addUser();
        Graph g= new SingleGraph("MLM");
        g.addAttribute("ui.stylesheet", "graph { fill-color: lightblue; } node { shape: box;\n" +
"	size: 20px, 20px;\n" +
"	fill-mode: plain;   \n" +
"	fill-color: black;    \n" +
                "text-size: 15px;"+
                "text-color: darkblue;"+
"	stroke-mode: plain; \n" +
"	stroke-color: black; } edge { fill-color: darkblue; } node#0 {fill-color: red; text-color: red;}");
        
        MyStack<NodeTree> s = new MyStack();
        
        if(root==null)
            System.out.println("No user");
        else{        
            s.push(root);
            NodeTree temp = root;
            while(s.getSize()!=0){
                temp = s.pop();
                if(temp==null)
                    continue;
                
                g.addNode(temp.ID);
                g.getNode(temp.ID).addAttribute("ui.label", "Name: "+ temp.name + "\n  RM" + temp.money  + "\n User's ID: dcuser" + temp.ID + "\n Tree level: " + temp.level);
                
                for (int i = 0; i < temp.child.size(); i++) {
                    s.push(temp.child.get(i));
                }

            }
        System.out.println("");
        }
        
        g.getNode(0).setAttribute("xy", 50,50);
        
        MyStack<NodeTree> s1 = new MyStack();
        
        if(root==null)
            System.out.println("No user");
        else{        
            s1.push(root);
            NodeTree temp = root;
            while(s1.getSize()!=0){
                temp = s1.pop();
                if(temp==null)
                    continue;
                if(temp.ID==null || temp.prev.ID==null){
                }else{
                    g.addEdge(temp.ID+temp.prev.ID, temp.ID, temp.prev.ID);
                }
                    
                for (int i = 0; i < temp.child.size(); i++) {
                    s1.push(temp.child.get(i));
                }
            }
        System.out.println("");
        }
        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        viewer.enableAutoLayout();
    }
    
    
    
    public void setNewName(String id, String newName){
        getNode(id).setName(newName);
    }
    
    public void setNewPassword(String id, String newPassword){
        getNode(id).setPassword(newPassword);
    }
    
    public void totalLevel(){
        MyStack<NodeTree> s = new MyStack();
        int max=0;
        s.push(getNode(root.ID));
        NodeTree temp = getNode(root.ID);
        while(s.getSize()!=0){
            temp = s.pop();
            if(temp==null)
                continue;
            if(temp.level>max)
                max=temp.level;
            for (int i = 0; i < temp.child.size(); i++) {
                s.push(temp.child.get(i));
            }
        }System.out.println("");
        double [] level =  new double[max+1];
        for (int i = 0; i < level.length; i++) {
            level[i]=0;
        }
        MyStack<NodeTree> s1 = new MyStack();
        s1.push(getNode(root.ID));
        NodeTree temp1 = getNode(root.ID);
        while(s1.getSize()!=0){
            temp1 = s1.pop();
            if(temp1==null)
                continue;
            level[temp1.level]+=temp1.getMoney();
            for (int i = 0; i < temp1.child.size(); i++) {
                s1.push(temp1.child.get(i));
            }
        }System.out.println("");

        for (int i = 0; i < level.length; i++) {
            System.out.print("level: "+ i +" - " + level[i]);
        }
    }
    
    public double[] gettotalLevel(){
        MyStack<NodeTree> s = new MyStack();
        int max=0;
        s.push(getNode(root.ID));
        NodeTree temp = getNode(root.ID);
        while(s.getSize()!=0){
            temp = s.pop();
            if(temp==null)
                continue;
            if(temp.level>max)
                max=temp.level;
            for (int i = 0; i < temp.child.size(); i++) {
                s.push(temp.child.get(i));
            }
        }System.out.println("");
        double [] level =  new double[max+1];
        for (int i = 0; i < level.length; i++) {
            level[i]=0;
        }
        MyStack<NodeTree> s1 = new MyStack();
        s1.push(getNode(root.ID));
        NodeTree temp1 = getNode(root.ID);
        while(s1.getSize()!=0){
            temp1 = s1.pop();
            if(temp1==null)
                continue;
            level[temp1.level]+=temp1.getMoney();
            for (int i = 0; i < temp1.child.size(); i++) {
                s1.push(temp1.child.get(i));
            }
        }System.out.println("");

        return level;

    }
    
}
