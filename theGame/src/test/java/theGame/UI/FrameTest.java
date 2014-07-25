package theGame.UI;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import mapGeneration.display.TileDrawer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.General.Interval;

@RunWith(MockitoJUnitRunner.class)
public class FrameTest {
	private final int FRAME_WIDTH = 640;
	private final int FRAME_HEIGTH = 480;
	
	private Interval width;
	private Interval heigth;
	
	@Mock
	private Map map;
	@Mock
	private Map framedMap;
	@Mock
	private TileDrawer tileDrawer;
	
	private Frame frame;
	
	@Before
	public void SetUp(){
		width = new Interval(0, FRAME_WIDTH);
		heigth = new Interval(0, FRAME_HEIGTH);
		frame = new Frame(map, width, heigth);
	}
	
	@Test
	public void display_draws_all_tiles_contained_in_frame(){
		when(map.getSubmap(width, heigth)).thenReturn(framedMap);
		
		frame.display();
		
		verify(framedMap).draw();
	}

}
