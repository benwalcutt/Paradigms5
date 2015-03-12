import java.util.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Model
{
	public ArrayList<Sprite> SL;
	public static int dropcounter;
	public static int dest_x;
	
	public static boolean jump;
	public static boolean flying;
	
	public static Razorback razorback;
	
	Model() throws IOException {
		dropcounter = 0;
		dest_x = 0;
		SL = new ArrayList<Sprite>();
		razorback = new Razorback();
		SL.add(razorback);
		jump = false;
		flying = false;
	}
	

	public void update() throws IOException {
		// keep track of time to drop the turts
		dropcounter++;
		if (dropcounter == 25) {
			SL.add(new Turtle());
			dropcounter = 0;
		}
		
		// if controller said he was flying, that means the button was clicked
		// and they want some pie
		// let them eat their pie
		if (flying == true) {
			SL.add(new Pie());
			// reset the flying flag so that we can throw more pie and also not vomit pie everywhere
			// if you want to see the pig vomit pie, comment this next line out
			flying = false;
		}		
		
		Iterator<Sprite> SLIter = SL.iterator();
		while (SLIter.hasNext()) {
			Sprite current = SLIter.next();
			current.update();
			// bounds testing
			if (current.pos_x < -150 || current.pos_x > 1000 || current.pos_y > 800) {
				SLIter.remove();
			}
			// flat turts
			if (current.flat_count == 50 && current.flat == true) {
				SLIter.remove();
			}
		}
		
	}
	
	public void setDestination(int x) {
		dest_x = x;
	}

}
