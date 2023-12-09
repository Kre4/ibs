package ru.ibs.app.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ibs.db.service.beans.user.UserService;
import ru.ibs.entity.user.User;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Попытка авторизации пользователем: " + username);
//        User user = userService.findByUsername(username);
//        if (user != null) {
//            return UserPrinciple.build(user);
//        } else {
//            throw new UsernameNotFoundException("User Not Found with -> login : " + username);
//        }
    }
}
