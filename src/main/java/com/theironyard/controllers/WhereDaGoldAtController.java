package com.theironyard.controllers;

import com.theironyard.entities.Sighting;
import com.theironyard.entities.User;
import com.theironyard.services.SightingRepository;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

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

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user, HttpSession session) {
        User existingUser = users.findByName(user.getName());
        if (existingUser == null) {
            existingUser = user;
            users.save(user);
        }
        session.setAttribute("userName", existingUser.getName());
        return existingUser;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public User getLogin(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return users.findByName(userName);
    }

    @RequestMapping(path = "/sightings", method = RequestMethod.GET)
    public List<Sighting> getSightings() {
        return (List<Sighting>) sightings.findAll();
    }

    @RequestMapping(path = "/sightings", method = RequestMethod.POST)
    public Sighting addSighting(@RequestBody Sighting sighting, HttpSession session) throws Exception {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByName(userName);
//        if (user == null) {
//            throw new Exception("Not logged in.");
//        }
        sighting.setUser(user);
        sightings.save(sighting);
        return sighting;
    }
}
