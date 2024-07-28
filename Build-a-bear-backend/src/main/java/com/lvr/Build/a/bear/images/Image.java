package com.lvr.Build.a.bear.images;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Images")
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  UUID id;

  private String name;

  private String type;

  @Lob private byte[] imageData;
}
