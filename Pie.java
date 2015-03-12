import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Pie extends Sprite {
	
	double v_velocity;
	static Image image = null;
	
	Pie() throws IOException {
		if (this.image == null) {
			this.image = ImageIO.read(new File("pie.png"));
		}
		this.pos_y = Model.razorback.pos_y;
		this.pos_x = Model.razorback.pos_x + Model.razorback.w_offset;
		this.v_velocity = -14.0;
		this.velocity = 14.0;
		flat = false;
		flat_count = 0;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	void update() {
		if (this.pos_y < FLOOR) {
			this.pos_y += v_velocity;
			this.v_velocity += GRAVITY;
			this.pos_x += velocity;
		}
		else {
			this.pos_y = FLOOR;
			this.v_velocity = 0.0;
		}
		
		
		
	}
}