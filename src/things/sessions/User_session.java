/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.sessions;
import things.controllers.login;
import things.models.User;
/**
 *
 * @author fauzan
 */
public class User_session {
   public static String user_name;
   public static Boolean is_login;
   public static int user_id;
    public static User current_user;
   
   private login log = new login();
   public User_session user_data;
   
   public User_session(User user){
    User_session.user_name = user.getUsername();
    User_session.user_id = user.getID();
    User_session.is_login = true;
    User_session.current_user = user;
   }
   public User_session(Boolean var){
    User_session.user_name = null;
    User_session.user_id = 0;
    User_session.is_login = var;
    User_session.current_user = null;
   }
   public User_session(){
       
   }
       
}
