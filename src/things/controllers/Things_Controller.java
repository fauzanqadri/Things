/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.ao.EntityManager;
import net.java.ao.Query;
import things.config.connect;
import things.models.Priority;
import things.models.Status;
import things.models.Thing;
import java.util.Date;
import things.sessions.User_session;

/**
 *
 * @author fauzan
 */
public class Things_Controller {
   // public Thing[] thing;
    public EntityManager connect = new connect().Em;
    private Date date = new Date();
    
    public Thing[] getHighPriorityThings(){
        Thing[] thing = null;
        try {
            thing = connect.find(Thing.class, Query.select().where("priorityID = ?", "7"));
            while(thing.length<1){
                System.out.println("null");
                thing=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thing;
    }
    public Thing[] getNormalPriorityThings(){
        Thing[] thing = null;
        try {
            thing = connect.find(Thing.class, Query.select().where("priorityID = ?", "8"));
            while(thing.length<1){
                thing=null;
                System.out.println("null");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thing;
    }
    
    public Thing[] getJustRemindMePriorityThings(){
        Thing[] thing = null;
        try {
            thing = connect.find(Thing.class, Query.select().where("priorityID = ?", "9"));
            while(thing.length<1){
                thing=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thing;
    }
            
    public Thing creatThing(String Note, String priority_name,Date dueDate){
        System.out.println(dueDate);
        Thing thing1 = null;
        Thing newT = null;
        try {
            Status[] status = connect.find(Status.class, Query.select().where("id = ?", 9));
            String name = status[0].getName();
            if (status.length==0) {
                status = null;
            }
            
            Priority[] priority = connect.find(Priority.class, Query.select().where("name = ?", priority_name).limit(1));
            //String pr = priority[0].getName();
            System.out.println(priority[0].getName());
            if (priority.length==0) {
                priority = null;
            }
           if(priority != null && status != null){ 
            
            newT = this.connect.create(Thing.class);            
            newT.setNote(Note);
            newT.setC_date(this.date);
            newT.setM_date(this.date);
            newT.setStatus(status[0]);
            newT.setPriority(priority[0]);
            newT.setDue_time(dueDate);
            newT.setUser(User_session.current_user);
            newT.save();
            
           }else{
            thing1 = null;
           }
              while (newT != null){
                thing1 = newT;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return thing1;
    }
    
    public Thing[] singleThing(Object Date){
       Thing[] thing = null;
        try {
            thing = connect.find(Thing.class, Query.select().where("id = ?", Date).limit(1));
            while(thing.length == 0){
                thing = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return thing;
    }
     public Thing singleThing(int id){
       
       Thing thing = null;
       
            thing = connect.get(Thing.class, id);
            while(thing == null){
                thing = null;
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
    
    public Thing[] updateThing(int id, String Note, String dueDate){
        Thing[] thing = null;
        
        try {
            thing = connect.find(Thing.class, Query.select().where("id = ?", id).limit(1));
            thing[0].setNote(Note);
            thing[0].setM_date(this.date);
            thing[0].setDue_time(this.date);
            //thing[0].setPriority(priority);
            //thing[0].setStatus(status);
            thing[0].save();
        } catch (SQLException ex) {
            Logger.getLogger(Things_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thing;
    }

}