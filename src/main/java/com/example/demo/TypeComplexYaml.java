package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "filenames")
public class TypeComplexYaml {

    /*
     * il nome della varibile deve corrispondere al sotto nome definito nel file YAML
     */
    List<String> type;

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> filenames) {
        this.type = filenames;
    }
}