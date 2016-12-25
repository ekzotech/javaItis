package me.evilcorp.verify;

import me.evilcorp.dao.UsersDao;
import me.evilcorp.factories.DaoFactory;

/**
 * Created by ekzotech on 09.12.16.
 */
public class VerifierImpl implements Verifier {
    private UsersDao usersDao;

    public VerifierImpl() {
        this.usersDao = DaoFactory.getInstance().getDao();
    }

    public VerifierImpl(UsersDao usersDao){
        this.usersDao = usersDao;
    }

    public void userExist(int userId) {
        boolean isExist = usersDao.contains(userId);
        // запрос в файл/бд проверки, есть там пользователь или нет
        if (!isExist) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
