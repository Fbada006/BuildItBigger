package com.udacity.gradle.builditbigger.backend;

import com.disruption.killerjokes.KillerJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that supplies a joke from the java joke library
     */
    @ApiMethod(name = "supplyJoke")
    public MyBean supplyJoke() {
        MyBean response = new MyBean();
        KillerJokes killerJokes = new KillerJokes();
        response.setData(killerJokes.getRandomKillerJoke());
        return response;
    }

}
