package converter;

import java.util.Arrays;
import java.util.List;

/**
 * A Unit factory. Use for get all of Unit type.
 * @author Pawan Intawongsa
 *
 */
public class UnitFactory {
	
	private static UnitFactory factory = null;
	
	/**
	 * Return instance of UnitFactory
	 * @return instance of UnitFactory
	 */
	public static UnitFactory getInstance() {
		if(factory == null) {
			factory = new UnitFactory();
		}
		return factory;
	}
	
	/** Get the names of the types of units that the factory knows about. */
	public String[] getUnitTypes() {
		String[] units = { "Length", "Area", "Temperature", "Weight" };
		return units;
	}

	/** Get all the units of one type, such as Volume. */
	public Unit[] getUnits(String unitType) {
		List<Unit> tempUnits = null;
		if (unitType.equals("Length")) {
			tempUnits = Arrays.asList(Length.values());
		}
		if (unitType.equals("Area")) {
			tempUnits = Arrays.asList(Area.values());
		}
		if (unitType.equals("Temperature")) {
			tempUnits = Arrays.asList(Temperature.values());
		}
		if (unitType.equals("Weight")) {
			tempUnits = Arrays.asList(Weight.values());
		}
		Unit[] units = new Unit[tempUnits.size()];
		tempUnits.toArray(units);
		return units;
	}
}
