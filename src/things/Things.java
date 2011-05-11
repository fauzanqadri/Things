/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things;
import things.controllers.Things_Controller;
import things.models.Thing;

/**
 *
 * @author fauzan
 */
public class Things {
    public static void main(String[] args){
        Things_Controller things = new Things_Controller();
        for (Thing thing : things.getThings()) {
            System.out.println(thing.getNote());
        }
        
    }
}
