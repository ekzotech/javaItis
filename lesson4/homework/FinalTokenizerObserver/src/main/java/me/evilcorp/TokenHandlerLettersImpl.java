package me.evilcorp;

import me.evilcorp.observer.TokenHandler;
import me.evilcorp.tokens.Letter;
import me.evilcorp.tokens.Token;

/**
 * Created by ekzotech on 28.11.16.
 */
public class TokenHandlerLettersImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Letter.class.getName())) {
            System.out.println("из: " + getName() + " Йа букаффко! " + token);
        }
    }

    public String getName() {
        return "LetterHanlder";
    }
}
