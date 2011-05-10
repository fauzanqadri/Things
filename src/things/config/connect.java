/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.config;
import net.java.ao.EntityManager;
/**
 *
 * @author fauzan
 */
public class connect {
    public EntityManager Em;
    private String db_user = "root";
    private String db_pass = null;
    
    public connect(){
        this.Em = new EntityManager("jdbc:mysql://localhost/test",this.db_user,this.db_pass);
    }
    
}

