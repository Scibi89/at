package com.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class EntriesResponseDTO {
    public int count;
    public ArrayList<Entry> entries;

    public static class Entry {
        @JsonProperty("API")
        public String aPI;

        @JsonProperty("Description")
        public String description;

        @JsonProperty("Auth")
        public String auth;

        @JsonProperty("HTTPS")
        public boolean hTTPS;

        @JsonProperty("Cors")
        public String cors;

        @JsonProperty("Link")
        public String link;

        @JsonProperty("Category")
        public String category;
    }
}
