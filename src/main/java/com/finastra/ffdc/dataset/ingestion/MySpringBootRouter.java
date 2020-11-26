package com.finastra.ffdc.dataset.ingestion;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints
 * to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {

         from("timer:hello?period={{timer.period}}&repeatCount=1").routeId("hello1")
        .process(exchange -> exchange.getIn().setBody("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"))                             
        .to("ffdc://bar?environment=lobdev&id=1988806a-8113-4cba-ab81-22b5eada6d99&secret=5a13861f-f1fd-441f-9683-72cee3f9b99e&dataSetId=trades-v1-27a8371b-9317-43ed-82c0-39835cf1ec03&fileName=2019-02-13T23:00:00.000Z.json");
    }

}
