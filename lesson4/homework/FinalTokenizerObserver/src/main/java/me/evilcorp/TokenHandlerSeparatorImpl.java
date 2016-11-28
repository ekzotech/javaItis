package me.evilcorp;

import me.evilcorp.observer.TokenHandler;
import me.evilcorp.tokens.Separator;
import me.evilcorp.tokens.Token;

/**
 * Created by ekzotech on 28.11.16.
 */
public class TokenHandlerSeparatorImpl implements TokenHandler{
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Separator.class.getName())) {
            System.out.println("из: " + getName() + " Йа несу вазмездие ваимя Луны!" + token);
        }
    }

    public String getName() {
        return "SeparatorHandler";
    }
}
