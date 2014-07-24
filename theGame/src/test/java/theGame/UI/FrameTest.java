package theGame.UI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import mapGeneration.display.TileDrawer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FrameTest {
	private final int FRAME_WIDTH = 640;
	private final int FRAME_HEIGTH = 480;
	
	@Mock
	private TileGroup map;
	@Mock
	private TileGroup framedMap;
	@Mock
	private TileDrawer tileDrawer;
	
	private Frame frame;
	
	@Before
	public void SetUp(){
		frame = new Frame(map, tileDrawer, FRAME_WIDTH, FRAME_HEIGTH);
		
	}
	
	@Test
	public void display_draws_all_tiles_contained_in_frame(){
		when(map.getSubgroup(0, 0, FRAME_WIDTH, FRAME_HEIGTH)).thenReturn(framedMap);
		
		frame.display();
		
		verify(framedMap).draw(tileDrawer);
	}

}
