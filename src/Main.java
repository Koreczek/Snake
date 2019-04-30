import view.View;
import model.Model;
import controller.Controller;
public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model);
		view.addKeyListener(controller);
		
		while(true) {
			model.move();
			view.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
