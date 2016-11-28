package me.evilcorp.observer;

import me.evilcorp.tokens.Token;

/**
 * Created by ekzotech on 28.11.16.
 */
public interface TokenizerObservable {
    void addTokenHandler(TokenHandler handler);
    void removeTokenHandler(String handlerName);
    void notifyHandlers(Token token);
    void tokenize(String text);
}
