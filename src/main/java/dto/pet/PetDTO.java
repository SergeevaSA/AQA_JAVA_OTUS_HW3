package dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.yaml.snakeyaml.nodes.Tag;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PetDTO {
  private Long id;
  private String name;
  private List<String> photoUrls;
  private List<Tag> tags;
  private String status;
}