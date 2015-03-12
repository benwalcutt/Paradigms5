import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import java.util.*;

class View extends JPanel {
	Model model;
	Image turtle_image;
	Image razor_image;
	Image pie_image;

	View(Model m) throws IOException {
		this.model = m;
	}

	public void paintComponent(Graphics g) {
		Iterator<Sprite> SLI = model.SL.iterator();
		while (SLI.hasNext()) {
			Sprite current = SLI.next();
			// drawsies
			g.drawImage(current.getImage(), current.pos_x, current.pos_y, null);
		}
	}
}
