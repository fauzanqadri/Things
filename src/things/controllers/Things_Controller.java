/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.controllers;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.ao.EntityManager;
import things.config.connect;
import things.models.Priority;
import things.models.Status;
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
    
    public Thing creatThing(String Note, Date Date ){
        
        Thing thing1 = null;
        try {
            Status status = this.connect.create(Status.class);
            status.setStatus("Important");
            status.save();
            
            Priority priority = this.connect.create(Priority.class);
            priority.setName("Normal");            
            priority.save();
            
            Thing thing = this.connect.create(Thing.class);            
            thing.setNote(Note);
            thing.setC_date(Date);
            thing.setM_date(Date);
            thing.setStatus(status);
            thing.setPriority(priority);
            thing.save();
            
            /*while(thing.getM_date().isEmpty()){
                thing1 = thing;
                return thing1;
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return thing1;
    }
}
