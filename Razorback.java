import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Razorback extends Sprite {
	
	//public static Image image = null;

	public final int w_offset = 101;
	final int h_offset = 45;
	double v_velocity;
	static Image image = null;
	
	Razorback() throws IOException {
		if (this.image == null) {
			this.image = ImageIO.read(new File("razorback.png"));
		}
		this.velocity = 1.0;
		this.v_velocity = 0.0;
		this.pos_x = 0;
		this.pos_y = FLOOR;
		flat = false;
		flat_count = 0;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	void update() {
		try {
		if (this.v_velocity < 0) {
			this.image = ImageIO.read(new File("razorjump.png"));
		}
		else if (this.v_velocity > 0) {
			this.image = ImageIO.read(new File("razorfall.png"));
		}
		else {
			this.image = ImageIO.read(new File("razorback.png"));
		}
		}
		catch (IOException e) {
			// well....
		}
		
		if (this.pos_x < Model.dest_x) {
			this.pos_x += velocity;
			if (this.pos_x > 1000) {
				this.pos_x = 1000 - w_offset;
			}
		}
		else if (this.pos_x > Model.dest_x) {
			this.pos_x -= velocity;
			if (this.pos_x < 0) {
				this.pos_x = 0;
			}
		}
		
		if (Model.jump == true && this.pos_y >= FLOOR) {
			this.v_velocity = -30.0;
			
		}
		
		this.pos_y += this.v_velocity;
		this.v_velocity += GRAVITY;
		
		if (this.pos_y >= FLOOR) {
			v_velocity = 0.0;
			this.pos_y = FLOOR;
			Model.jump = false;
		}
	}
}