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
public interface User extends Entity{
    
    public void setName(String Name);
    public String getName();
    
    public void setUsername(String Username);
    public String getUsername();
    
    public void setPassword(String Password);
    public String getPassword();
    
    public void setEmail(String Email);
    public String getEmail();
    
    @OneToMany
    public Thing[] getThing();
    
}