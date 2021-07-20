//
package dreamco;

import java.io.IOException;

public class DreamCo {
    

    
 /////////////////////////////////////////////////////////////////////////////////////    This Class Serves as a tester class for now!   ////////////////////////////////////////
public static void main(String[] args) throws IOException {
    
    
    /////////////////////////////////////////// SET LOOK AND FEEL ////////////////////////////////////////////////////////////////////////////////
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    


    
    MyTree.startupAdminConfigFiles();
    SplashScreen sc= new SplashScreen();
    sc.runSplashScreen();        
    }

}