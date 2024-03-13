import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	private static final HashMap<String, String> views = new HashMap<String, String>();
	private static final Scene scene = new Scene(App.loadView("book"));

	public static void main(String[] args) {
		App.views.put("book", "models/book/Book");
		App.views.put("author", "models/author/Author");

		App.launch(args);
	};

	@Override
	public void start(Stage stage) {
		stage.setScene(App.scene);
		stage.show();
	}

	public static void setRoot(String view) {
		scene.setRoot(App.loadView(view));
	}

	private static Parent loadView(String view) {
		try {
			return (new FXMLLoader(App.class.getResource(App.views.get(view)))).load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
