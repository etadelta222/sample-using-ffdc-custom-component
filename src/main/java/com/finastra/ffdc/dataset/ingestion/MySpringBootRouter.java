package com.finastra.ffdc.dataset.ingestion;

import com.codahale.metrics.Slf4jReporter.LoggingLevel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * A simple Camel route that triggers from a timer and calls a bean and prints
 * to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Autowired
    InputParametersSettings InputParametersSettings;

    @Override
    public void configure() {


        from("timer://foo?repeatCount=1").routeId("sql-extract-route")
        .to("sql:select * from customer?dataSource=#setupDataSource")   
        .marshal()
        .json(JsonLibrary.Jackson) 
        .convertBodyTo(String.class)                         
        .to("ffdc://bar?environment="+ InputParametersSettings.getEnvironment()
                         +"&id="+InputParametersSettings.getId()
                         +"&secret="+InputParametersSettings.getSecret()
                         +"&dataSetId="+InputParametersSettings.getDataSetId()
                         +"&fileName="+InputParametersSettings.getFileName());
    }


}
