package uz.pdp.appnewssite.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.FORBIDDEN) //403
@Data
@AllArgsConstructor
public class ForbiddenException extends RuntimeException{
    private String type;
    private String message;
}
