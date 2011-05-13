/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;
import things.controllers.Things_Controller;
import things.models.Thing;
import java.util.Date;
import java.util.Scanner;
import things.config.md5Converter;
import things.controllers.login;
import things.sessions.User_session;

/**
 *
 * @author fauzan
 */
public class Things {
    public static void main(String[] args){
        //Date date = new Date();
        Scanner in = new Scanner(System.in);
        //Things_Controller things = new Things_Controller();
        //System.out.println("insert Note : ");
        //String Note = in.nextLine(); 
        //Thing creatThing = things.creatThing(Note, date);
        //for (Thing thing : things.getThings()) {
        //    System.out.println(thing.getNote());
        //}
        
        System.out.println("Insert Username : ");
        String username = in.next();
        System.out.println("Insert Password : ");
        String password = in.next();
        md5Converter md5 = new md5Converter();
        //md5.convert(password);
        
        
       
        login log = new login();
       // log.do_login(username, password);
        if(log.do_login(username, password)){
            System.out.println(User_session.user_name);
        }else{
            System.out.println("something wrong, check your password, BITCH !!!");
        }
        
        
        
        
        
        
        
        
    }
}
