package first.common.util;

import java.util.UUID;

public class CommonUtils {
	
	/*
	 * 32글자의 랜덤한 문자열을 만들어서 반환해주는 기능
	 */
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
