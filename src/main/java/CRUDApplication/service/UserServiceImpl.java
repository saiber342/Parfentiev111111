package CRUDApplication.service;

import CRUDApplication.dao.UserDAO;
import CRUDApplication.dao.UserDAOImpl;
import CRUDApplication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CRUDApplication.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;



    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);

    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);

    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

}
