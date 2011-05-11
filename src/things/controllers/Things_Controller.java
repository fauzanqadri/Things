/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.ao.EntityManager;
import things.config.connect;
import things.models.Thing;

/**
 *
 * @author fauzan
 */
public class Things_Controller {
   // public Thing[] thing;
    public EntityManager connect = new connect().Em;
    
        
    public Thing[] getThings(){
        Thing[] thing = null;
        try {
            thing = connect.find(Thing.class);
            while(thing.length<1){
                thing =null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thing;
    }
}
