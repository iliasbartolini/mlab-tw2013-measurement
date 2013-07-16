
public class Length {

	private static final double IN_TO_CM = 2.54;
	private static final double FT_TO_CM = 12.0 * 2.54;
	private static final double YD_TO_CM = 3.0 * 12.0 * 2.54;
	
	private final Double value;
	private final LengthUnit unit;

	public Length(Double value, LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}

	public 	Length sum(Length lengthB) {
		double baseLengthA = toBaseUnit();
		double baseLengthB = lengthB.toBaseUnit();
		
		return new Length(baseLengthA + baseLengthB, LengthUnit.CM);
	}
	
	public double toBaseUnit() {
        switch (this.unit) {
        	case CM: 
        		return value ;
            case IN: 
            	return value * IN_TO_CM;
            case FT: 
            	return value * FT_TO_CM;
            case YD: 
            	return value * YD_TO_CM;
            default:
            	throw new RuntimeException("Length Unit not supported");
        }
	}

	public double convertTo(LengthUnit unit) {
		double valueInBaseUnit = toBaseUnit();
		
        switch (unit) {
        case CM: 
        	return valueInBaseUnit ;
        case IN: 
        	return valueInBaseUnit / IN_TO_CM;
        case FT: 
        	return valueInBaseUnit / FT_TO_CM;
        case YD: 
        	return valueInBaseUnit / YD_TO_CM;
        default:
        	throw new RuntimeException("Length Unit not supported");
        }
    }


}
