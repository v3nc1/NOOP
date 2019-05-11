import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel implements MozePisatiPoSebi{

	JTextArea textArea = new JTextArea(10, 10);

	TextPanel() {
		this.setLayout(new BorderLayout());
		this.add(textArea,BorderLayout.CENTER);
	}

	@Override
	public void primiObjektIPisi(FormEvent fe) {
		// TODO Auto-generated method stub
		textArea.append(fe.vessel.toString());
		
	}

}
