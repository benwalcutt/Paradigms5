import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import java.util.Random;


class Turtle extends Sprite {
	// offset of the turtle image used in collision detecting
	// isn't actually used in collision detecting but may be used elsewhere
	final int w_offset = 80;
	final int h_offset = 59;
	

	static Image image = null;
	static Image flatimage = null;
	
	private Random drop_location;
	
	Turtle () throws IOException {
		if (this.image == null) {
			this.image = ImageIO.read(new File("turtle.png"));
			this.flatimage = ImageIO.read(new File("turt_smashed.png"));
		}
			drop_location = new Random(System.currentTimeMillis());
			this.pos_x = drop_location.nextInt(800);
			this.velocity = 0.0;
			this.pos_y = 0;	
			flat = false;
			flat_count = 0;
			
	}
	
	public Image getImage() {
		if (flat == false)
			return this.image;
		else
			return this.flatimage;
	}
	
	void update() {
		// just a counter to keep track of how long to keep the flat turt around
		if (flat == true) {
			flat_count++;			
		}
		// move the turt
		if (this.pos_y < FLOOR) {
			pos_y += velocity;
			velocity += GRAVITY;
		}
		else if (flat == false){
			velocity = 2.0;
			this.pos_x -= velocity;
		}
		
		// collision detection
		if (Model.razorback.pos_x + 101 > this.pos_x && Model.razorback.pos_x < this.pos_x + 80 && Model.razorback.pos_y + 45 > this.pos_y && Model.razorback.pos_y < this.pos_y + 59 && flat == false) {
			// if the pig is jumping, you are flat
			if (Model.razorback.pos_y != FLOOR) {
				flat = true;
			}
			// you reset the pig
			else
				Model.razorback.pos_x = 0;
		}
		
	}
}