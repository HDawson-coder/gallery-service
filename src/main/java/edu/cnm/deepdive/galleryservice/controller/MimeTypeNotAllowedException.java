package edu.cnm.deepdive.galleryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MimeTypeNotAllowedException extends ResponseStatusException {

  private static final String NOT_ALLOWED_RESON = "File type not allowed";

  public MimeTypeNotAllowedException() {
    super(HttpStatus.UNSUPPORTED_MEDIA_TYPE, NOT_ALLOWED_RESON);
  }
}
