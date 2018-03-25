package converter;

/**
 * Collect a area of unit in square meter ratio.
 * 
 * @author Pawan Intawongsa
 *
 */
public enum Area implements Unit {
	SquareMile(1609.344 * 1609.344), SquareCentimeter(0.0100 * 0.100), SquareFoot(0.30480 * 0.30480), SquareWa(
			2.0000 * 2.0000), SquareKilometer(1000.0 * 1000.0), SaquareMeter(1.0);

	/** value of unit */
	private final double value;

	/**
	 * Initialize Length.
	 * 
	 * @param value
	 *            of Area unit.
	 */
	private Area(double value) {
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
		Area unit = (Area) u;
		amount = (unit.getValue() / this.getValue()) * amount;
		return amount;
	}

}
