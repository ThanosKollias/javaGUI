
package softecon.javaswing.test.forms;

import java.util.logging.Level;
import java.util.logging.Logger;
import softecon.javaswing.test.utils.Tools;

/*
 * @author tkol
 */

public class Startup {

    public static void main(String[] args) {
        try {
            Tools.setLookAndFell();
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {                
                    new MainForm().setVisible(true);    
                }  
            });
      
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
