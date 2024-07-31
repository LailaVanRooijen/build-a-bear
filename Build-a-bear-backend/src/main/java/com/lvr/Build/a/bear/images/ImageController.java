package com.lvr.Build.a.bear.images;

import static com.lvr.Build.a.bear.appconfiguration.Routes.IMAGES;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(IMAGES)
@CrossOrigin(origins = {"${client}"})
@RequiredArgsConstructor
public class ImageController {
  private final ImageService imageService;

  @PostMapping
  public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file)
      throws IOException {
    String uploadImage = imageService.uploadImage(file);
    return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
  }

  @GetMapping("/{fileName}")
  public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
    byte[] imageData = imageService.downloadImage(fileName);
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE))
        .body(imageData);
  }
}
