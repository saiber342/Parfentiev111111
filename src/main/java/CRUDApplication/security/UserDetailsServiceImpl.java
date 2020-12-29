package CRUDApplication.security;

import CRUDApplication.dao.UserDAO;
import CRUDApplication.models.User;
import CRUDApplication.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = (User) userService.getUserByName(login);
        if (user != null) {
            return user;
        } else throw new IllegalArgumentException();
    }
}
