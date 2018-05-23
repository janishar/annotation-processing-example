package com.mindorks.lib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * It will keep any class after proguard minify
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Keep {
}
