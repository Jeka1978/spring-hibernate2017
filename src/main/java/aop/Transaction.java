package aop;/**
 * Created by Evegeny on 06/03/2017.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Transaction {
}
