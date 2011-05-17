/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import things.views.Login_Form;

/**
 *
 * @author fauzan
 */
 
public class Things {
    public static void main(String[] args) {
      try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
      }
     catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }

      new Login_Form().setVisible(true);
    }
    
}
