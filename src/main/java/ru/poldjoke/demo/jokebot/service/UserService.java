package ru.poldjoke.demo.jokebot.service;

public interface UserService {
    void registration(String username, String password);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
