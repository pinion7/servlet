package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// 롬복세팅하면 아래 두개 데코레이션만으로 게터세터가 자동생성된 상태라 보면됨
@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
