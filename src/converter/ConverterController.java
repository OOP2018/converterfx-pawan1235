package converter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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
	private ComboBox<Unit> unitbox1;
	@FXML
	private ComboBox<Unit> unitbox2;
	@FXML
	private Menu UnitTypeMenu;

	/**
	 * Convert unit form unitbox1 to unitbox2.
	 * 
	 * @param event
	 *            is when user hit enter or press convert
	 */
	@FXML
	public void handleConvert(ActionEvent event) {
		double value = 0;
		try {
			Unit f = unitbox1.getValue();
			Unit s = unitbox2.getValue();
			textfield1.setStyle("-fx-text-fill: black");
			textfield2.setStyle("-fx-text-fill: black");
			if (textfield2.isFocused()) {
				value = Double.parseDouble(textfield2.getText());
				double newValue = f.convert(value, s);
				textfield1.setText(String.format("%.4g", newValue));
			} else {
				value = Double.parseDouble(textfield1.getText());
				double newValue = s.convert(value, f);
				textfield2.setText(String.format("%.4g", newValue));
			}

		} catch (Exception e) {
			textfield1.setStyle("-fx-text-fill: red");
			textfield2.setStyle("-fx-text-fill: red");
			textfield1.setText("Invalid value");
			textfield2.setText("Invalid value");
		}
	}

	/**
	 * Clear textfield1 and textfield2
	 * 
	 * @param event
	 *            is after user press clear button
	 */
	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
	}

	/** Event handler for selecting a unittype using a menu item. */
	public void handleUnitSelected(ActionEvent event) {

		MenuItem mitem = (MenuItem) event.getSource();
		String unitname = mitem.getText();
		Unit[] units = UnitFactory.getInstance().getUnits(unitname);
		unitbox1.getSelectionModel().clearSelection();
		unitbox1.getItems().clear();
		unitbox2.getSelectionModel().clearSelection();
		unitbox2.getItems().clear();
		
		if (unitbox1 != null) {
			unitbox1.getItems().addAll(units);
			unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(units);
			unitbox2.getSelectionModel().select(1); // select an item to show
		}
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
		UnitType[] unitType = UnitType.values();
		for (UnitType unit : unitType) {
			MenuItem unitItem = new MenuItem(unit.toString());
			unitItem.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					handleUnitSelected(event);
				}
			});
			UnitTypeMenu.getItems().add(unitItem);
		}
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		UnitTypeMenu.getItems().addAll(new SeparatorMenuItem(),exit);
	}

}
