import controllers.MainController;

public class App {
	public static void main(String[] args) {
		try {
			MainController.initialize(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
