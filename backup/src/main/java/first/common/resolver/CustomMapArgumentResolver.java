package first.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import first.common.CommandMap;

/**
 * 
 * @author JEKWAK
 * 컨트롤러에 들어오는 파라미터를 수정하거나 공통적으로 추가 해주어야 하는 경우
 * 세션에 담아놓고 사용하는데 DB에 그러한 정보를 입력할 때 세션에서 값을 꺼내와서 파라미터로 추가해야 한다.
 * 사용자 요청이 컨트롤러에 도달하기 전에 그 요청의 파라미터들을 수정할 수 있도록 해준다.
 */
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	/*
	 * Resolver가 적용 가능한지 검사하는 역할. true를 반환하면 resolveArgument 메소드가 수행된다.
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}

	/*
	 * 파라미터와 기타 정보를 받아서 실제 객체를 반환하는 역할 
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null) {
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		return commandMap;
	}

}
