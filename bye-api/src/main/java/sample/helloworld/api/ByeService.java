/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package sample.helloworld.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.transport.Method.GET;

/**
 * The bye service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the ByeService.
 */
public interface ByeService extends Service {

    /**
     * Example: curl http://localhost:9000/api/bye/Alice
     */
    ServiceCall<NotUsed, String> bye(String id);

    @Override
    default Descriptor descriptor() {
        return named("byeservice").withCalls(
                restCall(GET, "/api/bye/:id", this::bye)
        ).withAutoAcl(true);
    }
}
