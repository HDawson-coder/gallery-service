package edu.cnm.deepdive.galleryservice.model.dao;

import edu.cnm.deepdive.galleryservice.model.entity.Image;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

  //TODO something here later

}
