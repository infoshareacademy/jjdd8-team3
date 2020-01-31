package com.infoshare.academy.highfive.web.servlet.filters;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;


@Stateless
public class AuthenticationService {

    @Inject
    private GoogleOauthConfiguration googleOauthConfiguration;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    Properties settings = new Properties();
    String GOOGLE_PROPERTIES_FILE = "google.properties";
    private String stateToken;

    @PostConstruct
    public void generateToken() {
        googleOauthConfiguration.startConfiguration();
        generateStateToken();
    }

    public String buildLoginUrl() {
        final GoogleAuthorizationCodeRequestUrl url = googleOauthConfiguration.getFlow().newAuthorizationUrl();
        logger.info("Callback URI {}", googleOauthConfiguration.getGoogleCallbackUri());
        logger.info("State token {}", stateToken);
        return url.setRedirectUri(googleOauthConfiguration.getGoogleCallbackUri()).setState(stateToken).build();
    }

    private void generateStateToken() {
        SecureRandom sr1 = new SecureRandom();
        logger.info("Generated sr1 {}", sr1.toString());
        stateToken = "google;" + sr1.nextInt();
        logger.info("Generated state token {}", stateToken);

    }

    public String getUserInfoJson(final String authCode) throws IOException {
        String userInfoUrl = "";
        try {
            settings.load(Thread.currentThread().getContextClassLoader().getResource(GOOGLE_PROPERTIES_FILE).openStream());
            userInfoUrl = settings.getProperty("google.oauth.user.info.url");
        } catch (IOException e) {
            logger.error("Can't read GOOGLE PROPERTIES FILE {}", e.getMessage());
        }

        final GoogleTokenResponse response = googleOauthConfiguration.getFlow().newTokenRequest(authCode).setRedirectUri(googleOauthConfiguration.getGoogleCallbackUri()).execute();
        final Credential credential = googleOauthConfiguration.getFlow().createAndStoreCredential(response, null);
        String credentialAccessToken = credential.getAccessToken();
        final HttpRequestFactory requestFactory = googleOauthConfiguration.getHttpTransport().createRequestFactory(credential);
        // Make an authenticated request
        final GenericUrl url = new GenericUrl(userInfoUrl);
        final HttpRequest request = requestFactory.buildGetRequest(url);
        request.getHeaders().setContentType("text/plain");
        HttpResponse gResponse = request.execute();
        return request.execute().parseAsString();
    }
}
