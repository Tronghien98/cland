<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/upload" var="urlUpload"/>
					<div class="clearfix content">
					<c:choose>
						<c:when test="${not empty listLand && not empty cat}">
						<div class="content_title"><h2>${cat.cname}</h2></div>
						<div class="clearfix single_work_container">
						<c:forEach items="${listLand}" var="land">
							
								<div class="clearfix single_work">
								<c:choose>
									<c:when test="${not empty land.picture}">
										<img class="img_top" src="${urlUpload}/${land.picture}" alt=""/>
									</c:when>
									<c:otherwise>
										<img src="${contextPath}/images/no_images.jpg" alt=""/>
									</c:otherwise>
								</c:choose>
									
									<img class="img_bottom" src="${contextPath}/images/work_bg2.png" alt=""/>
									<h2>${land.lname}</h2>
									<a href="${pageContext.request.contextPath}/single/${land.id}"><p class="caption">${land.description}</p></a>
								</div>
							
						</c:forEach>
						</div>
						</c:when>
						<c:otherwise>
							<div class="alert alert-danger">
							  <strong>Lỗi!</strong> Không có bài viết nào để hiển thị!
							</div>
						</c:otherwise>
					</c:choose>
							<div class="clearfix work_pagination">
								<nav>
								<c:if test="${curPage > 1}">
									<a class="newer floatleft" href="${pageContext.request.contextPath}/cat/${cat.cid}/page=${curPage - 1}"> < -- Trang trước</a>
								</c:if>
								<c:if test="${curPage < totalPage}">
									<a class="older floatright" href="${pageContext.request.contextPath}/cat/${cat.cid}/page=${curPage + 1}">Trang kế -- ></a>
								</c:if>
									
								</nav>
							</div>

						</div>
				