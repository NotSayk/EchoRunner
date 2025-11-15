package com.echorunner.input;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.echorunner.logic.ActionHandler;
import com.echorunner.utils.ActionGroup;

/**
 * Handles player input
 */
public class InputHandler
{
	// Input.Keys, Objects (Enum) implements ActionGroup
	private static final Map<Integer, ActionGroup> keybindings = new HashMap<Integer, ActionGroup>();

	private static final InputMultiplexer multiplexer = new InputMultiplexer();
	private static final KeyboardInputHandler keyboardHandler = new KeyboardInputHandler();

	public static void init()
	{
		InputHandler.multiplexer.addProcessor(InputHandler.keyboardHandler);
		Gdx.input.setInputProcessor(InputHandler.multiplexer);
	}

	public static void registerKeyBind(Integer key, ActionGroup action)
	{
		if ( key == null || action == null ) { return; }
		if ( InputHandler.keybindings.containsKey(key) ) { InputHandler.removeKeyBind(key); }
		
		InputHandler.keybindings.put(key, action);
	}

	public static void removeKeyBind(Integer key)
	{
		InputHandler.keybindings.remove(key);
	}

	public static final ActionGroup getAction(Integer keybind)
	{
		return InputHandler.keybindings.get(keybind);
	}

	/*-------------------*/
	/* Keyboard Handling */
	/*-------------------*/

	private static class KeyboardInputHandler implements InputProcessor
	{
		public boolean keyDown(int keycode)
		{
			ActionHandler.runAction(InputHandler.getAction(keycode));
			return true;
		}

		public boolean keyUp(int keycode)
		{
			return false;
		}

		public boolean keyTyped(char character)
		{
			return false;
		}

		public boolean touchDown(int screenX, int screenY, int pointer, int button)
		{
			return false;
		}

		public boolean touchUp(int screenX, int screenY, int pointer, int button)
		{
			return false;
		}

		public boolean touchCancelled(int screenX, int screenY, int pointer, int button)
		{
			return false;
		}

		public boolean touchDragged(int screenX, int screenY, int pointer)
		{
			return false;
		}

		public boolean mouseMoved(int screenX, int screenY)
		{
			return false;
		}

		public boolean scrolled(float amountX, float amountY)
		{
			return false;
		}
	}

	/*---------------------*/
	/* Controller Handling */
	/*---------------------*/

	private static class ControllerInputHandler implements ControllerListener
	{
		public void connected(Controller controller)
		{

		}

		public void disconnected(Controller controller)
		{

		}

		public boolean buttonDown(Controller controller, int buttonCode)
		{
			return false;
		}

		public boolean buttonUp(Controller controller, int buttonCode)
		{
			return false;
		}

		public boolean axisMoved(Controller controller, int axisCode, float value)
		{
			return false;
		}
	}
}
