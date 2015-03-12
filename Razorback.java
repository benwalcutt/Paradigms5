import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Razorback extends Sprite {

	public final int w_offset = 101;
	final int h_offset = 45;
	double v_velocity;
	static Image image = null;
	static Image jumpimage = null;
	static Image fallimage = null;
	
	Razorback() throws IOException {
		if (this.image == null) {
			this.image = ImageIO.read(new File("razorback.png"));
		}
		if (this.jumpimage == null) {
			this.jumpimage = ImageIO.read(new File("razorjump.png"));
		}
		if (this.fallimage == null) {
			this.fallimage = ImageIO.read(new File("razorfall.png"));
		}
		this.velocity = 5.0;
		this.v_velocity = 0.0;
		this.pos_x = 0;
		this.pos_y = FLOOR;
		flat = false;
		flat_count = 0;
	}
	
	public Image getImage() {
		if (this.v_velocity < 0) {
			return this.jumpimage;
		}
		else if (this.v_velocity > 0) {
			return this.fallimage;
		}
		else {
			return this.image;
		}
	}
	
	void update() {	
		// move the pig
		if (this.pos_x < Model.dest_x) {
			this.pos_x += velocity;
			if (this.pos_x > 1000) {
				this.pos_x = 1000 - w_offset;
			}
			// stop the shaking by assuming we JUST passed the destination so move directly to it
			if (this.pos_x > Model.dest_x) {
				this.pos_x = Model.dest_x;
			}
		}
		else if (this.pos_x > Model.dest_x) {
			this.pos_x -= velocity;
			if (this.pos_x < 0) {
				this.pos_x = 0;
			}
			// same as before, stop the shaking
			if (this.pos_x < Model.dest_x) {
				this.pos_x = Model.dest_x;
			}
		}
		
		// the controller said to jump, and we are on the floor so we jump
		if (Model.jump == true && this.pos_y >= FLOOR) {
			this.v_velocity = -30.0;
			
		}
		
		this.pos_y += this.v_velocity;
		this.v_velocity += GRAVITY;
		
		// we hit the floor, stop jumping
		if (this.pos_y >= FLOOR) {
			v_velocity = 0.0;
			this.pos_y = FLOOR;
			// let the model know we stopped jumping
			Model.jump = false;
		}
	}
}