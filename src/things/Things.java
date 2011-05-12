/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;
import things.controllers.Things_Controller;
import things.models.Thing;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author fauzan
 */
public class Things {
    public static void main(String[] args){
        Date date = new Date();
        Scanner in = new Scanner(System.in);
        Things_Controller things = new Things_Controller();
        System.out.println("insert Note : ");
        String Note = in.nextLine(); 
        Thing creatThing = things.creatThing(Note, date);
        //for (Thing thing : things.getThings()) {
        //    System.out.println(thing.getNote());
        //}
        
    }
}
