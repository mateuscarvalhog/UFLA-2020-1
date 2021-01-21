public class Lexico implements Constants
{
    private int position;
    private String input;

    public Lexico()
    {
        this(new java.io.StringReader(""));
    }

    public Lexico(java.io.Reader input)
    {
        setInput(input);
    }

    public void setInput(java.io.Reader input)
    {
        StringBuffer bfr = new StringBuffer();
        try
        {
            int c = input.read();
            while (c != -1)
            {
                bfr.append((char)c);
                c = input.read();
            }
            this.input = bfr.toString();
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }

        setPosition(0);
    }

    public void setPosition(int pos)
    {
        position = pos;
    }

    public Token nextToken() throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput())
        {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2))
            throw new LexicalError(SCANNER_ERROR[lastState], start);

        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken();
        else
        {
            String lexeme = input.substring(start, end);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state)
    {
        switch (state)
        {
            case 0:
                switch (c)
                {
                    case 9: return 1;
                    case 10: return 1;
                    case 13: return 1;
                    case 32: return 1;
                    case 34: return 2;
                    case 40: return 3;
                    case 41: return 4;
                    case 42: return 5;
                    case 43: return 5;
                    case 45: return 5;
                    case 47: return 5;
                    case 48: return 6;
                    case 49: return 6;
                    case 50: return 6;
                    case 51: return 6;
                    case 52: return 6;
                    case 53: return 6;
                    case 54: return 6;
                    case 55: return 6;
                    case 56: return 6;
                    case 57: return 6;
                    case 58: return 7;
                    case 60: return 8;
                    case 61: return 9;
                    case 62: return 10;
                    case 65: return 11;
                    case 68: return 12;
                    case 69: return 13;
                    case 70: return 14;
                    case 73: return 15;
                    case 76: return 16;
                    case 79: return 17;
                    case 82: return 18;
                    case 83: return 19;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 2:
                switch (c)
                {
                    case 34: return 21;
                    case 48: return 2;
                    case 49: return 2;
                    case 50: return 2;
                    case 51: return 2;
                    case 52: return 2;
                    case 53: return 2;
                    case 54: return 2;
                    case 55: return 2;
                    case 56: return 2;
                    case 57: return 2;
                    case 65: return 2;
                    case 66: return 2;
                    case 67: return 2;
                    case 68: return 2;
                    case 69: return 2;
                    case 70: return 2;
                    case 71: return 2;
                    case 72: return 2;
                    case 73: return 2;
                    case 74: return 2;
                    case 75: return 2;
                    case 76: return 2;
                    case 77: return 2;
                    case 78: return 2;
                    case 79: return 2;
                    case 80: return 2;
                    case 81: return 2;
                    case 82: return 2;
                    case 83: return 2;
                    case 84: return 2;
                    case 85: return 2;
                    case 86: return 2;
                    case 87: return 2;
                    case 88: return 2;
                    case 89: return 2;
                    case 90: return 2;
                    case 97: return 2;
                    case 98: return 2;
                    case 99: return 2;
                    case 100: return 2;
                    case 101: return 2;
                    case 102: return 2;
                    case 103: return 2;
                    case 104: return 2;
                    case 105: return 2;
                    case 106: return 2;
                    case 107: return 2;
                    case 108: return 2;
                    case 109: return 2;
                    case 110: return 2;
                    case 111: return 2;
                    case 112: return 2;
                    case 113: return 2;
                    case 114: return 2;
                    case 115: return 2;
                    case 116: return 2;
                    case 117: return 2;
                    case 118: return 2;
                    case 119: return 2;
                    case 120: return 2;
                    case 121: return 2;
                    case 122: return 2;
                    default: return -1;
                }
            case 6:
                switch (c)
                {
                    case 44: return 22;
                    case 48: return 6;
                    case 49: return 6;
                    case 50: return 6;
                    case 51: return 6;
                    case 52: return 6;
                    case 53: return 6;
                    case 54: return 6;
                    case 55: return 6;
                    case 56: return 6;
                    case 57: return 6;
                    default: return -1;
                }
            case 8:
                switch (c)
                {
                    case 61: return 9;
                    case 62: return 9;
                    default: return -1;
                }
            case 10:
                switch (c)
                {
                    case 61: return 9;
                    default: return -1;
                }
            case 11:
                switch (c)
                {
                    case 76: return 23;
                    case 84: return 24;
                    default: return -1;
                }
            case 12:
                switch (c)
                {
                    case 69: return 25;
                    default: return -1;
                }
            case 13:
                switch (c)
                {
                    case 78: return 26;
                    default: return -1;
                }
            case 14:
                switch (c)
                {
                    case 73: return 27;
                    default: return -1;
                }
            case 15:
                switch (c)
                {
                    case 77: return 28;
                    case 78: return 29;
                    default: return -1;
                }
            case 16:
                switch (c)
                {
                    case 69: return 30;
                    default: return -1;
                }
            case 17:
                switch (c)
                {
                    case 85: return 31;
                    default: return -1;
                }
            case 18:
                switch (c)
                {
                    case 69: return 32;
                    default: return -1;
                }
            case 19:
                switch (c)
                {
                    case 69: return 33;
                    default: return -1;
                }
            case 20:
                switch (c)
                {
                    case 48: return 20;
                    case 49: return 20;
                    case 50: return 20;
                    case 51: return 20;
                    case 52: return 20;
                    case 53: return 20;
                    case 54: return 20;
                    case 55: return 20;
                    case 56: return 20;
                    case 57: return 20;
                    case 65: return 20;
                    case 66: return 20;
                    case 67: return 20;
                    case 68: return 20;
                    case 69: return 20;
                    case 70: return 20;
                    case 71: return 20;
                    case 72: return 20;
                    case 73: return 20;
                    case 74: return 20;
                    case 75: return 20;
                    case 76: return 20;
                    case 77: return 20;
                    case 78: return 20;
                    case 79: return 20;
                    case 80: return 20;
                    case 81: return 20;
                    case 82: return 20;
                    case 83: return 20;
                    case 84: return 20;
                    case 85: return 20;
                    case 86: return 20;
                    case 87: return 20;
                    case 88: return 20;
                    case 89: return 20;
                    case 90: return 20;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 22:
                switch (c)
                {
                    case 48: return 34;
                    case 49: return 34;
                    case 50: return 34;
                    case 51: return 34;
                    case 52: return 34;
                    case 53: return 34;
                    case 54: return 34;
                    case 55: return 34;
                    case 56: return 34;
                    case 57: return 34;
                    default: return -1;
                }
            case 23:
                switch (c)
                {
                    case 71: return 35;
                    default: return -1;
                }
            case 24:
                switch (c)
                {
                    case 82: return 36;
                    default: return -1;
                }
            case 25:
                switch (c)
                {
                    case 67: return 37;
                    default: return -1;
                }
            case 26:
                switch (c)
                {
                    case 81: return 38;
                    case 84: return 39;
                    default: return -1;
                }
            case 27:
                switch (c)
                {
                    case 77: return 40;
                    default: return -1;
                }
            case 28:
                switch (c)
                {
                    case 80: return 41;
                    default: return -1;
                }
            case 29:
                switch (c)
                {
                    case 73: return 42;
                    case 84: return 43;
                    default: return -1;
                }
            case 30:
                switch (c)
                {
                    case 82: return 44;
                    default: return -1;
                }
            case 32:
                switch (c)
                {
                    case 65: return 45;
                    default: return -1;
                }
            case 34:
                switch (c)
                {
                    case 48: return 34;
                    case 49: return 34;
                    case 50: return 34;
                    case 51: return 34;
                    case 52: return 34;
                    case 53: return 34;
                    case 54: return 34;
                    case 55: return 34;
                    case 56: return 34;
                    case 57: return 34;
                    default: return -1;
                }
            case 35:
                switch (c)
                {
                    case 79: return 46;
                    default: return -1;
                }
            case 36:
                switch (c)
                {
                    case 73: return 47;
                    default: return -1;
                }
            case 37:
                switch (c)
                {
                    case 76: return 48;
                    default: return -1;
                }
            case 38:
                switch (c)
                {
                    case 85: return 49;
                    default: return -1;
                }
            case 39:
                switch (c)
                {
                    case 65: return 50;
                    default: return -1;
                }
            case 41:
                switch (c)
                {
                    case 82: return 51;
                    default: return -1;
                }
            case 42:
                switch (c)
                {
                    case 67: return 52;
                    default: return -1;
                }
            case 43:
                switch (c)
                {
                    case 69: return 53;
                    default: return -1;
                }
            case 45:
                switch (c)
                {
                    case 76: return 54;
                    default: return -1;
                }
            case 46:
                switch (c)
                {
                    case 82: return 55;
                    default: return -1;
                }
            case 47:
                switch (c)
                {
                    case 66: return 56;
                    default: return -1;
                }
            case 48:
                switch (c)
                {
                    case 65: return 57;
                    default: return -1;
                }
            case 49:
                switch (c)
                {
                    case 65: return 58;
                    default: return -1;
                }
            case 50:
                switch (c)
                {
                    case 79: return 59;
                    default: return -1;
                }
            case 51:
                switch (c)
                {
                    case 73: return 60;
                    default: return -1;
                }
            case 52:
                switch (c)
                {
                    case 73: return 61;
                    default: return -1;
                }
            case 53:
                switch (c)
                {
                    case 73: return 62;
                    default: return -1;
                }
            case 55:
                switch (c)
                {
                    case 73: return 63;
                    default: return -1;
                }
            case 56:
                switch (c)
                {
                    case 85: return 64;
                    default: return -1;
                }
            case 57:
                switch (c)
                {
                    case 82: return 65;
                    default: return -1;
                }
            case 58:
                switch (c)
                {
                    case 78: return 66;
                    default: return -1;
                }
            case 60:
                switch (c)
                {
                    case 77: return 67;
                    default: return -1;
                }
            case 61:
                switch (c)
                {
                    case 79: return 68;
                    default: return -1;
                }
            case 62:
                switch (c)
                {
                    case 82: return 69;
                    default: return -1;
                }
            case 63:
                switch (c)
                {
                    case 84: return 70;
                    default: return -1;
                }
            case 64:
                switch (c)
                {
                    case 73: return 71;
                    default: return -1;
                }
            case 65:
                switch (c)
                {
                    case 65: return 72;
                    default: return -1;
                }
            case 66:
                switch (c)
                {
                    case 84: return 73;
                    default: return -1;
                }
            case 67:
                switch (c)
                {
                    case 73: return 74;
                    default: return -1;
                }
            case 69:
                switch (c)
                {
                    case 79: return 75;
                    default: return -1;
                }
            case 70:
                switch (c)
                {
                    case 77: return 76;
                    default: return -1;
                }
            case 71:
                switch (c)
                {
                    case 82: return 77;
                    default: return -1;
                }
            case 72:
                switch (c)
                {
                    case 67: return 78;
                    default: return -1;
                }
            case 73:
                switch (c)
                {
                    case 79: return 79;
                    default: return -1;
                }
            case 74:
                switch (c)
                {
                    case 82: return 80;
                    default: return -1;
                }
            case 76:
                switch (c)
                {
                    case 79: return 81;
                    default: return -1;
                }
            case 78:
                switch (c)
                {
                    case 79: return 82;
                    default: return -1;
                }
            case 82:
                switch (c)
                {
                    case 69: return 83;
                    default: return -1;
                }
            case 83:
                switch (c)
                {
                    case 83: return 84;
                    default: return -1;
                }
            default: return -1;
        }
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
}
