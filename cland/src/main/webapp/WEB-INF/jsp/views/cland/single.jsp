<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<c:url value="/resources/upload" var="urlUpload"/>
<div class="clearfix content">
		<c:if test="${not empty msg }">
			<p>${msg}</p>
		</c:if>
		<c:choose>
			<c:when test="${not empty land}">
			<h1>${land.lname}</h1>
			<div class="clearfix post-meta">
				<p>
					<span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span> 
					<span><i class="fa fa-folder"></i> Diện tích: ${land.area}m2</span>
				</p>
			</div>
						
			<div class="vnecontent">
				<p>${land.detail}</p>
			</div>
						
			<a class="btn" href="${pageContext.request.contextPath}/single/${land.id - 1}">Bài trước</a>
			<a class="btn" href="${pageContext.request.contextPath}/single/${land.id + 1}">Bài kế</a>
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning">
				  <strong>Lỗi!</strong> Không có bài viết nào để hiển thị!
				</div>
			</c:otherwise>
		</c:choose>	
</div>
					
						<div class="more_themes">
						<c:choose>
							<c:when test="${not empty listLandOfCat}">
								<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
								<div class="more_themes_container">
								<c:forEach items="${listLandOfCat}" var="landOfCat">
								<div class="single_more_themes floatleft">
									<c:choose>
										<c:when test="${not empty landOfCat.picture}">
											<img src="${urlUpload}/${landOfCat.picture}" alt=""/>
										</c:when>
										<c:otherwise>
											<img src="${contextPath}/images/no_images.jpg" alt=""/>
										</c:otherwise>
									</c:choose>
									
									<a href="${pageContext.request.contextPath}/single/${landOfCat.id}">
										<h2>${landOfCat.lname}</h2>
									</a>
								</div>
								</c:forEach>
								
							</div>
							</c:when>
							<c:otherwise>
								<div class="alert alert-info">
									 Danh mục này không có bài viết nào!
								</div>
							</c:otherwise>
						</c:choose>
						</div>