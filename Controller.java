import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class Controller implements MouseListener
{
	Model model;

	Controller(Model m) {
		this.model = m;
	}

	// check if mouse is pressed
	public void mousePressed(MouseEvent e) {
		// left mouse
		if (e.getButton() == MouseEvent.BUTTON1) {
			this.model.setDestination(e.getX());
		}
		// right mouse
		else if (e.getButton() == MouseEvent.BUTTON3) {
			// if he isn't already jumping, let him him
			if (model.jump == false) {
				model.jump = true;		
			}
			// else he is flying (just go with it)
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
