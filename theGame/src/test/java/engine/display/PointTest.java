package engine.display;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PointTest {
	private static final int X_UNDER_TEST = 10;
	private static final int Y_UNDER_TEST = 20;
	private static final int OTHER_X = 30;
	private static final int OTHER_Y = 40;
	
	private Point pointUnderTest, otherPoint;
	
	@Before
	public void setUp(){
		pointUnderTest = new Point(X_UNDER_TEST, Y_UNDER_TEST);
		otherPoint = new Point(OTHER_X, OTHER_Y);
	}
	
	@Test
	public void addReturnNewPointWithAddedXAndY(){
		Point result = pointUnderTest.add(otherPoint);
		
		Assert.assertEquals(X_UNDER_TEST + OTHER_X, result.x);
		Assert.assertEquals(Y_UNDER_TEST + OTHER_Y, result.y);	
	}

}
