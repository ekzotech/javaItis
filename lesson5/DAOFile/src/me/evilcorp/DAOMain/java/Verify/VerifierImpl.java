package me.evilcorp.DAOMain.java.Verify;

import me.evilcorp.DAOMain.java.DAO.UsersDao;
import me.evilcorp.DAOMain.java.Factories.DaoFactory;
import me.evilcorp.DAOMain.java.Model.User;

/**
 * Created by ekzotech on 19.11.16.
 */
public class VerifierImpl implements Verifier {
    private UsersDao usersDao;

    public VerifierImpl(){
        this.usersDao = DaoFactory.getInstance().getDao();
    }

    public VerifierImpl(UsersDao usersDao){
        this.usersDao = usersDao;
    }

    public void userExist(int userId){
        boolean isExist = usersDao.contains(userId);
        if (!isExist){
            throw new IllegalArgumentException("Пользователь не найден");
        }
    }
}
