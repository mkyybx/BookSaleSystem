package homework7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class _14211278_Âú¿ÂÓî_7_DialogUIController implements Initializable{
	@FXML
	Label messageLabel;
	@FXML
	Label detailsLabel;
	private static _14211278_Âú¿ÂÓî_7_DialogUI dui = null;
	private static _14211278_Âú¿ÂÓî_7_DialogUIController instance = null;
	
	public _14211278_Âú¿ÂÓî_7_DialogUIController() {
		if (dui != null)
			dui = _14211278_Âú¿ÂÓî_7_DialogUI.getInstance();
	}
	
	public static void setMessageAndShow(String title, String detail) {
		if (dui == null)
			dui = _14211278_Âú¿ÂÓî_7_DialogUI.getInstance();
		instance.messageLabel.setText(title);
		instance.detailsLabel.setText(detail);
		dui.getStage().show();
	}
	
	@FXML
	public void okButtonOnClieck(ActionEvent event) {
		dui.getStage().close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		synchronized (this.getClass()) {
			if (instance == null)
				instance = this;
		}
			
	}
}
