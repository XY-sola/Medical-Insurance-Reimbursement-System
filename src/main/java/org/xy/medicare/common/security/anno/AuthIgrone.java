package org.xy.medicare.common.security.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:22
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface AuthIgrone {
}
