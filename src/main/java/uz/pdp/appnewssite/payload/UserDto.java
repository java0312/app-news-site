package uz.pdp.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Size(min = 5, max = 50)
    @NotNull(message = "fullName is mandatory")
    private String fullName;

    @Size(min = 5, max = 50)
    @NotNull(message = "username is mandatory")
    private String username;

    @Size(min = 5, max = 50)
    @NotNull(message = "password is mandatory")
    private String password;

    @NotNull(message = "roleId is mandatory")
    private Long roleId;
}
