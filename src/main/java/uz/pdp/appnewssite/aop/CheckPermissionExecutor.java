package uz.pdp.appnewssite.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.exceptions.ForbiddenException;

import java.util.function.Predicate;

@Component
@Aspect
public class CheckPermissionExecutor {

    @Before(value = "@annotation(checkPermission)")
    public void checkUserPermissionMyMethod(CheckPermission checkPermission){
        String value = checkPermission.value();// bu huquq Masalan: EDIT_ROLE

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (GrantedAuthority authority : principal.getAuthorities()) {
            if (authority.getAuthority().equals(value))
                return;
        }

        throw new ForbiddenException(checkPermission.value(), "Not Allowed");
    }

}
