package me.evilcorp.observer;

import me.evilcorp.tokens.Token;

/**
 * Created by ekzotech on 28.11.16.
 */
public interface TokenHandler {
    void handleToken(Token token);
    String getName();
}
