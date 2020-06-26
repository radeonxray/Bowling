package com.company.Connection;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientSetup {
    /**
     * Setting up the HttpClient for posting data
     * Note that the HTTP version has been set to 1_1, so that it may work with both Skat and Ceo's backend
     * */
    public static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

}
