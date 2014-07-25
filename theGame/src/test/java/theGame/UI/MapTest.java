package theGame.UI;

import static org.mockito.Mockito.when;
import mapGeneration.display.TileDrawer;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.General.Interval;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MapTest {
	private static final int A_TILE_SIZE = 2;
	
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
		
		map = new Map(tiles, drawer, frame, A_TILE_SIZE);
	}

	
	@Test
	public void draw_uses_drawer_on_every_tile_in_frame(){
		when(frame.tilesInFrame(tiles)).thenReturn(tiles);
		map.draw();
		
		verify(drawer).drawTile(0, 0, A_TILE_SIZE, tile1);
		verify(drawer).drawTile(1*A_TILE_SIZE, 0*A_TILE_SIZE, A_TILE_SIZE, tile2);
		verify(drawer).drawTile(2*A_TILE_SIZE, 0*A_TILE_SIZE, A_TILE_SIZE, tile3);
		verify(drawer).drawTile(0*A_TILE_SIZE, 1*A_TILE_SIZE, A_TILE_SIZE, tile4);
		verify(drawer).drawTile(1*A_TILE_SIZE, 1*A_TILE_SIZE, A_TILE_SIZE, tile5);
		verify(drawer).drawTile(2*A_TILE_SIZE, 1*A_TILE_SIZE, A_TILE_SIZE, tile6);
		verify(drawer).drawTile(0*A_TILE_SIZE, 2*A_TILE_SIZE, A_TILE_SIZE, tile7);
		verify(drawer).drawTile(1*A_TILE_SIZE, 2*A_TILE_SIZE, A_TILE_SIZE, tile8);
		verify(drawer).drawTile(2*A_TILE_SIZE, 2*A_TILE_SIZE, A_TILE_SIZE, tile9);
	}

}
