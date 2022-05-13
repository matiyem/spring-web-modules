package com.example.sampleApp.web.controller;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 2:27 PM
*/

import com.example.sampleApp.repository.HeavyResourceRepository;
import com.example.sampleApp.web.dto.HeavyResource;
import com.example.sampleApp.web.dto.HeavyResourceAddressOnly;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HeavyResourceController {
    private HeavyResourceRepository heavyResourceRepository = new HeavyResourceRepository();

    @RequestMapping(value = "/heavyresource/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveResource(@RequestBody HeavyResource heavyResource, @PathVariable("id") String id) {
        heavyResourceRepository.save(heavyResource, id);
        return ResponseEntity.ok("resource saved");
    }

    @RequestMapping(value = "/heavyresource/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdateName(@RequestBody HeavyResourceAddressOnly partialUpdate, @PathVariable("id") String id) {
        heavyResourceRepository.save(partialUpdate, id);
        return ResponseEntity.ok("resource address updated");
    }

    @RequestMapping(value = "/heavyresource2/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdateGeneric(@RequestBody Map<String, Object> updates,
                                                  @PathVariable("id") String id) {
        heavyResourceRepository.save(updates, id);
        return ResponseEntity.ok("resource updated");
    }
}
