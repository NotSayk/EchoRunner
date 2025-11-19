package com.echorunner.input;

public class InputTuple
{
    public enum InputState
    {
        UP,
        DOWN
    }

    private final int key;
    private final InputState state;

    public InputTuple( int key, InputState state )
    {
        this.key = key;
        this.state = state;
    }

    public int getKey()
    {
        return this.key;
    }
    public InputState getState()
    {
        return this.state;
    }

    public boolean equals(Object obj)
    {
        if ( !(obj instanceof InputTuple) ) { return false; }
        
        InputTuple tuple = (InputTuple)(obj);

        return this.key == tuple.key && this.state == tuple.state;
    }
}
