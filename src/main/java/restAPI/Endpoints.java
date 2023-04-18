package restAPI;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Endpoints {

    BASE("Base URL of heroku app from waar koop", "https://waarkoop-server.herokuapp.com/api/v1"),
    SEARCH("Can retrieve a list of all products from the query type if available", "/search/demo/");
    String summary;
    String path;

    Endpoints(String summary, String path) {
        this.summary = summary;
        this.path = path;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getPath() {
        return this.path;
    }


}
