/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;

import java.sql.SQLException;
import net.java.ao.EntityManager;
import things.config.connect;
import things.models.Thing;
import java.util.Date;
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
    /*
    connect connect = new connect();  
    Thing th = connect.Em.create(Thing.class);
    th
    */
    
}
