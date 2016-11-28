package me.evilcorp;

import me.evilcorp.observer.TokenHandler;
import me.evilcorp.observer.TokenizerObservable;
import me.evilcorp.tokens.Letter;
import me.evilcorp.tokens.Number;
import me.evilcorp.tokens.Separator;
import me.evilcorp.tokens.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ekzotech on 28.11.16.
 */
public class Tokenizer implements TokenizerObservable {

    private Map<String, TokenHandler> handlers;

    public Tokenizer(){
        handlers = new HashMap<String, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    }

    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    }

    public void notifyHandlers(Token token) {
        Set<Map.Entry<String, TokenHandler>> entries = handlers.entrySet();

        for (Map.Entry<String, TokenHandler> entity : entries) {
            TokenHandler currentTokenHandler = entity.getValue();
            currentTokenHandler.handleToken(token);
        }
    }

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        boolean onNumber = false;
        boolean onWord = false;
        String currentToken = "";
        for (int i = 0; i < textAsCharArray.length; i++) {
            if (Character.isDigit(textAsCharArray[i])) {
                if (!onNumber){
                    onNumber = true;
                    currentToken += textAsCharArray[i];

                } else { currentToken += textAsCharArray[i]; }
            } else if (Character.isLetter(textAsCharArray[i])) {
                if (!onWord) {
                    onWord = true;
                    currentToken += textAsCharArray[i];
                } else { currentToken += textAsCharArray[i]; }
            } else {
                if (onNumber) {
                    Token currentNumber = new Number();
                    currentNumber.setText(currentToken);
                    onNumber = false;
                    currentToken = "";
                    notifyHandlers(currentNumber);
                } else if (onWord) {
                    Token currentWord = new Letter();
                    currentWord.setText(currentToken);
                    onWord = false;
                    currentToken = "";
                    notifyHandlers(currentWord);
                } else {
                    Token currentSeparator = new Separator();
                    currentSeparator.setText(String.valueOf(textAsCharArray[i]));
                    notifyHandlers(currentSeparator);
                }
            }
            
        }
    }
}
