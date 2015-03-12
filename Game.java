import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.io.IOException;

public class Game extends JFrame implements ActionListener {
	Model model;

	public Game() throws IOException, Exception {
		this.model = new Model();
		Controller controller = new Controller(this.model);
		View view = new View(this.model);
		view.addMouseListener(controller);
		this.setTitle("Turtle Attack");
		this.setSize(1000, 700);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		new Timer(50, this).start(); // Indirectly calls actionPerformed at regular intervals
	}

	public void actionPerformed(ActionEvent evt) {
		try {
		this.model.update();
		repaint(); // Indirectly calls View.paintComponent
		}
		catch (IOException e) {
			// thanks dad
		}
	}

	public static void main(String[] args) throws IOException, Exception {
		new Game();
	}
}
