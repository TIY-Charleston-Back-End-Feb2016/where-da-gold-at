package com.theironyard.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by zach on 3/17/16.
 */
@Entity
@Table(name = "sightings")
public class Sighting {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    String description;

    LocalDateTime time;

    @Column(nullable = false)
    String photo;

    @ManyToOne
    User user;

    @Transient
    String timeText;

    public Sighting() {
    }

    public Sighting(String location, String description, LocalDateTime time, String photo, User user) {
        this.location = location;
        this.description = description;
        this.time = time;
        this.photo = photo;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTimeText() {
        if (time != null) {
            return String.format("%s, %s %s %s at %s:%s", time.getDayOfWeek(), time.getMonth(), time.getDayOfMonth(), time.getYear(), time.getHour(), time.getMinute());
        }
        return "";
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }
}
