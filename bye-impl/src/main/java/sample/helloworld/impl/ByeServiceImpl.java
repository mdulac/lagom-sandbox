/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package sample.helloworld.impl;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import sample.helloworld.api.ByeService;
import sample.helloworld.api.HelloService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Implementation of the ByeService.
 */
public class ByeServiceImpl implements ByeService {

    private HelloService helloService;

    @Inject
    public ByeServiceImpl(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public ServiceCall<NotUsed, String> bye(String id) {
        return request -> {

            CompletionStage<String> helloCompletionStage = helloService.hello(id).invoke();

            // Look up the hello world entity for the given ID.
            // Ask the entity the Hello command.
            return helloCompletionStage.thenCombine(CompletableFuture.completedFuture("Bye, " + id), (t, u) -> t + "\n" + u);
        };
    }

}
