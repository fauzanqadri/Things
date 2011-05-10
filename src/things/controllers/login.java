/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.controllers;

import things.sessions.User_session;

/**
 *
 * @author fauzan
 */
public class login {
    public User_session user_data ;
    public void do_login(String user_name, int user_id){
    this.user_data = new User_session(user_name, user_id);
    }
    public void do_logout(){
    this.user_data = new User_session(false);
    }
    
}
