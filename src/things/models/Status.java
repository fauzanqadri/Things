/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.models;
import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 *
 * @author fauzan
 */
public interface Status extends Entity{
    
    public String getName();
    public void setName(String Status);
    
    @OneToMany
    public Thing[] getThing();
}
