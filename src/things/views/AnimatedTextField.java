    

/**
 *   Arsenal Real-Time Collaboration Server Project
 *   Copyright (C) 2003  Michael Burnside, Arsenal Project
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * ***************************************************************** 
 *    $Header: /cvs/coolcollaborator/prod/coolcollaborator/prod/util/src/com/arsenal/util/AnimatedTextField.java,v 1.1.1.1 2006/01/12 04:54:02 mburnside Exp $ 
 *     
 *    File: $Workfile: AnimatedTextField.java $ 
 *     
 *    Description: 
 *     
 *    
 *     
 *    @author      michael@michaelburnside.com (arsenal-1) 
 *    @author      Michael Burnside 
 *    @version     %I%, %G% 
 *    @since       1.0 
 *     
 */
package things.views;
import java.io.File;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AnimatedTextField extends JPanel implements FocusListener {
        
        Font font = new Font("Arial", Font.PLAIN, 10);
        Color darkSlateGray = new Color(49,79,79);
        Color dimGray = new Color(105,105,105);
        Color slateGray = new Color(112,138,144);
        Color lightSlateGray = new Color(119,136,153);
        Color gray = new Color(190,190,190);
        Color lightGray = new Color(211,211,211);
        Color[] colors = { Color.black, darkSlateGray, dimGray, slateGray,
                lightSlateGray, gray, lightGray, Color.white };
        
  private JTextField textField = new JTextField();
        private JLabel label = new JLabel();
        private int fadeSpeed = 50;
        private boolean animate = false;
        private boolean allowFade = false;
        private boolean fadeOut = false;
        private boolean fadeIn = false;
  private Color foreground = Color.black;
  public void setDefaultForeground(Color foreground) { this.foreground = foreground; }

        private boolean allowAnimate = true; // we will animate
  
  public AnimatedTextField(String labelText, boolean useBgImage, Color defaultForeground, boolean allowAnimate) { 
    this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
          label.setText(labelText);
    textField.addFocusListener(this);
          label.setBackground(colors[0]);
    textField.setBackground(colors[0]);
    this.foreground = defaultForeground;
          this.allowAnimate = allowAnimate;
          label.setForeground(foreground);
    textField.setForeground(foreground);
          add(label);
    add(textField);
          if(allowAnimate) 
            runThread.start();
          if(allowFade) {
            fadeInThread.start();
            fadeOutThread.start();
          }
          setOpaque(false);
  }
  
  public AnimatedTextField(String labelText, boolean useBgImage, Color defaultForeground, boolean allowAnimate, boolean allowFade) { 
      this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
            label.setText(labelText);
      textField.addFocusListener(this);
            label.setBackground(colors[0]);
      textField.setBackground(colors[0]);
      this.foreground = defaultForeground;
            this.allowAnimate = allowAnimate;
            this.allowFade = allowFade;
            label.setForeground(foreground);
      textField.setForeground(foreground);
            add(label);
      add(textField);
            if(allowAnimate) 
              runThread.start();
            if(allowFade) {
              fadeInThread.start();
              fadeOutThread.start();
            }
            setOpaque(false);
    } 
  
    public void addActionListener(ActionListener actionListener) {
        textField.addActionListener(actionListener);
     }
        
        
        private Thread runThread = new Thread(
          new  Runnable() {    
            public void run() {
              while(true) {
                try { runThread.sleep(100); } catch(Exception e) { }       
                if(animate) {
                  for(int i = 0; i < colors.length; i++) {
                    label.setForeground(colors[i]);
                    try { runThread.sleep(20); } catch(Exception e) { }
                  }
                  try { runThread.sleep(100); } catch(Exception e) { }
                  for(int i = colors.length -1 ; i >= 0; i--) {
                    label.setForeground(colors[i]);      
                    try { runThread.sleep(20); } catch(Exception le) { }
                  }
                } // end if animate
                label.setForeground(foreground); 
              } //end while
            }
          }
        );
     
        
        private Thread fadeInThread = new Thread(
          new  Runnable() {    
            public void run() {
               while(true) {
                 if(fadeIn) {     
                   fadeIn();
                   fadeIn = false;
                 }
                 try { fadeInThread.sleep(fadeSpeed); } catch(Exception le) { }
               }
            }
          }
        );
        
        
        private Thread fadeOutThread = new Thread(
          new  Runnable() {    
            public void run() {
               while(true) {
                 if(fadeOut) {
                   fadeOut();
                   fadeOut = false;
                 }
                 try { fadeOutThread.sleep(fadeSpeed); } catch(Exception le) { }
               }
            }
          }
        );
        
  public void focusGained(FocusEvent e) 
  {
           //if(allowAnimate) fadeIn();
           animate = true;
           if(allowFade) {
             fadeIn = true;
             fadeOut = false;
           }
           else {
             textField.setBackground(Color.white);
             textField.setForeground(Color.black);
           }
  }

  public void focusLost(FocusEvent e) 
  {
           //if(allowAnimate) fadeOut();
           animate = false;
           if(allowFade) {
             fadeOut = true;
             fadeIn = false;
             try { runThread.sleep(50); } catch(Exception le) { }
           }
           else {
             textField.setBackground(Color.black);
             textField.setForeground(Color.white);
           }
  }
        /**
         *
         * disable the components on this panel
         *
         */
  public void setInputsDisabled() 
  {
           setInputsEnabled(false);
  }
        /**
         *
         * enable the components on this panel
         *
         */
  public void setInputsEnabled() 
  {
           setInputsEnabled(true);
  }

        /**
         *
         * enable or disable the components on this panel
         *
         * @param enable or disable
         *
         */
  public void setInputsEnabled(boolean enable) 
  {
     textField.setEnabled(enable);
     //label.setEnabled(enable);
           if(!enable) animate = false;
  }
        /**
         *
         * are the inputs enabled
         *
         * @returns boolean
         *
         */
  public boolean areInputsEnabled() 
  {
     return textField.isEnabled();
  }        
        /**
         *
         * Sets the label's maximum size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */         
        public void setLabelMaximumSize(int width, int height) {
           label.setMaximumSize(new Dimension(width, height));       
        }
        /**
         *
         * Sets the label's minimum size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */
        public void setLabelMinimumSize(int width, int height) {
           label.setMinimumSize(new Dimension(width, height));       
        }
        /**
         *
         * Sets the label's preferred size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */        
        public void setLabelPreferredSize(int width, int height) {
           label.setPreferredSize(new Dimension(width, height));       
        }
        /**
         *
         * Sets the text field's maximum size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */
        public void setTextFieldMaximumSize(int width, int height) {
           textField.setMaximumSize(new Dimension(width, height));       
        }
        /**
         *
         * Sets the text field's minimum size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */
        public void setTextFieldMinimumSize(int width, int height) {
           textField.setMinimumSize(new Dimension(width, height));       
        }
        /**
         *
         * Sets the text field's preferred size
         *
         * @param width width, in pixels
         * @param height height, in pixels
         *
         */        
        public void setTextFieldPreferredSize(int width, int height) {
           textField.setPreferredSize(new Dimension(width, height));       
        }
        /**
         *
         * Gets the text field's value
         *
         * @return the text field value after trim()
         *
         */        
        public String getValue() {
           return textField.getText().trim();       
        }
        /**
         *
         * gets the label instance
         *
         * @return jlabel component of this class
         *
         */        
        public JLabel getLabel() {
           return label;       
        }
        /**
         *
         * gets the text field instance
         *
         * @return textfield component of this class
         *
         */        
        public JTextField getTextField() {
           return textField;       
        }
        
        public void setText(String text) {
           textField.setText(text);
        }
        
        private void fadeIn() {
          textField.setForeground(Color.black);
          for(int i = 0; i < colors.length; i++) {
            textField.setBackground(colors[i]);
            try { Thread.sleep(fadeSpeed); } catch(Exception e) { }
          }                
        }
        
        private void fadeOut() {
          textField.setForeground(Color.white);
          for(int i = colors.length -1 ; i >= 0; i--) {
            textField.setBackground(colors[i]); 
            try { Thread.sleep(fadeSpeed); } catch(Exception le) { }
          }
        }
        
}

   