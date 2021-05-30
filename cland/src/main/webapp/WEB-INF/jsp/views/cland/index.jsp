	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/upload" var="urlUpload"/>
					<div class="clearfix slider">
						<ul class="pgwSlider">
							<li><img src="${contextPath}/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="${contextPath}/images/slides/megamind_07.jpg"/></li>
							<li><img src="${contextPath}/images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="${contextPath}/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars"/></li>
							<li>
								<img src="${contextPath}/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="${contextPath}/images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
							</li>


						</ul>
					</div>
					<div class="clearfix content">
						<div class="content_title"><h2>Bài viết mới</h2></div>
					<c:choose>
						<c:when test="${not empty listLand}">
						<c:forEach items="${listLand}" var="land">
						<div class="clearfix single_content">
							<div class="clearfix post_date floatleft">
								<div class="date">
									<h3><fmt:formatDate pattern = "dd/MM" value = "${land.dateUpdate}" /></h3>
									<p><fmt:formatDate pattern = "yyyy" value = "${land.dateUpdate}" /></p>
								</div>
							</div>
							<div class="clearfix post_detail">
								<h2><a href="">${land.lname}</a></h2>
								<div class="clearfix post-meta">
									<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${land.area}m2</span></p>
								</div>
								<div class="clearfix post_excerpt">
								<c:choose>
									<c:when test="${not empty land.picture}">
										<img src="${urlUpload}/${land.picture}" alt=""/>
									</c:when>
									<c:otherwise>
										<img src="${contextPath}/images/no_images.jpg" alt=""/>
									</c:otherwise>
								</c:choose>
									
									<p>${land.description} </p>
								</div>
								<a href="${pageContext.request.contextPath}/single/${land.id}">Đọc thêm</a>
							</div>
						</div>
						</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="alert alert-dark" role="alert">
							 Không có bài viết mới nào!!
							</div>
						</c:otherwise>
					</c:choose>						
					</div>
					<c:choose>
						<c:when test="${not empty searchLand}">
						<c:if test="${not empty totalPage && not empty curPage}">
					<c:if test="${totalPage > 1}">
						<div class="pagination">
						<nav>
							<ul>
							<c:if test="${curPage > 1}">
								<li><a href="${pageContext.request.contextPath}/search?ql=${searchLand}"> << </a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:choose>
									<c:when test="${curPage == i}">
										<li><a href="#">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/search/${i}?ql=${searchLand}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${curPage < totalPage}">
								<li><a href="${pageContext.request.contextPath}/search/${totalPage}?ql=${searchLand}"> >> </a></li>
							</c:if>
								
							</ul>
						</nav>
					</div>
					</c:if>
					</c:if>
						</c:when>
						<c:otherwise>
						<c:if test="${not empty totalPage && not empty curPage}">
					<c:if test="${totalPage > 1}">
						<div class="pagination">
						<nav>
							<ul>
							<c:if test="${curPage > 1}">
								<li><a href="${pageContext.request.contextPath}"> << </a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:choose>
									<c:when test="${curPage == i}">
										<li><a href="">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/${i}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${curPage < totalPage}">
								<li><a href="${pageContext.request.contextPath}/${totalPage}"> >> </a></li>
							</c:if>
								
							</ul>
						</nav>
					</div>
					</c:if>
					</c:if>
						</c:otherwise>
					</c:choose>
					
					