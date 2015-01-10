/*package theGame.UI.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import mapGeneration.display.TileDrawer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.General.Interval;
import theGame.General.Rectangle;
import theGame.UI.Map.Map;

@RunWith(MockitoJUnitRunner.class)
public class FrameTest {
	@Mock
	private Tile tile1,tile2,tile3,
				 tile4,tile5,tile6,
				 tile7,tile8,tile9;
	private Tile[][] tiles;
	
	@Mock
	private Interval width;
	@Mock
	private Interval heigth;
	@Mock
	private Rectangle position;
	
	@Mock
	private Map map;
	@Mock
	private Map framedMap;
	@Mock
	private TileDrawer tileDrawer;
	
	@Mock
	private Zoom zoom;
	
	private Frame frame;
	
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
		
		frame = new Frame(position, zoom,0,0);
	}
	
	@Test
	public void when_frame_is_on_top_left_correct_tiles_are_returned(){
		when(width.getStartPoint()).thenReturn(0);
		when(width.length()).thenReturn(1);
		when(heigth.getStartPoint()).thenReturn(0);
		when(heigth.length()).thenReturn(1);
		
		Tile[][] returnedTiles = frame.tilesInFrame(tiles);
		
		assertSize(returnedTiles ,2 ,2);
		Assert.assertSame(tile1, returnedTiles[0][0]);
		Assert.assertSame(tile2, returnedTiles[1][0]);
		Assert.assertSame(tile4, returnedTiles[0][1]);
		Assert.assertSame(tile5, returnedTiles[1][1]);
		
	}
	
	@Test
	public void when_frame_is_on_bottom_rigth_correct_tiles_are_returned(){
		when(width.getStartPoint()).thenReturn(1);
		when(width.length()).thenReturn(1);
		when(heigth.getStartPoint()).thenReturn(1);
		when(heigth.length()).thenReturn(1);
		
		Tile[][] returnedTiles = frame.tilesInFrame(tiles);
		assertSize(returnedTiles, 2, 2);
		Assert.assertSame(tile5, returnedTiles[0][0]);
		Assert.assertSame(tile6, returnedTiles[1][0]);
		Assert.assertSame(tile8, returnedTiles[0][1]);
		Assert.assertSame(tile9, returnedTiles[1][1]);
	}
	
	@Test
	public void when_frame_is_on_topmost_row_correct_tiles_are_returned(){
		when(width.getStartPoint()).thenReturn(0);
		when(width.length()).thenReturn(2);
		when(heigth.getStartPoint()).thenReturn(0);
		when(heigth.length()).thenReturn(0);
		
		Tile[][] returnedTiles = frame.tilesInFrame(tiles);
		assertSize(returnedTiles, 3, 1);
		Assert.assertSame(tile1, returnedTiles[0][0]);
		Assert.assertSame(tile2, returnedTiles[1][0]);
		Assert.assertSame(tile3, returnedTiles[2][0]);
	}
	
	@Test
	public void when_frame_is_on_leftmost_column_tiles_are_returned(){
		when(width.getStartPoint()).thenReturn(0);
		when(width.length()).thenReturn(0);
		when(heigth.getStartPoint()).thenReturn(0);
		when(heigth.length()).thenReturn(2);
		
		Tile[][] returnedTiles = frame.tilesInFrame(tiles);
		assertSize(returnedTiles, 1, 3);
		Assert.assertSame(tile1, returnedTiles[0][0]);
		Assert.assertSame(tile4, returnedTiles[0][1]);
		Assert.assertSame(tile7, returnedTiles[0][2]);
	}
	
	@Test
	public void when_frame_moves_both_dimmension_moves(){
		frame.move(1, 2);
		
		verify(width).move(1);
		verify(heigth).move(2);
	}
	
	private void assertSize(Tile[][] tiles, int width, int heigth) {
		Assert.assertEquals(width, tiles.length);
		for(int i = 0; i < width; i++){
			Assert.assertEquals(heigth, tiles[i].length);
		}
	}

}
*/
