/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package sample.helloworld.impl;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import sample.helloworld.api.ByeService;

/**
 * Implementation of the ByeService.
 */
public class ByeServiceImpl implements ByeService {

    @Override
    public ServiceCall<NotUsed, String> bye(String id) {
        return request -> null;
    }

}
