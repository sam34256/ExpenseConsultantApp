package gui_v1.menu;


import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import gui_v1.actios_processors.GUI_Menu_Actions;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;
public class GUI_Menu extends JMenuBar implements GUI_Settings_Variables{
	private static final long serialVersionUID = 1L;
	private GUI_Menu_Actions a;
	public GUI_Menu(){
		if(gui_v1.settings.GUI_Static_Settings.workStage==0){
			setBackground(clrB_JMenuBar);
		}else{
			setForeground(clrF_JMenuBar);
		}


		setFont(GUI_ElementCreator.newFont(this.getFont(), txtSize_JMenuBar));
		a = new GUI_Menu_Actions();

		JMenu jmFile = GUI_ElementCreator.newJMenu("File");
		jmFile.setMnemonic('F');
		JMenuItem jmiSave = GUI_ElementCreator.newJMenuItem("Save");
		jmiSave.setMnemonic('v');
		jmFile.add(jmiSave);
		JMenuItem jmiLoad = GUI_ElementCreator.newJMenuItem("Load");
		jmiLoad.setMnemonic('L');
		jmFile.add(jmiLoad);
		jmFile.add(new JSeparator());
		JMenuItem jmiExit = GUI_ElementCreator.newJMenuItem("Exit");
		jmiExit.setMnemonic('E');
		jmFile.add(jmiExit);
		add(jmFile);
		jmiExit.addActionListener(a);


		
		
		JMenu jmAction = GUI_ElementCreator.newJMenu("Transactions" );
		jmAction.setMnemonic('T');
		jmAction.addActionListener(a);
//		JMenuItem jmiAddDataManually = GUI_ElementCreator.newJMenuItem("Manual Entry");
//		jmiAddDataManually.setMnemonic('M');
//		jmiAddDataManually.addActionListener(a);
//		jmAction.add(jmiAddDataManually);
//		JMenuItem jmiParseOFX = GUI_ElementCreator.newJMenuItem("Parse OFX File");
//		jmiParseOFX.setMnemonic('P');
//		jmiParseOFX.addActionListener(a);
//		jmAction.add(jmiParseOFX);
//		JMenuItem jmiAdvising = GUI_ElementCreator.newJMenuItem("Get Advise");
//		jmiAdvising.setMnemonic('G');
//		jmiAdvising.addActionListener(a);
//		jmAction.add(jmiAdvising);
//		JMenuItem jmiEditData = GUI_ElementCreator.newJMenuItem("Generate Summary");
//		jmiEditData.setMnemonic('S');
//		jmiEditData.addActionListener(a);
//		jmAction.add(jmiEditData);

//		add(jmAction);


		JMenu jmVMenu = GUI_ElementCreator.newJMenu("Menu");
		jmVMenu.setMnemonic('M');

//		JMenu jmHelp = GUI_ElementCreator.newJMenu("Help" );
//		jmHelp.setMnemonic('H');

		JMenuItem jmiHowStart = GUI_ElementCreator.newJMenuItem("How To Start");
		jmiHowStart.setMnemonic('S');
		jmiHowStart.addActionListener(a);
		jmVMenu.add(jmiHowStart);

		JMenuItem jmiParseOFX = GUI_ElementCreator.newJMenuItem("Parse OFX File");
		jmiParseOFX.setMnemonic('P');
		jmiParseOFX.addActionListener(a);
		jmVMenu.add(jmiParseOFX);

		JMenuItem jmiAddDataManually = GUI_ElementCreator.newJMenuItem("Manual Entry");
		jmiAddDataManually.setMnemonic('M');
		jmiAddDataManually.addActionListener(a);
		jmVMenu.add(jmiAddDataManually);

		JMenuItem jmiSummery = GUI_ElementCreator.newJMenuItem("Generate Summary");
		jmiSummery.setMnemonic('S');
		jmiSummery.addActionListener(a);
		jmVMenu.add(jmiSummery);

		JMenuItem jmiAdvising = GUI_ElementCreator.newJMenuItem("Get Advise");
		jmiAdvising.setMnemonic('G');
		jmiAdvising.addActionListener(a);
		jmVMenu.add(jmiAdvising);

		JMenuItem jmiSettings = GUI_ElementCreator.newJMenuItem("Settings");
		jmiSettings.setMnemonic('S');
		jmVMenu.add(jmiSettings);

		JMenuItem jmiLogOuut = GUI_ElementCreator.newJMenuItem("LogOut" );
		jmiLogOuut.addActionListener(a);
		jmiLogOuut.setMnemonic('O');
		jmVMenu.add(jmiLogOuut);

		add(jmVMenu);

		JMenu jmHelp = GUI_ElementCreator.newJMenu("Help" );
		jmHelp.setMnemonic('H');

		JMenuItem jmiAbout = GUI_ElementCreator.newJMenuItem("About");
		jmiAbout.setMnemonic('A');
		jmiAbout.addActionListener(a);
		jmHelp.add(jmiAbout);
		add(jmHelp);


//		JMenu jmLogOuut = GUI_ElementCreator.newJMenu("LogOut" );
//		jmLogOuut.addActionListener(a);
//		jmLogOuut.setMnemonic('L');
//		JMenuItem jmiLogOuut = GUI_ElementCreator.newJMenuItem("LogOut" );
//		jmiLogOuut.addActionListener(a);
//		jmiLogOuut.setMnemonic('O');
//		jmLogOuut.add(jmiLogOuut);
//		add(jmLogOuut);
//		JMenuItem jmiLoginWindow = GUI_ElementCreator.newJMenuItem("Show LogIn Window");
//		jmiLoginWindow.addActionListener(a);
//		jmView.add(jmiLoginWindow);
//		JMenuItem jmiSignInWindow = GUI_ElementCreator.newJMenuItem("Show SignIn Window");
//		jmiSignInWindow.addActionListener(a);
//		jmView.add(jmiSignInWindow);

//		JMenu jmWindow = GUI_ElementCreator.newJMenu("GUI Windows Views");
//		jmWindow.setMnemonic('W');
//		JMenuItem jmiShowRecordsWindow = GUI_ElementCreator.newJMenuItem("Show Records Window");
//		jmiShowRecordsWindow.setMnemonic('R');
//		jmiShowRecordsWindow.addActionListener(a);
//		jmWindow.add(new JSeparator());
//		jmWindow.add(jmiShowRecordsWindow);
//		jmView.add(jmWindow);
//		add(jmView);
		
//		JMenu jmSettings = GUI_ElementCreator.newJMenu("Settings");
//		jmSettings.setMnemonic('S');
//		JMenu jmFontSize = GUI_ElementCreator.newJMenu("Adjust Text Size");
//		jmFontSize.setMnemonic('T');
//		jmFontSize.addActionListener(a);
//
//		JMenuItem jmiIncreaseFontSize = GUI_ElementCreator.newJMenuItem("Increse GUI Text Size (+)");
//		jmiIncreaseFontSize.setMnemonic('+');
//		jmiIncreaseFontSize.addActionListener(a);
//		JMenuItem jmiDecreaseFontSize = GUI_ElementCreator.newJMenuItem("Decrese GUI Text Size (-)");
//		jmiDecreaseFontSize.setMnemonic('-');
//		jmiDecreaseFontSize.addActionListener(a);
//		jmFontSize.add(jmiIncreaseFontSize);
//		jmFontSize.add(jmiDecreaseFontSize);
//		jmSettings.add(jmFontSize);
//		add(jmSettings);


//		JMenu jmHelp = GUI_ElementCreator.newJMenu("Help" );
//		jmHelp.setMnemonic('H');
//		JMenuItem jmiUse = GUI_ElementCreator.newJMenuItem("How To Start");
//		jmiUse.setMnemonic('S');
//		jmiUse.addActionListener(a);
//		jmHelp.add(jmiUse);
//		jmHelp.add(new JSeparator());
//		JMenuItem jmiAbout = GUI_ElementCreator.newJMenuItem("About");
//		jmiAbout.setMnemonic('A');
//		jmiAbout.addActionListener(a);
//		jmHelp.add(jmiAbout);

//		add(jmHelp);
//		JMenu jmLogOuut = GUI_ElementCreator.newJMenu("LogOut" );
//		jmLogOuut.addActionListener(a);
//		jmLogOuut.setMnemonic('L');
//		JMenuItem jmiLogOuut = GUI_ElementCreator.newJMenuItem("LogOut" );
//		jmiLogOuut.addActionListener(a);
//		jmiLogOuut.setMnemonic('O');


//		jmLogOuut.add(jmiLogOuut);

//		add(jmVMenu);
	}
	public GUI_Menu(Component mainGUIWindow) {
		this();
		a.setMainGUIComponent(mainGUIWindow);
	}
}
