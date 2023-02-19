package gui_v1.actios_processors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui_v1.mainWindows.GUI_RecordsFrame;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_Menu_Actions implements ActionListener, GUI_Settings_Variables{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareToIgnoreCase("Exit")==0) {
			System.exit(0);
		}else if (e.getActionCommand().compareToIgnoreCase("About")==0) {
			JOptionPane.showMessageDialog(null, ""+strAboutApp,"About", JOptionPane.INFORMATION_MESSAGE);
		}else if (e.getActionCommand().compareToIgnoreCase("Show Records Window")==0) {
			new GUI_RecordsFrame();
		}else if (e.getActionCommand().compareToIgnoreCase("Increse GUI Text Size (+)")==0) {
			increaseAllElementsFont();
		}else if (e.getActionCommand().compareToIgnoreCase("Decrese GUI Text Size (-)")==0) {
			decreaseAllElementsFont();
		}else if (e.getActionCommand().compareToIgnoreCase("Manual Entry")==0) {
			JOptionPane.showMessageDialog(null, "Manual Entry Menu","About", JOptionPane.INFORMATION_MESSAGE);
		}else if (e.getActionCommand().compareToIgnoreCase("Parse OFX File")==0) {
			JOptionPane.showMessageDialog(null, "Parse OFX File Menu","About", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getActionCommand().compareToIgnoreCase("Get Advise")==0) {
			JOptionPane.showMessageDialog(null, "Get Advise Menu","About", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getActionCommand().compareToIgnoreCase("Generate Summary")==0) {
			JOptionPane.showMessageDialog(null, "Generate Summary Menu","About", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getActionCommand().compareToIgnoreCase("How To Start")==0) {
			JOptionPane.showMessageDialog(null, "How To Start","About", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getActionCommand().compareToIgnoreCase("LogOut")==0) {
			JOptionPane.showMessageDialog(null, "Please Select Exit from File Menu","About", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return mainGUIComponent;
	}
	private Component mainGUIComponent;
	public void setMainGUIComponent(Component c) {
		mainGUIComponent=c;
	}

}
