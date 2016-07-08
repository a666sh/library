package org.lee.spring.hibernate.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LibAuth {
	String value() default "";
}
