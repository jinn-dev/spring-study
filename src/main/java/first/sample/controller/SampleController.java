package first.sample.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author JEKWAK
 * 클라이언트 요청이 들어오면 비즈니스 로직을 호출해주고, 어떤 주소와 화면을 연결하는 역할을 한다.
 */

@Controller
public class SampleController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/sample/openSampleList.do")
	public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");
		log.debug("인터셉터 테스트");
		return mv;
	}
}
