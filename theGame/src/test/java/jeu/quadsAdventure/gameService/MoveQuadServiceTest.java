package jeu.quadsAdventure.gameService;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.runners.*;

@RunWith(MockitoJUnitRunner.class)
public class MoveQuadServiceTest {
    private static final int AN_X_SPEED = 5;
    private static final int AN_Y_SPEED = 6;
    private static final int AN_INITIAL_X = 2;
    private static final int AN_INITIAL_Y = 80;

    private Position position;
    MoveQuadService moveQuadService;

    @Before
    public void setUp() {
        position = new Position(AN_INITIAL_X, AN_INITIAL_Y);
        moveQuadService = new MoveQuadService(position);
    }

    @Test
    public void if_speed_is_not_set_quad_does_not_move() {
        moveQuadService.move();

        Position newPoint = moveQuadService.getCoordinates();
        Assert.assertEquals(newPoint.getX(), AN_INITIAL_X);
        Assert.assertEquals(newPoint.getY(), AN_INITIAL_Y);
    }

    @Test
    public void when_speed_is_set_quad_moves_at_that_speed() {
        moveQuadService.setQuadSpeed(AN_X_SPEED, AN_Y_SPEED);
        moveQuadService.move();
        Position newPoint = moveQuadService.getCoordinates();

        Assert.assertEquals(newPoint.getX(), AN_INITIAL_X + AN_X_SPEED);
        Assert.assertEquals(newPoint.getY(), AN_INITIAL_Y + AN_Y_SPEED);
    }

    @Test
    public void when_speed_is_set_it_remains_set_for_multiple_move() {
        moveQuadService.setQuadSpeed(AN_X_SPEED, AN_Y_SPEED);
        moveQuadService.move();
        moveQuadService.move();
        Position newPoint = moveQuadService.getCoordinates();

        Assert.assertEquals(newPoint.getX(), AN_INITIAL_X + AN_X_SPEED * 2);
        Assert.assertEquals(newPoint.getY(), AN_INITIAL_Y + AN_Y_SPEED * 2);
    }

    @Test
    public void stop_resets_speed_to_0() {
        moveQuadService.setQuadSpeed(AN_X_SPEED, AN_Y_SPEED);
        moveQuadService.stop();
        moveQuadService.move();
        Position newPoint = moveQuadService.getCoordinates();

        Assert.assertEquals(newPoint.getX(), AN_INITIAL_X);
        Assert.assertEquals(newPoint.getY(), AN_INITIAL_Y);
    }

}
