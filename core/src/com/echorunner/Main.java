package com.echorunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.echorunner.input.InputHandler;
import com.echorunner.logic.ActionHandler;
import com.echorunner.utils.ActionGroup;

/**
 * Main game class - Entry point for EchoRunner
 */
public class Main extends Game
{
    private enum actionTest implements ActionGroup
    {
        PROUT_MDR_AHAHAH
    }

    @Override
    public void create()
    {
        InputHandler.init();

        // ATTENTION : le clavier est Ici en Qwerty donc A => Q
        // C'est un test de mon implementation des inputs clavier
        InputHandler.registerKeyBind(Input.Keys.A, actionTest.PROUT_MDR_AHAHAH);
        ActionHandler.registerAction(actionTest.PROUT_MDR_AHAHAH, () -> {System.out.println("PROUT AHAHA JSUIS UN ZGEG");});
    }

    @Override
    public void render()
    {
        super.render();
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
