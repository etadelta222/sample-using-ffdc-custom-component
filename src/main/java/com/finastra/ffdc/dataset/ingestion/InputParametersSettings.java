package com.finastra.ffdc.dataset.ingestion;

import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "input.parameters")

public class InputParametersSettings {
    private String environment;   
    private String id;
    private String secret;
    private String dataSetId;
    private String fileName;
}
