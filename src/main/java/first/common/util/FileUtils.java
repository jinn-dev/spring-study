package first.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "C:\\03.dev\\file\\";

	public List<Map<String, Object>> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		//클라이언트에서 전송된 파일 정보를 담아서 반환해줄 List 객체
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
	
		Map<String, Object> listMap = null;
		String boardIdx = (String) map.get("IDX");
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				
				//파일의 정보를 받아 새로운 이름으로 변경한다.
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				file = new File(filePath + storedFileName);
				
				//서버에 실제 파일을 저장한다.
				multipartFile.transferTo(file);
				
				//파일 정보를 List 객체에 추가한다.
				listMap = new HashMap<String, Object>();
				listMap.put("BOARD_IDX", boardIdx);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
}
