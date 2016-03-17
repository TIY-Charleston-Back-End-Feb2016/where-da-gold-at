package com.theironyard.controllers;

import com.theironyard.services.SightingRepository;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

/**
 * Created by zach on 3/17/16.
 */
@RestController
public class WhereDaGoldAtController {
    @Autowired
    UserRepository users;

    @Autowired
    SightingRepository sightings;

    Server dbui;

    @PostConstruct
    public void construct() throws SQLException {
        dbui = Server.createWebServer().start();
    }

    @PreDestroy
    public void destroy() {
        dbui.stop();
    }
}
