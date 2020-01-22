package com.infoshare.academy.highfive.web.api;

import javax.persistence.Cacheable;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
@Cacheable(true)
public class Api extends Application {


}
