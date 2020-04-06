<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>게시글 수정</title>
<%@ include file="/WEB-INF/views/board/include-header.jsp"%>
</head>
<body>
	<form id="frm">
		<table class="board_view">
			<colgroup>
				<col width="15%"/>
				<col width="50%"/>
			</colgroup>
			<h2>게시글 수정</h2>
			<tbody>
			<tr>
				<tr>
					<th scope="col">글번호</th>
					<td><input readOnly id="IDX" name="IDX" class="wdp_90" value="${map.IDX }"/></td>
				</tr>
				<tr>
					<th scope="col">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS }</textarea></td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="#this" class="btn" id="list">목록으로</a>
	<a href="#this" class="btn" id="update">저장하기</a>
	<a href="#this" class="btn" id="delete">삭제하기</a>
	<%@ include file="/WEB-INF/views/board/include-body.jsp"%>
	<script type="text/javascript"> 
		$(document).ready(function() {
			$("#list").on("click", function(e) {
				e.preventDefault();
				fn_openBoardList();
			});
			$("#update").on("click", function(e) {
				e.preventDefault();
				fn_updateBoard();
			});
			$("#delete").on("click", function(e) {
				e.preventDefault();
				fn_deleteBoard();
			});
		});
		function fn_openBoardList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/list' />");
			comSubmit.submit();
		}
		function fn_updateBoard() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/board/updated' />");
			comSubmit.submit();
		}
		function fn_deleteBoard() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/delete' />");
			comSubmit.addParam("IDX", $("#IDX").val());
			comSubmit.submit();
		}
	</script>
	
</body>
</html>
