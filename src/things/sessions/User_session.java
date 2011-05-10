/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.sessions;

/**
 *
 * @author fauzan
 */
public class User_session {
   public static String user_name;
   public static Boolean is_login;
   public static int user_id;
   public User_session user_data;
   
   public User_session(String user_name, int user_id){
    User_session.user_name = user_name;
    User_session.user_id = user_id;
    User_session.is_login = true;
   }
   public User_session(Boolean var){
    User_session.user_name = null;
    User_session.user_id = 0;
    User_session.is_login = var;
   }
   public User_session(){
       
   }
    
}
