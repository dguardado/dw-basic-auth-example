package tech.dimas.example;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import tech.dimas.example.api.User;
import tech.dimas.example.resources.GreetingResource;
import tech.dimas.example.resources.PasswordAuthenticator;

public class DwBasicAuthApplication extends Application<DwBasicAuthConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DwBasicAuthApplication().run(args);
    }

    @Override
    public String getName() {
        return "DwBasicAuth";
    }

    @Override
    public void initialize(final Bootstrap<DwBasicAuthConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    }

    @Override
    public void run(final DwBasicAuthConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new PasswordAuthenticator(configuration.getPassword()))
                        .buildAuthFilter()));

        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));

        environment.jersey().register(new GreetingResource());
    }

}
