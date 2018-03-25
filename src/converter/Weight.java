package converter;

public enum Weight implements Unit {

	Kilogram(1), Gram(0.001), Ton(1000), Milligram(1000000), Pound(0.45359237);

	/** value of unit */
	private final double value;

	/**
	 * Initialize Length.
	 * 
	 * @param value
	 *            of Temperature unit.
	 */
	private Weight(double value) {
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
		Weight unit = (Weight) u;
		amount = (unit.getValue()/this.getValue())*amount;
		return amount;
		
	}

}
