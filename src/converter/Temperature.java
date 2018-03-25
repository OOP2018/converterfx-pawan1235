package converter;

/**
 * Collect Unit of temperature
 * 
 * @author Pawan Intawongsa
 *
 */
public enum Temperature implements Unit {

	Celsius(1), Kevin(273.15), Fahrenheit(33.8);

	/** value of unit */
	private final double value;

	/**
	 * Initialize Length.
	 * 
	 * @param value
	 *            of Temperature unit.
	 */
	private Temperature(double value) {
		this.value = value;
	}

	/**
	 * Return value of unit
	 * 
	 * @return value of unit
	 */
	public double getValue() {
		return this.value;
	}

	@Override
	public double convert(double amount, Unit u) {
		Temperature unit = (Temperature) u;
		if (this.equals(Celsius)) {
			amount = changeCel(amount, unit);
		}
		if (this.equals(Fahrenheit)) {
			amount = changeFah(amount, unit);
		}
		if (this.equals(Kevin)) {
			amount = changeKev(amount, unit);
		}
		return amount;
	}

	/**
	 * Calculate celsius to fahrenheit and kevin
	 * 
	 * @param value
	 *            is value in celsius
	 * @param u
	 *            is Unit we want to convert to
	 * @return calculated value
	 */
	private double changeCel(double value, Unit u) {
		Temperature unit = (Temperature) u;
		if (unit.equals(Fahrenheit)) {
			value = (value - 32) * (0.5555);
		} else if (unit.equals(Kevin)) {
			value -= Kevin.value;
		}
		return value;
	}

	/**
	 * Calculate fahrenheit to celcius and kevin.
	 * 
	 * @param value
	 *            is value in fahrenheit
	 * @param u
	 *            is Unit we want to convert to
	 * @return calculated value
	 */
	private double changeFah(double value, Unit u) {
		Temperature unit = (Temperature) u;
		if (unit.equals(Celsius)) {
			value = (1.8 * value) + 32;
		} else if (unit.equals(Kevin)) {
			value = value * 1.8 - 459.67;

		}
		return value;
	}

	/**
	 * Calculate kevin to celcius and fahrenheit.
	 * 
	 * @param value
	 *            is value in kevin
	 * @param u
	 *            is Unit we want to convert to
	 * @return calculated value
	 */
	private double changeKev(double value, Unit u) {
		Temperature unit = (Temperature) u;
		if (unit.equals(Celsius)) {
			value += Kevin.value;
		} else if (unit.equals(Fahrenheit)) {
			value = (value + 459.67) / (1.8);
		}
		return value;
	}
}
