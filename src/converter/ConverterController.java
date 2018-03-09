package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * UI controller for events and initializing components.
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	private ComboBox<Length> unitbox1;
	@FXML
	private ComboBox<Length> unitbox2;


	@FXML
	public void handleConvert(ActionEvent event) {
		double value = 0;
		try {
			Length f = unitbox1.getValue();
			Length s = unitbox2.getValue();
			if(!textfield1.getText().isEmpty()) {
				value = Double.parseDouble(textfield1.getText());
				textfield2.setText(String.format("%.4g", (f.getValue() / s.getValue()) * value));
			}
			else {
				value = Double.parseDouble(textfield2.getText());
				textfield1.setText(String.format("%.4g", (s.getValue() / f.getValue()) * value));
			}

		} catch (Exception e) {
			textfield1.setText("Invalid value");
			textfield2.setText("Invalid value");
		}
	}

	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates the
	 * UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		if (unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1); // select an item to show
		}
	}
}
