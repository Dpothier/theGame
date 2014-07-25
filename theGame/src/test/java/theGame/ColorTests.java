package theGame;


import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

public class ColorTests {

	@Test
	public void test() {
		Color hsb = Color.getHSBColor((float)215.0/360, (float)68.0/100, (float)89.0/100);
		Assert.assertEquals(73, hsb.getRed());
		Assert.assertEquals(137, hsb.getGreen());
		Assert.assertEquals(227, hsb.getBlue());
	}

}
