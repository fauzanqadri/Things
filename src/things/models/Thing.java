/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.models;
import java.sql.Types;
import java.util.Date;
import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.schema.SQLType;

/**
 *
 * @author fauzan
 */
public interface Thing extends Entity{
    
    public void setNote(String Note);
    public String getNote();
    
    public void setC_date(Date C_date);
    public String getC_date();
    
    public void setM_date(Date M_date);
    public String getM_date();
    
    public void setStatus(Status status);
    public Status getStatus();
    
    public void setPriority(Priority priority);
    public Priority getPriority();
    
    public void setDue_time(String Due_time);
    public String getDue_time();
    
    public void setUser(User user);
    public User getser();
    
    
}
