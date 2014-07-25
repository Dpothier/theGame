package theGame.UI;

import mapGeneration.display.TileDrawer;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.General.Interval;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MapTest {
	
	@Mock
	private Tile tile1,tile2,tile3,
				 tile4,tile5,tile6,
				 tile7,tile8,tile9;
	@Mock
	private TileDrawer drawer;
	@Mock
	private Frame frame;
	
	private Tile[][] tiles;
	private Map map;
	
	@Before
	public void SetUp(){
		tiles = new Tile[3][3];
		tiles[0][0] = tile1;
		tiles[1][0] = tile2;
		tiles[2][0] = tile3;
		tiles[0][1] = tile4;
		tiles[1][1] = tile5;
		tiles[2][1] = tile6;
		tiles[0][2] = tile7;
		tiles[1][2] = tile8;
		tiles[2][2] = tile9;
		
		map = new Map(tiles, drawer, frame);
	}
	
	@Test
	public void askingForTopLeftSubsetReturnsTopLeftSubset(){
		Map returnedMap = map.getSubmap(new Interval(0,1), new Interval(0,1));
		
		assertSize(returnedMap,2 ,2);
		Assert.assertSame(tile1, returnedMap.getTiles()[0][0]);
		Assert.assertSame(tile2, returnedMap.getTiles()[1][0]);
		Assert.assertSame(tile4, returnedMap.getTiles()[0][1]);
		Assert.assertSame(tile5, returnedMap.getTiles()[1][1]);
	}
	
	@Test
	public void askingForBottomRigthSubsetReturnsBottomRigthSubset(){
		Map returnedMap = map.getSubmap(new Interval(1,2), new Interval(1,2));
		assertSize(returnedMap, 2, 2);
		Assert.assertSame(tile5, returnedMap.getTiles()[0][0]);
		Assert.assertSame(tile6, returnedMap.getTiles()[1][0]);
		Assert.assertSame(tile8, returnedMap.getTiles()[0][1]);
		Assert.assertSame(tile9, returnedMap.getTiles()[1][1]);
	}
	
	@Test
	public void askingForARowReturnsRigthSubset(){
		Map returnedMap = map.getSubmap(new Interval(0,2), new Interval(0,0));
		assertSize(returnedMap, 3, 1);
		Assert.assertSame(tile1, returnedMap.getTiles()[0][0]);
		Assert.assertSame(tile2, returnedMap.getTiles()[1][0]);
		Assert.assertSame(tile3, returnedMap.getTiles()[2][0]);
	}
	
	@Test
	public void asking_for_a_column(){
		Map returnedMap = map.getSubmap(new Interval(0,0), new Interval(0,2));
		assertSize(returnedMap, 1, 3);
		Assert.assertSame(tile1, returnedMap.getTiles()[0][0]);
		Assert.assertSame(tile4, returnedMap.getTiles()[0][1]);
		Assert.assertSame(tile7, returnedMap.getTiles()[0][2]);
	}
	
	@Test(expected = SubsetOutOfBoundException.class)
	public void askingForBaseXOutsideMapThrowsException(){
		map.getSubmap(new Interval(4,4), new Interval(0,0));
	}
	
	@Test(expected = SubsetOutOfBoundException.class)
	public void askingForBaseYOutsideMapThrowsException(){
		map.getSubmap(new Interval(0,0), new Interval(4,4));
	}
	
	@Test(expected = SubsetOutOfBoundException.class)
	public void asking_For_Subset_Out_Of_Map_X_Throws_Exception(){
		map.getSubmap(new Interval(0,4), new Interval(0,0));
	}
	
	@Test(expected = SubsetOutOfBoundException.class)
	public void asking_For_Subset_Out_Of_Map_Y_Throws_Exception(){
		map.getSubmap(new Interval(0,0), new Interval(0,4));
	}
	
	@Test
	public void draw_uses_drawer_on_every_tile(){
		map.draw();
		
		verify(drawer).drawTile(0, 0, tile1);
		verify(drawer).drawTile(1, 0, tile2);
		verify(drawer).drawTile(2, 0, tile3);
		verify(drawer).drawTile(0, 1, tile4);
		verify(drawer).drawTile(1, 1, tile5);
		verify(drawer).drawTile(2, 1, tile6);
		verify(drawer).drawTile(0, 2, tile7);
		verify(drawer).drawTile(1, 2, tile8);
		verify(drawer).drawTile(2, 2, tile9);
	}

	
	private void assertSize(Map returnedMap, int width, int heigth) {
		Assert.assertEquals(width, returnedMap.getTiles().length);
		for(int i = 0; i < width; i++){
			Assert.assertEquals(heigth, returnedMap.getTiles()[i].length);
		}
	}

}
