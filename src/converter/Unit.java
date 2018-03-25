package converter;

/**
 * An Interface for unit object 
 * 
 * @author Pawan Intawongsa
 *
 */
public interface Unit {
	/**
	 * Convert value of this unit to u
	 * @param amount
	 * 				is value of this Unit
	 * @param u
	 * 			is Unit that we want to convert to
	 * @return calculated value 
	 */
	public double convert(double amount, Unit u);
}
