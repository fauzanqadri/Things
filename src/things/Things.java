/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;

import java.util.Scanner;
import things.controllers.login;
import things.sessions.User_session;

/**
 *
 * @author fauzan
 */
public class Things {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        System.out.println("Hallo");
        
        // User Session Teter
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Nama :");
        String nama = input.nextLine();
        System.out.print("Masukan ID :");
        int id = input.nextInt();
      
        login set = new login();
        set.do_login(nama, id);
        System.out.println("--------------------------------\n");
        System.out.println(User_session.user_name);
        
        System.out.println("Logout ? y/n");
        String choose = input.next();
        if(choose.equals("y") || choose.equals("Y")){
        set.do_logout();
        System.out.println(User_session.user_name);
        }else{
         System.out.println(User_session.user_name);
        }*/
        
    }
}
