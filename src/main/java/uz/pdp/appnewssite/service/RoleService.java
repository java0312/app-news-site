package uz.pdp.appnewssite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.entity.Role;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.RoleDto;
import uz.pdp.appnewssite.repository.RoleRepository;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


    public ApiResponse addRole(RoleDto roleDto) {

        if (roleRepository.existsByName(roleDto.getName()))
            return new ApiResponse("This Role already exists!", false);

        Role role = new Role(
                roleDto.getName(),
                roleDto.getPermissions(),
                roleDto.getDescription()
        );

        roleRepository.save(role);
        return new ApiResponse("Role created successfully!", true);
    }

    public ApiResponse editRole(Long id, RoleDto roleDto) {
        if(roleRepository.existsByNameAndIdNot(roleDto.getName(), id))
            return new ApiResponse("This role already exists!", false);

        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty())
            return new ApiResponse("Role not found!", false);

        Role role = optionalRole.get();
        role.setName(roleDto.getName());
        role.setPermissions(roleDto.getPermissions());
        role.setDescription(roleDto.getDescription());
        roleRepository.save(role);

        return new ApiResponse("Role edited!", true);
    }
}
