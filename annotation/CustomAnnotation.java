package codeStates.annotation;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ FIELD, TYPE, TYPE_USE}) //적용 대상이 FIELD, TYPE
public @interface CustomAnnotation { } //새로운 어노테이션 정의

//@Documented
@CustomAnnotation //적용 대상이 TYPE인 경우
class Main{
    @CustomAnnotation //적용 대상이 FIELD인 경우
    int i;
}
