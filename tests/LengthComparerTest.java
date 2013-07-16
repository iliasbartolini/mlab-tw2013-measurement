import static org.junit.Assert.*;

import org.junit.Test;


public class LengthComparerTest {

	@Test
	public void compares_inches_and_ft(){
		LengthComparator comparer = new LengthComparator();
		Length inches12 = new Length(12.0, LengthUnit.IN);
		Length ft1 = new Length(1.0, LengthUnit.FT);
		
		int compareResult = comparer.compare(inches12, ft1);
		
		assertEquals(0, compareResult);
	}
	
	@Test
	public void compares_inches_and_ft_when_inches_is_greater(){
		LengthComparator comparer = new LengthComparator();
		Length inches10 = new Length(10.0, LengthUnit.IN);
		Length ft1 = new Length(1.0, LengthUnit.FT);
		
		int compareResult = comparer.compare(inches10, ft1);
		
		assertEquals(-1, compareResult);
	}

	
	@Test
	public void compares_ft_and_yd(){
		LengthComparator comparer = new LengthComparator();
		Length yd1 = new Length(1.0, LengthUnit.YD);
		Length ft4 = new Length(4.0, LengthUnit.FT);
		
		int compareResult = comparer.compare(ft4, yd1);
		
		assertEquals(1, compareResult);
	}

	@Test
	public void sums_ft_and_yd(){
		Length yd1 = new Length(1.0, LengthUnit.YD);
		Length ft4 = new Length(4.0, LengthUnit.FT);
		
		Length compareResult = ft4.sum(yd1);
		double convertTo = compareResult.convertTo(LengthUnit.IN);

		assertEquals(84, convertTo, 0.01);
	}
}
