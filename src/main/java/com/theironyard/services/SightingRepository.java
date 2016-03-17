package com.theironyard.services;

import com.theironyard.entities.Sighting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zach on 3/17/16.
 */
public interface SightingRepository extends CrudRepository<Sighting, Integer> {
}
