package uz.pdp.appnewssite.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD) //qayerda ishlasin method ustida
@Retention(RetentionPolicy.RUNTIME) //qachon ishlasin rutime vaqtida
public @interface CheckPermission {

    String value(); //value ixtiyoriy nom

}
