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
import net.java.ao.Query;
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
            status.setName("Important");
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
    
    public Thing[] singleThing(Object Date){
       Thing[] thing = null;
        try {
            thing = connect.find(Thing.class, Query.select().where("due_time = ?", Date).limit(1));
            while(thing.length == 0){
                thing = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return thing;
    }
    
    public Priority[] getPriority(){
        Priority[] priority = null;
        try {            
            priority = connect.find(Priority.class);
            while(priority.length<1){
                priority=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return priority;
    }
    
    public Status[] getStatusValue(){
        Status[] status = null;
        try {            
            status =  connect.find(Status.class);
            while(status.length < 1){
                status = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}