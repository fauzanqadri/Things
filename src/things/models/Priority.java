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
public interface Priority extends Entity{
    
    public int getId();
    
    public void setName(String Priority);
    public String getName();
    
    
    @OneToMany
    public Thing[] getThing();
    
}
