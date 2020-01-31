package com.infoshare.academy.highfive.web.servlet.filters;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.client.json.jackson2.JacksonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

@Singleton
class GoogleOauthConfiguration {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    Properties settings = new Properties();
    private String GOOGLE_PROPERTIES_FILE = "google.properties";
    private String googleClientId = "";
    private String googleClientSecret = "";
    private String googleCallbackUri = "";

    private final JsonFactory JSON_FACTORY = new JacksonFactory();
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private String stateToken;

    private GoogleAuthorizationCodeFlow flow = null;

    public void startConfiguration() {

        try {
            settings.load(Thread.currentThread().getContextClassLoader().getResource(GOOGLE_PROPERTIES_FILE).openStream());

            Collection<String> scope = Arrays.asList(settings.getProperty("google.oauth.api.url").split(";"));

            googleClientId = settings.getProperty("google.ouath.client_id");
            googleClientSecret = settings.getProperty("google.oauth.client.secret");
            googleCallbackUri = settings.getProperty("google.oauth.client.callback_uri");

            flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
                    JSON_FACTORY, googleClientId, googleClientSecret, scope).build();

        } catch (IOException e) {
            logger.error("Can't read GOOGLE PROPERTIES FILE {}", e.getMessage());
        }
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

    public String getGoogleClientSecret() {
        return googleClientSecret;
    }

    public void setGoogleClientSecret(String googleClientSecret) {
        this.googleClientSecret = googleClientSecret;
    }

    public String getGoogleCallbackUri() {
        return googleCallbackUri;
    }

    public void setGoogleCallbackUri(String googleCallbackUri) {
        this.googleCallbackUri = googleCallbackUri;
    }

    public JsonFactory getJsonFactory() {
        return JSON_FACTORY;
    }

    public HttpTransport getHttpTransport() {
        return HTTP_TRANSPORT;
    }

    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
        this.stateToken = stateToken;
    }

    public GoogleAuthorizationCodeFlow getFlow() {
        return flow;
    }

    public void setFlow(GoogleAuthorizationCodeFlow flow) {
        this.flow = flow;
    }
}

