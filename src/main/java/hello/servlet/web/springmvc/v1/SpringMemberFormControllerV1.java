package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* @Controller 사용하지 않는 다른 방법 1
@Component // 해당 클래스를 스캔하여 자동으로 Bean에 등록해주는 역할 (@Controller안에는 애초에 들어있어서 안써도 되는 것)
@RequestMapping
 */

/* @Controller 사용하지 않는 다른 방법 2
@RequestMapping -> 이것만 넣고 컴포넌트 스캔을 안쓰는 것임.

그럼 아래 처럼 직접 빈에 해당 클래스를 등록해주면 됨.
@Bean
SpringMemberFormControllerV1 springMemberFormControllerV1 {
    return new SpringMemberFormControllerV1();
}
 */

// 하지만 이 방식이 젤 편하고 좋지!
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        System.out.println("SpringMemberFormControllerV1.process");
        return new ModelAndView("new-form");
    }
}
