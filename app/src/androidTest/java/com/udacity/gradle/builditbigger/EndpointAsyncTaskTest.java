package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.network.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.network.OnJokeLoaded;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class EndpointAsyncTaskTest {

    private CountDownLatch signal;
    private String mJoke;

    @Test
    public void testEndpointAsyncTask() {
        try {
            signal = new CountDownLatch(1);
            new EndpointAsyncTask().execute(new OnJokeLoaded() {
                @Override
                public void jokeLoaded(String joke) {
                    mJoke = joke;
                    signal.countDown();
                }
            });
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("Null Joke", mJoke);
            assertFalse("Empty Joke", mJoke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }
}