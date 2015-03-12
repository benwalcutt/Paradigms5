import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;


class Turtle extends Sprite {
	final int w_offset = 80;
	final int h_offset = 59;
	
	//public static Image image;
	static Image image = null;
	static Image flatimage = null;
	
	Turtle () throws IOException {
		if (this.image == null) {
			this.image = ImageIO.read(new File("turtle.png"));
			this.flatimage = ImageIO.read(new File("turt_smashed.png"));
		}
		
			this.pos_x = 550;
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
		if (flat == true) {
			flat_count++;			
		}
		if (this.pos_y < FLOOR) {
			pos_y += velocity;
			velocity += GRAVITY;
		}
		else if (flat == false){
			velocity = 2.0;
			this.pos_x -= velocity;
		}
		
		if (Model.razorback.pos_x + 101 > this.pos_x && Model.razorback.pos_x < this.pos_x + 80 && Model.razorback.pos_y + 45 > this.pos_y && Model.razorback.pos_y < this.pos_y + 59 && flat == false) {
			if (Model.razorback.pos_y != FLOOR) {
				flat = true;
			}
			else
				Model.razorback.pos_x = 0;
		}
		
	}
}