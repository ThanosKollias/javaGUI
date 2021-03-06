/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softecon.javaswing.test.forms;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import softecon.javaswing.test.utils.Tools;
import softecon.javaswing.test.vo.VO_Employee;
import softecon.javaswing.test.vo.VO_Job;

/**
 *
 * @author tkol
 */
public class EditJobForm extends javax.swing.JDialog {

    /**
     * Creates new form EditJobForm
     */
    ArrayList<VO_Job> jobList = null;

    public EditJobForm() {
        setModal(true);
        initComponents();
        init();
    }

    public void init() {
        Tools.setFrameIcon(this);

        jobList = new ArrayList<VO_Job>();

        populateList();

        String[] jobsArray = new String[jobList.size()];

        for (int i = 0; i < jobList.size(); i++) {
            jobsArray[i] = jobList.get(i).getNameOfJob() + " with avg salary of :" + jobList.get(i).getSalary();
        }

        chooseJobCbx.setModel(new javax.swing.DefaultComboBoxModel<>(jobsArray));
        chooseJobCbx.setSelectedIndex(0);
    }

    public void saveJobsToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Jobs.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(fileOutputStream);

            for (VO_Job job : jobList) {
                outputFile.writeObject(job);
            }
            outputFile.close();
            JOptionPane.showMessageDialog(null, "You did it!");
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Something's wrong... '3'", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateList() {
        try {
            FileInputStream file = new FileInputStream("Jobs.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            boolean endOfFile = false;

            while (!endOfFile) {
                try {
                    jobList.add((VO_Job) inputFile.readObject());

                } catch (EOFException e) {
//                JOptionPane.showMessageDialog(null, e.getMessage(), "END OF FILE", JOptionPane.INFORMATION_MESSAGE);
                    endOfFile = true;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Something's wrong... '1'", JOptionPane.ERROR_MESSAGE);
                }
            }

            inputFile.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Something's wrong... '2'", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        saveJobBtn = new javax.swing.JButton();
        deleteJobBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jobNameTxt = new javax.swing.JTextField();
        jobSalaryTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chooseJobCbx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(770, 450));
        setMinimumSize(new java.awt.Dimension(770, 450));
        setPreferredSize(new java.awt.Dimension(770, 450));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel1.setText("EDIT JOB FORM");

        saveJobBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/softecon/javaswing/test/icons/save.png"))); // NOI18N
        saveJobBtn.setText("SAVE");
        saveJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJobBtnActionPerformed(evt);
            }
        });

        deleteJobBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/softecon/javaswing/test/icons/exit.png"))); // NOI18N
        deleteJobBtn.setText("DELETE");
        deleteJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJobBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("JOB NAME :");

        jLabel3.setText("JOB SALARY :");

        jobNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNameTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("CHOOSE JOB :");

        chooseJobCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        chooseJobCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseJobCbxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(saveJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deleteJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jobNameTxt)
                            .addComponent(jobSalaryTxt)
                            .addComponent(chooseJobCbx, 0, 210, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chooseJobCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobSalaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveJobBtn)
                    .addComponent(deleteJobBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jobNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobNameTxtActionPerformed

    private void chooseJobCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseJobCbxActionPerformed
        int selectedIndex = chooseJobCbx.getSelectedIndex();
        jobNameTxt.setText(jobList.get(selectedIndex).getNameOfJob());
        jobSalaryTxt.setText(jobList.get(selectedIndex).getSalary() + "");

    }//GEN-LAST:event_chooseJobCbxActionPerformed

    private void saveJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJobBtnActionPerformed
        if (jobNameTxt.getText().isEmpty() || jobSalaryTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out everything to proceed");
        } else {
            int selectedIndex = chooseJobCbx.getSelectedIndex();
            jobList.get(selectedIndex).setNameOfJob(jobNameTxt.getText().trim());
            jobList.get(selectedIndex).setSalary(Double.parseDouble(jobSalaryTxt.getText().trim()));
            saveJobsToFile();
        }
        new EditJobForm().setVisible(true);
    }//GEN-LAST:event_saveJobBtnActionPerformed

    private void deleteJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJobBtnActionPerformed
        int selectedIndex = chooseJobCbx.getSelectedIndex();

        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", ""
                + "Are you sure?",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            jobList.remove(selectedIndex);
            saveJobsToFile();
            new EditJobForm().setVisible(true);
        }
    }//GEN-LAST:event_deleteJobBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditJobForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chooseJobCbx;
    private javax.swing.JButton deleteJobBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jobNameTxt;
    private javax.swing.JTextField jobSalaryTxt;
    private javax.swing.JButton saveJobBtn;
    // End of variables declaration//GEN-END:variables
}
