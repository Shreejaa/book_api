/*
package com.Training.BookService;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("book-service")
@PactFolder("C:\\Users\\Shreejaa\\Documents\\jpop\\library-service\\library-service\\target\\mypacts")
public class PactProviderTest {

    @TestTarget
    public final Target target = new HttpTarget("http","localhost",8585,"/");

    private static ConfigurableWebApplicationContext applicationContext;

    @BeforeClass
    public static void start(){
        applicationContext = (ConfigurableWebApplicationContext)
                SpringApplication.run(BookServiceApplication.class);
    }
}
*/
