<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/board/include-header.jsp"%>
</head>
<body>
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%" />
				<col width="*" />
			</colgroup>
			<h2>게시글 작성</h2>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3"><input type="text" id="TITLE" name="TITLE"
						class="wdp_90" value="${map.TITLE }" /></td>
				</tr>
				<tr>
					<td colspan="4" class="view_text"><textarea rows="20"
							cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS }</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="file" name="file"><br><br>
		<a href="#this" class="btn" id="list">목록으로</a>
		<a href="#this" class="btn" id="write">저장하기</a>	
	</form>

	<%@ include file="/WEB-INF/views/board/include-body.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#list").on("click", function(e) {
				e.preventDefault();
				fn_openBoardList();
			});
			$("#write").on("click", function(e) {
				e.preventDefault();
				fn_insertBoard();
			});
		});
		function fn_openBoardList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/list' />");
			comSubmit.submit();
		}
		function fn_insertBoard() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/board/insert' />");
			comSubmit.submit();
		}
	</script>
</body>
</html>
