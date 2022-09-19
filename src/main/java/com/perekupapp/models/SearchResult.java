package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchResult {

    @JsonProperty
    private ObjectNode result;

    @JsonProperty
    private ObjectNode ids;

}
