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
	public static int dest_y;
	public static boolean jump;
	public static boolean flying;
	
	public static Razorback razorback;
	
	Model() throws IOException {
		dropcounter = 0;
		dest_x = 0;
		dest_y = 0;
		SL = new ArrayList<Sprite>();
		razorback = new Razorback();
		SL.add(razorback);
		jump = false;
		flying = false;
	}
	

	public void update() throws IOException {
		dropcounter++;
		if (dropcounter == 100) {
			SL.add(new Turtle());
			dropcounter = 0;
		}
		
		if (flying == true) {
			SL.add(new Pie());
			flying = false;
		}		
		
		Iterator<Sprite> SLIter = SL.iterator();
		while (SLIter.hasNext()) {
			Sprite current = SLIter.next();
			current.update();
			if (current.pos_x < -150) {
				SLIter.remove();
			}
			if (current.pos_x > 1000) {
				SLIter.remove();
			}
			if (current.flat_count == 100 && current.flat == true) {
				SLIter.remove();
			}
		}
		
	}
	
	public void setDestination(int x) {
		dest_x = x;
	}

}
