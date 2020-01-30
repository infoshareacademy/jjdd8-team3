package com.infoshare.academy.highfive.web.servlet.filters;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class AuthenticationService {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    String GOOGLE_PROPERTIES_FILE = "google.properties";
    String googleClientId = "";
    String googleClientSecret = "";
    String googleCallbackUri = "";

    private static final Collection<String> SCOPE = Arrays.asList("https://www.googleapis.com/auth/userinfo.profile;https://www.googleapis.com/auth/userinfo.email".split(";"));
    private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private String stateToken;

    private GoogleAuthorizationCodeFlow flow = null;

    public void UserAuthenticationService() {

        Properties settings = new Properties();

        try {
            settings.load(Thread.currentThread().getContextClassLoader().getResource(GOOGLE_PROPERTIES_FILE).openStream());

            googleClientId = settings.getProperty("google.ouath.client_id");
            googleClientSecret = settings.getProperty("google.oauth.client.secret");
            googleCallbackUri = settings.getProperty("google.oauth.client.callback_uri");

            flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
                    JSON_FACTORY, googleClientId, googleClientSecret, SCOPE).build();

        } catch (IOException e) {
            logger.error("Can't read GOOGLE PROPERTIES FILE {}", e.getMessage());
        }
        generateStateToken();
    }

    public String buildLoginUrl() {
        final GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
        logger.info("Callback URI {}", googleCallbackUri);
        logger.info("State token {}", stateToken);
        return url.setRedirectUri(googleCallbackUri).setState(stateToken).build();
    }

    private void generateStateToken() {
        SecureRandom sr1 = new SecureRandom();
        logger.info("Generated sr1 {}", sr1.toString());
        stateToken = "google;" + sr1.nextInt();
        logger.info("Generated state token {}", stateToken);

    }

    public String getUserInfoJson(final String authCode) throws IOException {
        final GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(googleCallbackUri).execute();
        final Credential credential = flow.createAndStoreCredential(response, null);
        String myToken = credential.getAccessToken();
        System.out.println("Token: " + myToken);
        final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
        // Make an authenticated request
        final GenericUrl url = new GenericUrl(USER_INFO_URL);
        final HttpRequest request = requestFactory.buildGetRequest(url);
        request.getHeaders().setContentType("text/plain");
        HttpResponse gResponse = request.execute();
        logger.info("get headers: {}", gResponse.getHeaders());
        return request.execute().parseAsString();
    }
}
