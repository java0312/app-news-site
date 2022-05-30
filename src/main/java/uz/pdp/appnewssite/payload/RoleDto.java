package uz.pdp.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appnewssite.entity.enums.Permission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank(message = "name is mandatory") //probeldan boshqa belgilar bolsin
    private String name;

    @NotEmpty(message = "Role must not be without permission")
    private Set<Permission> permissions;

    @NotNull(message = "description is mandatory")
    private String description;
}
