package com.echorunner.logic;

import java.util.HashMap;

import com.echorunner.utils.ActionGroup;

public class ActionHandler
{
    private static final HashMap<ActionGroup, Runnable> actions = new HashMap<ActionGroup, Runnable>();    

    public static void registerAction(ActionGroup action, Runnable lambda)
    {
        if ( action == null || lambda == null ) { return; }
        if ( ActionHandler.actions.containsKey(action) ) { removeAction(action); } // On remplace (jsp)

        ActionHandler.actions.put(action, lambda);
    }

    public static void removeAction(ActionGroup action)
    {
        if ( action == null || !ActionHandler.actions.containsKey(action) ) { return; }

        ActionHandler.actions.remove(action);
    }

    public static void runAction(ActionGroup action)
    {
        if ( action == null ) { return; }
        Runnable lambda = ActionHandler.actions.get(action);
        if ( lambda == null ) { return; }
        lambda.run();
    }
}
