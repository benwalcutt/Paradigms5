import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

abstract public class Sprite {
	public static final double GRAVITY = 2.7;
	public static final int FLOOR = 500;
	
	public int pos_x;
	public int pos_y;
	
	double velocity;
	public boolean flat;
	public int flat_count;
	public abstract Image getImage();
	abstract void update();
	
	Sprite() {
		
	}
	
}