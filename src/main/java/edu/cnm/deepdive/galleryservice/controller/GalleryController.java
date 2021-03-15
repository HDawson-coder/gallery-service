package edu.cnm.deepdive.galleryservice.controller;

import edu.cnm.deepdive.galleryservice.model.entity.Gallery;
import edu.cnm.deepdive.galleryservice.model.entity.User;
import edu.cnm.deepdive.galleryservice.service.GalleryService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/galleries")
public class GalleryController {

  private final GalleryService galleryService;

  public GalleryController(GalleryService galleryService) {
    this.galleryService = galleryService;
  }

  //getPrincipal is the user. (User) is casting the user into the principal object.
 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Gallery post(@RequestBody Gallery gallery, Authentication auth) {
    return galleryService.newGallery(gallery, (User) auth.getPrincipal());
  }
}

