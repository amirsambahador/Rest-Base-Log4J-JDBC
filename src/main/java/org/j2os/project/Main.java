package org.j2os.project;


import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        JettyHttpContainerFactory
                .createServer(URI.create("http://localhost:8081"),
                        new ResourceConfig()
                                .packages("org.j2os.project.api"));
    }
}