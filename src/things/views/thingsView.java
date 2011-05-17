/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * thingsView.java
 *
 * Created on May 15, 2011, 5:48:43 PM
 */
package things.views;

import javax.swing.DefaultListModel;
import things.sessions.User_session;
import things.controllers.Things_Controller;
import things.models.Thing;


/**
 *
 * @author fauzan
 */
public class thingsView extends javax.swing.JFrame  {
    private Things_Controller thing;
   
    /** Creates new form thingsView */
    public thingsView() {
        initComponents();
        thing.reminder();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        userIdentity = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        highPriorityList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        normalPriorityList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        justRemindMePriorityList = new javax.swing.JList();
        logoutButton = new javax.swing.JButton();
        addThingButton = new javax.swing.JButton();
        userIdentitiy = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(User_session.current_user.getName()+"'s Plan");
        setResizable(false);

        userIdentity.setFont(new java.awt.Font("Ubuntu", 1, 18));

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        getHighPriorityThings();
        jScrollPane2.setViewportView(highPriorityList);

        jTabbedPane1.addTab("High Priority", jScrollPane2);

        getNormalPriorityThings();
        jScrollPane3.setViewportView(normalPriorityList);

        jTabbedPane1.addTab("Normal", jScrollPane3);

        getJustRemindMePriorityThings();
        jScrollPane4.setViewportView(justRemindMePriorityList);

        jTabbedPane1.addTab("Just Remind Me", jScrollPane4);

        logoutButton.setText("Logut");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        addThingButton.setText("Add plan");
        addThingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addThingButtonActionPerformed(evt);
            }
        });

        userIdentitiy.setFont(new java.awt.Font("Ubuntu", 1, 18));
        userIdentitiy.setText(User_session.current_user.getName()+"'s Plans");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userIdentitiy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(userIdentity)
                    .addComponent(addThingButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIdentity)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutButton)
                        .addComponent(userIdentitiy)))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addThingButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_jTabbedPane1FocusGained

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        User_session sess = new User_session(false);
        this.dispose();
        System.exit(0);
}//GEN-LAST:event_logoutButtonActionPerformed

    private void addThingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addThingButtonActionPerformed
        addThing At = new addThing();
        At.setVisible(true);
}//GEN-LAST:event_addThingButtonActionPerformed

    public void getHighPriorityThings(){
      thing  = new Things_Controller();
      //int id = User_session.current_user.getID();
       DefaultListModel listModel = new DefaultListModel();
        for(Thing things : thing.getHighPriorityThings()){
            listModel.addElement(things);
        }
        
        highPriorityList.setModel(listModel); 
        highPriorityList.setCellRenderer(new listThingItem());
    }
   
    public void getNormalPriorityThings(){
        thing = new Things_Controller();
     DefaultListModel listModel = new DefaultListModel();
        for(Thing things : thing.getNormalPriorityThings()){
             listModel.addElement(things);
        }
        
        normalPriorityList.setModel(listModel);
        normalPriorityList.setCellRenderer(new listThingItem());
    }
    
    public void getJustRemindMePriorityThings(){
        thing = new Things_Controller();
    DefaultListModel listModel = new DefaultListModel();
        for(Thing things : thing.getJustRemindMePriorityThings()){
              listModel.addElement(things);
        }
        justRemindMePriorityList.setModel(listModel);
        justRemindMePriorityList.setCellRenderer(new listThingItem());
        
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addThingButton;
    private javax.swing.JList highPriorityList;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList justRemindMePriorityList;
    private javax.swing.JButton logoutButton;
    private javax.swing.JList normalPriorityList;
    protected javax.swing.JLabel userIdentitiy;
    protected javax.swing.JLabel userIdentity;
    // End of variables declaration//GEN-END:variables
}
