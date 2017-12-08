package homework7;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class _14211278_Âú¿ÂÓî_7_DialogUI {
	private static _14211278_Âú¿ÂÓî_7_DialogUI instance = new _14211278_Âú¿ÂÓî_7_DialogUI();
	private Stage primaryStage;
	
	private _14211278_Âú¿ÂÓî_7_DialogUI() {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("_14211278_Âú¿ÂÓî_7_dialog.fxml"));
			Scene scene = new Scene(root);
	        primaryStage = new Stage();
	        primaryStage.initModality(Modality.APPLICATION_MODAL);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("´íÎó");
	        primaryStage.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static _14211278_Âú¿ÂÓî_7_DialogUI getInstance() {
		return instance;
	}
	
	public Stage getStage() {
		return primaryStage;
	}
	
}
