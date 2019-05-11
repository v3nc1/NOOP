package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class FormPanel extends JPanel {

	private LeftPanel left;
	private RightPanel right;
	private FormListener formLst;

	public FormPanel() {

		setFormLayout();
		createFormComp();
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.CENTER);

	}

	private void setFormLayout() {

		setLayout(new BorderLayout());
		Dimension dim = getPreferredSize();
		dim.height = 240;
		setPreferredSize(dim);
	}

	private void createFormComp() {

		left = new LeftPanel();
		right = new RightPanel();

	}

	public void setFormListener(FormListener listener) {

		this.formLst = listener;
		left.setLeftFormList(formLst);
		right.setRightFormListener(listener);

	}
	public LeftPanel getLeftPanel() {
		return left;
	}

}