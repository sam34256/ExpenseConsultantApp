package gui_v1.actios_processors;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn_Actions  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().compareToIgnoreCase("OK")==0) {
            JOptionPane.showMessageDialog(null, "ButtonOK","Confirm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}