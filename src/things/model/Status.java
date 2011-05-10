/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.model;
import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 *
 * @author fauzan
 */
public interface Status extends Entity{
    
    public String getStatus();
    public void setStatus(String Status);
    
    @OneToMany
    public Thing[] getThing();
}
