package ge.itestep.Lesson_Two;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String firstName();
    int age() default 1;
}
