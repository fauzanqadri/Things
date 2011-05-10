/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.models;

import net.java.ao.OneToMany;

/**
 *
 * @author fauzan
 */
public interface Priority {
    
    public String getPriority(String Priority);
    public void setPriority();
    
    @OneToMany
    public Thing[] getThing();
    
}
