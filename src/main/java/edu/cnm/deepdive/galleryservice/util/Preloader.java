package edu.cnm.deepdive.galleryservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cnm.deepdive.galleryservice.model.entity.Gallery;
import edu.cnm.deepdive.galleryservice.model.entity.User;
import edu.cnm.deepdive.galleryservice.service.GalleryService;
import edu.cnm.deepdive.galleryservice.service.UserService;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Profile("preload")
public class Preloader implements CommandLineRunner {

  private static final String PRELOADER_USERNAME = "system";
  private static final String PRELOADER_OAUTH_KEY = "";
  private static final String PRELOADER_DATA = "preload/galleries.json";

  private final UserService userService;
  private final GalleryService galleryService;

  @Autowired
  public Preloader(UserService userService, GalleryService galleryService) {
    this.userService = userService;
    this.galleryService = galleryService;
  }

  @Override
  public void run(String... args) throws Exception {
    User user = userService.getOrCreate(PRELOADER_OAUTH_KEY, PRELOADER_USERNAME);
    ClassPathResource resource = new ClassPathResource(PRELOADER_DATA);
    try (InputStream input = resource.getInputStream()) {
      List<Gallery> galleries = new LinkedList<>();
      ObjectMapper mapper = new ObjectMapper();
      for (Gallery gallery : mapper.readValue(input, Gallery[].class)) {
        gallery.setCreator(user);
        galleries.add(gallery);
      }
      galleryService.save(galleries);
    }
  }
}
