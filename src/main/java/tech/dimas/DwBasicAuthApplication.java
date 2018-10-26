package tech.dimas;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final DwBasicAuthConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
