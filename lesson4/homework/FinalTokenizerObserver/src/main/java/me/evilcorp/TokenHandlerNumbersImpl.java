package me.evilcorp;

import me.evilcorp.observer.TokenHandler;
import me.evilcorp.tokens.Number;
import me.evilcorp.tokens.Token;

/**
 * Created by ekzotech on 28.11.16.
 */
public class TokenHandlerNumbersImpl implements TokenHandler {
    public void handleToken(Token token) {
//        System.out.println(token.getClass().getSimpleName().equals(Number.class.getSimpleName()));
        if (token.getClass().getName().equals(Number.class.getName())) {
            System.out.println("из: " + getName() + " : Йа циферко! " + token);
        }
    }

    public String getName() {
        return "NumberHandler";
    }
}
