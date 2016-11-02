/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package sample.helloworld.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the ByeService so that it can be served.
 */
public class ByeServiceModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {

    }
}
