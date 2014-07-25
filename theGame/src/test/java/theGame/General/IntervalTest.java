package theGame.General;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntervalTest {
	
	private final int A_START_POINT = 10;
	private final int A_END_POINT = 25;
	
	@Test(expected = RuntimeException.class)
	public void start_point_cannot_be_greater_than_end_point(){
		new Interval(A_END_POINT, A_START_POINT);
	}
	
	@Test
	public void distance_value_is_difference_between_end_and_start_point(){
		Interval distance = new Interval(A_START_POINT, A_END_POINT);
		
		Assert.assertEquals(A_END_POINT - A_START_POINT, distance.distance());
	}

}
