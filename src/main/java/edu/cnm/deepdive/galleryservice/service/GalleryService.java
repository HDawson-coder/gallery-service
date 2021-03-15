package edu.cnm.deepdive.galleryservice.service;

import edu.cnm.deepdive.galleryservice.model.dao.GalleryRepository;
import edu.cnm.deepdive.galleryservice.model.entity.Gallery;
import edu.cnm.deepdive.galleryservice.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {

  private final GalleryRepository galleryRepository;

  public GalleryService(
      GalleryRepository galleryRepository) {
    this.galleryRepository = galleryRepository;
  }

  public Gallery newGallery(Gallery gallery, User creator) {
    gallery.setCreator(creator);
    return galleryRepository.save(gallery);
  }
}
