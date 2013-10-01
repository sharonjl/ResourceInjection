package com.sharonjl.resourceinjectionlibrary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sharon on 2013-10-01.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface FromResource {
    int value();
}
