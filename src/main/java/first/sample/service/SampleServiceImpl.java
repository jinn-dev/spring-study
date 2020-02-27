package first.sample.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import first.common.util.FileUtils;
import first.sample.dao.SampleDAO;

/**
 * 
 * @author JEKWAK Service 인터페이스를 통해 정의된 메서드를 실제로 구현하는 클래스
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name = "sampleDAO")
	private SampleDAO sampleDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		sampleDAO.insertBoard(map);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, request);
		int size = list.size();
		for(int i=0;i<size; i++) {
			sampleDAO.insertFile(list.get((i)));
			
		}
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				log.debug("------------- file start -------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + multipartFile.getOriginalFilename());
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------- file end --------------\n");

			}
		}
	}
	
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		sampleDAO.updateHitCnt(map);
		Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);
		return resultMap;
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
		sampleDAO.updateBoard(map);
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		sampleDAO.deleteBoard(map);
	}

}
