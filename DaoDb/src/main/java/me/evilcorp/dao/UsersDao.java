package me.evilcorp.dao;

import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 09.12.16.
 */
public interface UsersDao {
    /**
     * Возвращает список сущностей
     * @return переменная типа List<User>
     */
    List<User> findAll();

    /**
     * Обновляет сущность
     * @param user сущность, которую нужно обновить с новыми данным
     */
    void update(User user);

    /**
     * сохраняет сущность
     * @param user сама сущность
     */
    void save(User user);

    /**
     * Находит по идентификатору
     * @param id идентификатор
     * @return сущность
     */
    User find(int id);

    /**
     * Удалить по идентификатору
     * @param id
     */
    void delete(int id);

    void clean();

    boolean contains(int id);
}
