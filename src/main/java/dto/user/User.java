package dto.user;

import lombok.*;

@Data
@Builder
@AllArgsConstructor

public class User {
  private String email;
  private String firstName;
  private Long id;
  private String lastName;
  private String password;
  private String phone;
  private Long userStatus;
  private String username;
}
