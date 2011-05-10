/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.models;
import java.sql.Types;
import net.java.ao.Entity;
import net.java.ao.schema.SQLType;

/**
 *
 * @author fauzan
 */
public interface Thing extends Entity{
    
    public void setNote(String Note);
    public String getNote();
    
    public void setC_date(String C_date);
    public String getC_date();
    
    public void setM_date(String M_date);
    public String getM_date();
    
    public void setStatus();
    public Status getStatus();
    
    public void setPriority();
    public Priority getPriority();
    
    public void setDue_time(String Due_time);
    public String getDue_time();
    
    public void setUser();
    public User getser();
    
    
}
