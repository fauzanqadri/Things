/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package things.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fauzan
 */
public class md5Converter {
        
        public static String result;
        public String convert(String input){
        String preresult = null;
        if(input != null) {
            MessageDigest md = null; 
            try {
                md = MessageDigest.getInstance("MD5"); //or "SHA-1"
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(md5Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            preresult = hash.toString(16);
            if ((preresult.length() % 2) != 0) {
                preresult = "0" + preresult;
                md5Converter.result = preresult;
               
            }
          
        }
        return preresult;
      
        }
}
