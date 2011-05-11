/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.config;
import net.java.ao.EntityManager;
import net.java.ao.schema.PluralizedNameConverter;
/**
 *
 * @author fauzan
 */
public class connect {
    public EntityManager Em;
    private String db_user = "root";
    private String db_pass = null;
    
    public connect(){
        this.Em = new EntityManager("jdbc:mysql://localhost/things_db",this.db_user,this.db_pass);
        this.Em.setTableNameConverter(new PluralizedNameConverter());  
    }
    
    
}

