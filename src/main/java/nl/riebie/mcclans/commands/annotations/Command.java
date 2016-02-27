package nl.riebie.mcclans.commands.annotations;

import nl.riebie.mcclans.api.enums.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Mirko on 16/01/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    String name();
    String description() default "";
    Permission clanPermission() default Permission.none;
    boolean isPlayerOnly() default false;
    boolean isClanOnly() default false;
    String spongePermission();
}