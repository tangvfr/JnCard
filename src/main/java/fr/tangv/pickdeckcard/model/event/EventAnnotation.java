package fr.tangv.pickdeckcard.model.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventAnnotation {

    EventPriority priority() default EventPriority.NORMAL;
    Class<? extends Event> event();

}
