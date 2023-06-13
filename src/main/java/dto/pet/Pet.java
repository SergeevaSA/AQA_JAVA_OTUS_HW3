package dto.pet;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Pet {
  private Long id;
  private String name;
  private String[] photoUrls;
  private String status;
}