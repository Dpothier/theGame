package theGame.UI;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ZoomTest {
	private static final int INITIAL_SIZE = 5;
	private static final int MAXIMUM_SIZE = 10;
	private static final int MINIMUM_SIZE = 2;
	
	Zoom zoom;
	
	@Before
	public void setup(){
		zoom = new Zoom(INITIAL_SIZE, MAXIMUM_SIZE, MINIMUM_SIZE);
	}
	
	@Test
	public void GetSize_Returns_Initial_Size(){
		Assert.assertEquals(INITIAL_SIZE, zoom.getSize());
	}
	
	@Test
	public void After_Zoom_TileSize_Is_Larger_By_One(){
		zoom.zoom();
		
		Assert.assertEquals(INITIAL_SIZE + 1, zoom.getSize());
	}
	
	@Test
	public void After_Unzoom_TileSize_Is_Smaller_By_One(){
		zoom.unzoom();
		
		Assert.assertEquals(INITIAL_SIZE - 1, zoom.getSize());
	}
	
	@Test
	public void If_Zooming_Would_Make_Size_Bigger_Than_Maximum_Size_Then_Zooming_Does_Nothing(){
		zoom = new Zoom(MAXIMUM_SIZE, MAXIMUM_SIZE, MINIMUM_SIZE);
		zoom.zoom();
		Assert.assertEquals(MAXIMUM_SIZE, zoom.getSize());
	}
	
	@Test
	public void If_Unzooming_Would_Make_Size_Smaller_Than_Minimum_Size_Then_Zooming_Does_Nothing(){
		zoom = new Zoom(MINIMUM_SIZE, MAXIMUM_SIZE, MINIMUM_SIZE);
		zoom.unzoom();
		Assert.assertEquals(MINIMUM_SIZE, zoom.getSize());
	}

}
