package converter;

/**
 * Collect a length of unit in meter ratio.
 * 
 * @author Pawan Intawongsa
 *
 */
public enum Length {

	Mile(1609.344), Centimeter(0.0100), Foot(0.30480), Wa(2.0000), AU(1495978707e2), Kilometer(1000.0), Meter(1.0);
	/** value of unit*/
	private final double value;

	/**
	 * Initialize Length.
	 * 
	 * @param value
	 *            of Length unit.
	 */
	private Length(double value) {
		this.value = value;
	}

	/**
	 * Return value of unit
	 * @return value of unit
	 */
	public double getValue() {
		return this.value;
	}
}
