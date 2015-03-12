import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class Controller implements MouseListener
{
	Model model;

	Controller(Model m) {
		this.model = m;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			this.model.setDestination(e.getX());
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			if (model.jump == false) {
				model.jump = true;		
			}
			else {
				model.flying = true;
			}
		
		}

	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }

}
