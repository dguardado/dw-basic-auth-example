package tech.dimas.example.resources;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import tech.dimas.example.api.User;

import java.util.Optional;

public class PasswordAuthenticator implements Authenticator<BasicCredentials, User> {

    private final String password;

    public PasswordAuthenticator(String password) {
        this.password = password;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) {
        if (password.equals(basicCredentials.getPassword())) {
            return Optional.of(new User(basicCredentials.getUsername()));
        }
        return Optional.empty();
    }
}
