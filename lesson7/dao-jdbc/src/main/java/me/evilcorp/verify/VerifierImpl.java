package me.evilcorp.verify;

import me.evilcorp.dao.UserDao;
import me.evilcorp.factory.DaoFactory;

/**
 * Created by ekzotech on 29.11.16.
 */
public class VerifierImpl implements Verifier {

    private UserDao userDao;

    public VerifierImpl() { this.userDao = DaoFactory.getInstance().getUserDao(); }

    public VerifierImpl(UserDao userDao) { this.userDao = userDao; }

    @Override
    public void userExist(int userId) {

    }
}
