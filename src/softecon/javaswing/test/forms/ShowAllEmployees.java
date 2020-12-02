/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softecon.javaswing.test.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import softecon.javaswing.test.utils.Tools;
import softecon.javaswing.test.vo.VO_Employee;
import softecon.javaswing.test.vo.VO_Job;

/**
 *
 * @author tkol
 */
public class ShowAllEmployees extends javax.swing.JFrame {
    
    ArrayList<VO_Employee> empList;
    ArrayList<VO_Job> jobList;
    String firstLineToAdd = "\t" + "ID \t" + "NAME \t" + "SURNAME \t" + "JOB \t\t" + "SALARY \t" + "\n"
            + "\t" + "-- \t" + "---- \t" + "------- \t" + "--- \t\t" + "------ \t" + "\n";

    /**
     * Creates new form ShowAllEmployees
     */
    public ShowAllEmployees() {
        initComponents();
        
        init();
        
    }
    
    public void init() {
        Tools.setFrameIcon(this);
        
        empList = new ArrayList<VO_Employee>();
        jobList = new ArrayList<VO_Job>();
        
        populateList();
        showSortedList();
        //hide these buttons instead of delete, code inside these buttons is commented
        btnShortByName.hide();
        btnShortBySalary.hide();

//          jTextArea1.append(firstLineToAdd);
//        for (VO_Employee emp : empList) {
//            jTextArea1.append("\t" + emp.getEmpId() + "\t" + emp.getEmpName()+ "\t" +  emp.getEmpSurname()+ "\t" +  emp.getEmpJob().getNameOfJob()+ "\t\t" +  emp.getEmpJob().getSalary() + "$" + "\n");
//        }
    }
    
    public void showSortedList() {
        ArrayList<VO_Employee> empSortedByName = new ArrayList<VO_Employee>();
        empSortedByName = empList;
        
        Collections.sort(empSortedByName);
//            Collections.sort(empSortedByName, new Comparator<VO_Employee>() {
//                @Override
//                public int compare(VO_Employee emp1, VO_Employee emp2) {
//
//                   int result =  (int) emp1.getEmpName().compareTo(emp2.getEmpName());
//                     int secResult = (int) (result == 0 ? emp1.getEmpSurname().compareTo(emp2.getEmpSurname()) : result);    
//                     return (int) (result == 0 ? emp1.getEmpJob().getSalary() - (emp2.getEmpJob().getSalary()) : secResult);  
//                    
//                }
//            });

        jTextArea1.setText("");
        jTextArea1.append(firstLineToAdd);
        
        for (VO_Employee emp : empSortedByName) {
            jTextArea1.append("\t" + emp.getEmpId() + "\t" + emp.getEmpName() + "\t" + emp.getEmpSurname() + "\t" + emp.getEmpJob().getNameOfJob() + "\t\t" + emp.getEmpJob().getSalary() + "$" + "\n");
        }
    }
    
    public void populateList() {
        // try to populate the arraylist of jobs just like i did in addNewFormJob
        //it starts here and ends....
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
        //ends here the population of the joblist, the arraylist
        //------------------------------------------------------
        //i do the same to populate the emplist, the arraylist of employees
        try {
            FileInputStream file2 = new FileInputStream("Employees.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            boolean endOfFile = false;
            
            while (!endOfFile) {
                try {
                    empList.add((VO_Employee) inputFile2.readObject());
                    
                } catch (EOFException e) {
//                JOptionPane.showMessageDialog(null, e.getMessage(), "END OF FILE", JOptionPane.INFORMATION_MESSAGE);
                    endOfFile = true;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Something's wrong... '1'", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            inputFile2.close();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnShortByName = new javax.swing.JToggleButton();
        btnShortBySalary = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(850, 470));
        setMinimumSize(new java.awt.Dimension(770, 450));
        setPreferredSize(new java.awt.Dimension(850, 470));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel1.setText("This is a list with all the employees");

        btnShortByName.setText("SORT BY NAME");
        btnShortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShortByNameActionPerformed(evt);
            }
        });

        btnShortBySalary.setText("SORT BY SALARY");
        btnShortBySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShortBySalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShortByName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShortBySalary)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnShortByName)
                    .addComponent(btnShortBySalary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShortByNameActionPerformed
//        ArrayList<VO_Employee> empSortedByName = new ArrayList<VO_Employee>();
//        empSortedByName = empList;
//
//        if (btnShortByName.isSelected()) {
//            Collections.sort(empSortedByName, new Comparator<VO_Employee>() {
//                @Override
//                public int compare(VO_Employee emp1, VO_Employee emp2) {
//                    
////                    return (int) emp1.getEmpName().compareTo(emp2.getEmpName());
//                    //-----------------------------------//
//                    //this is my solution to fix the sort problem//
//                    //now if the name is equal with the other name, it compares the salary and gives the lower first
//                   int result =  (int) emp1.getEmpName().compareTo(emp2.getEmpName());
//                     int secResult = (int) (result == 0 ? emp1.getEmpSurname().compareTo(emp2.getEmpSurname()) : result);  
////                     return (int) (result == 0 ? emp1.getEmpJob().getSalary() - (emp2.getEmpJob().getSalary()) : result);  
//                     return (int) (result == 0 ? emp1.getEmpJob().getSalary() - (emp2.getEmpJob().getSalary()) : secResult);  
//                    
//                }
//            });
//
//            jTextArea1.setText("");
//            jTextArea1.append(firstLineToAdd);
//            
//            for (VO_Employee emp : empSortedByName) {
//                jTextArea1.append("\t" + emp.getEmpId() +"\t" + emp.getEmpName()+"\t" +  emp.getEmpSurname()+"\t" + emp.getEmpJob().getNameOfJob() +"\t\t"+  emp.getEmpJob().getSalary() + "$" + "\n");
//            }
//        } else {
//            Collections.sort(empSortedByName, new Comparator<VO_Employee>() {
//                @Override
//                public int compare(VO_Employee emp1, VO_Employee emp2) {
//                    return (int)(emp2.getEmpName().compareTo(emp1.getEmpName()));
//                }
//            });
//
//            jTextArea1.setText("");
//            jTextArea1.append(firstLineToAdd);
//            for (VO_Employee emp : empSortedByName) {
//                jTextArea1.append("\t" + emp.getEmpId() +"\t" + emp.getEmpName()+"\t" +  emp.getEmpSurname()+"\t" + emp.getEmpJob().getNameOfJob() +"\t\t"+  emp.getEmpJob().getSalary() + "$" + "\n");
//            }
//        }

    }//GEN-LAST:event_btnShortByNameActionPerformed

    private void btnShortBySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShortBySalaryActionPerformed
//        ArrayList<VO_Employee> empSortedBySalary = new ArrayList<VO_Employee>();
//        empSortedBySalary = empList;
//
//        if (btnShortBySalary.isSelected()) {
//            Collections.sort(empSortedBySalary, new Comparator<VO_Employee>() {
//                @Override
//                public int compare(VO_Employee emp1, VO_Employee emp2) {
//                    return (int) (emp1.getEmpJob().getSalary() - emp2.getEmpJob().getSalary());
//                }
//            });
//            jTextArea1.setText("");
//            jTextArea1.append(firstLineToAdd);
//            for (VO_Employee emp : empSortedBySalary) {
//                jTextArea1.append("\t" + emp.getEmpId() +"\t" + emp.getEmpName()+"\t" +  emp.getEmpSurname()+"\t" + emp.getEmpJob().getNameOfJob() +"\t\t"+  emp.getEmpJob().getSalary() + "$" + "\n");
//            }
//        } else {
//            Collections.sort(empSortedBySalary, new Comparator<VO_Employee>() {
//                @Override
//                public int compare(VO_Employee emp1, VO_Employee emp2) {
//                    return (int) (emp2.getEmpJob().getSalary() - emp1.getEmpJob().getSalary());
//                }
//            });
//            jTextArea1.setText("");
//            jTextArea1.append(firstLineToAdd);
//            for (VO_Employee emp : empSortedBySalary) {
//                jTextArea1.append("\t" + emp.getEmpId() +"\t" + emp.getEmpName()+"\t" +  emp.getEmpSurname()+"\t" + emp.getEmpJob().getNameOfJob() +"\t\t"+  emp.getEmpJob().getSalary() + "$" + "\n");
//            }
//        }


    }//GEN-LAST:event_btnShortBySalaryActionPerformed

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
            java.util.logging.Logger.getLogger(ShowAllEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowAllEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowAllEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowAllEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowAllEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnShortByName;
    private javax.swing.JToggleButton btnShortBySalary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
