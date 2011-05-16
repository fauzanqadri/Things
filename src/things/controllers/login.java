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
import things.sessions.User_session;
import things.models.User;
import things.config.connect;
import things.config.md5Converter;
/**
 *
 * @author fauzan
 */
public class login {
    public EntityManager connect = new connect().Em;
    public User_session user_data;
    
    public boolean do_login(String username , String pass){
      // just for testing
      username = "ojankill";
      pass = "helenkill";
      md5Converter md5= new md5Converter();
      String finalpass = md5.convert(pass);
       boolean status  = false;
        try {
        User [] user = connect.find(User.class,Query.select().where("username = ?", username).where("password = ?", finalpass)); 
            if(user.length > 0){
                this.user_data = new User_session(user[0]);
                status = true;
                
            }else{
                status = false;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        hasLogin(status);
        return status;
    }
    
    public boolean hasLogin(boolean var){
        return var;
    }
    
}
