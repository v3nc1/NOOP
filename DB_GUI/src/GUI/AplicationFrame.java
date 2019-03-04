package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controler.Controler;

public class AplicationFrame extends JFrame {
	
	private DataForm dataForm;
	private ViewDataPanel txtView;
	private Controler ctrl;
	private TablePanel tablePanel;
	
	
	public AplicationFrame() {
	
		setLayout(new BorderLayout());
		setSize(700, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		runCreate();
		runLayout();
		activateAll();
		
	}
	
	private void activateAll() {
		
		dataForm.setFormDataListener(new FormDataListener() {
			
			@Override
			public void dataFormEventOccured(FormDataObject fdo) {
				
				String name=fdo.getName();
				String mail=fdo.getMail();
				String employment=fdo.getEmployment();
				String education=fdo.getEducation();
				String region=fdo.getRegion();
				
				String all= name + " - " + mail + " - " + employment + " - " + education + " - " + region;
				
				txtView.showFormData(all);
				ctrl.addUser(fdo);
				tablePanel.refresh();
			}
		});
	}

	private void runCreate() {
		
		dataForm=new DataForm();
		txtView=new ViewDataPanel();
		ctrl=new Controler();
		tablePanel=new TablePanel();
		
		tablePanel.inputDataBase(ctrl.getDataBase());
	}
	
	private void runLayout() {
		
		add(dataForm,BorderLayout.SOUTH);
		add(txtView,BorderLayout.WEST);
		add(tablePanel,BorderLayout.EAST);
	}
	
	
}
