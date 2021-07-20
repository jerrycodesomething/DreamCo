
package dreamco;

//THIS CLASS CONTAINS THE METHODS TO READ AND ALTER THE NAME FILE 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DataFile {

private static String encryptedtxt="";

public static void writeEncryptionFile() throws IOException{
    PrintWriter pw= new PrintWriter(new FileWriter(new File("Userdata.txt")));
    pw.print(encryptedtxt);
    pw.close();
}

public static void appendFile() throws IOException{
    BufferedWriter bw=new BufferedWriter(new FileWriter(new File("Userdata.txt"),true));
    bw.write("hello");
    bw.close();
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////ENCRYPTION ALGORITHM//////////////////////////////////////////////////////
public static void fileEncryption() throws IOException{
    BufferedReader bufferedreader = new BufferedReader(new FileReader("Userdata.txt"));
    StringBuilder br = new StringBuilder();
    String line;
    int key=25;
    
    while((line =bufferedreader.readLine())!=null){
         br.append(line).append("\n");
    }
                  
    for(int i=0; i<br.length();i++){
        int a=br.charAt(i);
            if(Character.isUpperCase(a)){
                a=a+(key%26);
                if(a>'Z')
                     a=a-26;
        }
        else if(Character.isLowerCase(a)){
            a=a+(key%26);
            if(a>'z')
                a=a-26;
        }
        encryptedtxt=encryptedtxt+(char) a;
    } 
    writeEncryptionFile();
}


///////////////////////////////////////////////////////////////////////////////////////////////////////DECRYPTION ALGORITHM ///////////////////////////////////////////////////////
public static void fileDecryption() throws IOException{
    BufferedReader bufferedreader = new BufferedReader(new FileReader("Userdata.txt"));
    StringBuilder br= new StringBuilder();
    String line;
    int key=25;
    
    while((line =bufferedreader.readLine())!=null){
        br.append(line).append("\n");
    }

    for(int i=0; i<br.length();i++){
        int a=br.charAt(i);
        if(Character.isUpperCase(a)){
            a=a-(key%26);        
            if(a<'A')
                a=a+26;
        }
        else if(Character.isLowerCase(a)){
            a=a-(key%26);
            if(a<'a')
                a=a+26;
        }
        encryptedtxt=encryptedtxt+(char) a;
    }
    writeEncryptionFile();
}

}
