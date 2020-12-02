package softecon.javaswing.test.utils;

import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import softecon.javaswing.test.vo.VO_GUI;

/*
 * @author tkol
 */
public class Tools {

    public static String DEF_LookAndFell_Metal = "Metal";
    public static String DEF_LookAndFell_Nimbus = "Nimbus";
    public static String DEF_LookAndFell_CDE_Motif = "CDE/Motif";
    public static String DEF_LookAndFell_Windows = "Windows";
    public static String DEF_LookAndFell_Windows_Classic = "Windows Classic";

    public static String CurrentLookAndFell = DEF_LookAndFell_CDE_Motif;

    public static void setFrameIcon(Frame frame) {
        ImageIcon img = new ImageIcon("C:\\Users\\tkol.SOFTECON\\Documents\\NetBeansProjects\\JavaSwing\\src\\softecon\\javaswing\\test\\icons/logo.png");
        frame.setIconImage(img.getImage());

    }

    public static void setFrameIcon(Dialog frame) {
        ImageIcon img = new ImageIcon("C:\\Users\\tkol.SOFTECON\\Documents\\NetBeansProjects\\JavaSwing\\src\\softecon\\javaswing\\test\\icons/logo.png");
        frame.setIconImage(img.getImage());

    }

    public static void populateComboBox(JComboBox jComboBox) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            jComboBox.addItem(new VO_GUI(info.getName(), info.getClassName()));
        }
    }

    public static void setLookAndFell() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (CurrentLookAndFell.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Something's wrong", JOptionPane.ERROR_MESSAGE);
        }
    }

}
