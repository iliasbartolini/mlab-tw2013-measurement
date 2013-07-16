import java.util.Comparator;


public class LengthComparator implements Comparator<Length> {

	@Override
	public 	int compare(Length lengthA, Length lengthB) {
		double baseLengthA = lengthA.toBaseUnit();
		double baseLengthB = lengthB.toBaseUnit();
		
		return Double.compare(baseLengthA, baseLengthB);
	}	

}
