package me.evilcorp.verify;

/**
 * Created by ekzotech on 09.12.16.
 */
public class VerifierImpl implements Verifier {
    public void userExist(int userId) {
        boolean isExist = false;
        // запрос в файл/бд проверки, есть там пользователь или нет

        if (!isExist) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
