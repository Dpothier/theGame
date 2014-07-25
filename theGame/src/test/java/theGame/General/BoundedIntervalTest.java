package theGame.General;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoundedIntervalTest {
	
	private final int START_BOUND = 2;
	private final int END_BOUND = 5;
	private final int AN_OUT_OF_BOUND_START = 1;
	private final int AN_INBOUND_START = 3;
	private final int AN_OUT_OF_BOUND_END = 6;
	private final int AN_INBOUND_END = 4;
	private final int A_CORRECT_MOVE = 0;
	private final int AN_INCORRECT_MOVE = 100;
	
	private Interval interval;
	
	@Mock
	private Interval bound;
	
	@Before
	public void setUp(){
		when(bound.getStartPoint()).thenReturn(START_BOUND);
		when(bound.getEndPoint()).thenReturn(END_BOUND);
		interval = new BoundedInterval(bound, AN_INBOUND_START, AN_INBOUND_END);
	}
	
	@Test
	public void if_both_start_and_end_are_inbound_creation_works(){
		new BoundedInterval(bound, AN_INBOUND_START, AN_INBOUND_END);
	}
	
	@Test(expected = RuntimeException.class)
	public void if_start_is_outbound_exception_is_thrown(){
		new BoundedInterval(bound, AN_OUT_OF_BOUND_START, AN_INBOUND_END);
	}
	
	@Test(expected = RuntimeException.class)
	public void if_end_is_outbound_exception_is_thrown(){
		new BoundedInterval(bound, AN_INBOUND_END, AN_OUT_OF_BOUND_END);
	}
	
	@Test(expected = RuntimeException.class)
	public void if_both_are_outbound_exception_is_thrown(){
		new BoundedInterval(bound, AN_OUT_OF_BOUND_START, AN_OUT_OF_BOUND_END);
	}
	
	@Test
	public void incorrect_move_returns_same_interval(){
		Interval returned = interval.move(AN_INCORRECT_MOVE);
		
		Assert.assertSame(returned, interval);
	}
	
	@Test
	public void correct_move_returns_new_interval(){
		Interval returned = interval.move(A_CORRECT_MOVE);
		
		Assert.assertNotSame(returned, interval);
		Assert.assertEquals(AN_INBOUND_START + A_CORRECT_MOVE, returned.getStartPoint());
		Assert.assertEquals(AN_INBOUND_END + A_CORRECT_MOVE, returned.getEndPoint());
	}

}
