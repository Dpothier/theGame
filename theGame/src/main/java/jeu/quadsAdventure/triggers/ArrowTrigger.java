package jeu.quadsAdventure.triggers;

import jeu.quadsAdventure.gameService.*;

import org.lwjgl.input.*;

import theGame.engine.input.*;
import theGame.engine.input.event.*;

public class ArrowTrigger implements EventBasedTrigger {

    private MoveQuadService moveService;
    private int speed;

    public ArrowTrigger(MoveQuadService moveService, int speed) {
        this.moveService = moveService;
        this.speed = speed;
    }

    @Override
    public void reactToEvent(Event event) {
        if (event.peripheral == Peripheral.Keyboard) {
            reactToKeyDown(event);
            reactToKeyUp(event);
            reactToKeyLeft(event);
            reactToKeyRigth(event);
        }

    }

    private void reactToKeyDown(Event event) {
        if (event.button == Keyboard.KEY_DOWN) {
            if (buttonIsPressed(event)) {
                moveService.setQuadSpeed(0, -speed);
            } else {
                moveService.stop();
            }
        }
    }

    private void reactToKeyUp(Event event) {
        if (event.button == Keyboard.KEY_UP) {
            if (buttonIsPressed(event)) {
                moveService.setQuadSpeed(0, speed);

            } else {
                moveService.stop();
            }
        }
    }

    private void reactToKeyLeft(Event event) {
        if (event.button == Keyboard.KEY_LEFT) {
            if (buttonIsPressed(event)) {
                moveService.setQuadSpeed(-speed, 0);

            } else {
                moveService.stop();
            }
        }
    }

    private void reactToKeyRigth(Event event) {
        if (event.button == Keyboard.KEY_RIGHT) {
            if (buttonIsPressed(event)) {
                moveService.setQuadSpeed(speed, 0);
            } else {
                moveService.stop();
            }
        }
    }

    private boolean buttonIsPressed(Event event) {
        return event.buttonIsPressed;
    }
}
