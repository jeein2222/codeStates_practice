package codeStates;
import java.lang.annotation.Target;

@Target({FIELD, TYPE, TYPE_USE})
public @interface CustomAnnotation { }

@CustomAnnotation
public class AnnoationExample {
    public static void main(String[] args) {

    }
}
