<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<div class="clearfix sidebar">
						<div class="clearfix single_sidebar category_items">
							<h2>Danh mục bất động sản</h2>
							<c:choose>
								<c:when test="${not empty listCatDTO}">
							<ul>
								<c:forEach items="${listCatDTO}" var="catDTO">
									<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${catDTO.cid}">${catDTO.cname}</a>(${catDTO.totalPost})</li>
								</c:forEach>
							</ul>
								</c:when>
								<c:otherwise>
									<div class="alert alert-warning" role="alert">
									  Không có danh mục nào!
									</div>
								</c:otherwise>
							</c:choose>
						</div>

						<div class="clearfix single_sidebar">
							<div class="popular_post">
							<div class="sidebar_title"><h2>Xem nhiều</h2></div>
								<c:choose>
									<c:when test="${not empty listLandMostView}">
									<ul>
										<c:forEach items="${listLandMostView}" var="land">
											<li><a href="${pageContext.request.contextPath}/single/${land.id}">${land.lname}</a></li>
										</c:forEach>
									</ul>
									</c:when>
									<c:otherwise>
										<div class="alert alert-warning" role="alert">
										  Không có bài viết nào!
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							</div>
						
						<div class="clearfix single_sidebar">
							<h2>Danh mục hot</h2>
							<c:choose>
								<c:when test="${not empty listHotCat}">
								<ul>
									<c:forEach items="${listHotCat}" var="catHot">
										<li><a href="${pageContext.request.contextPath}/catHot/${catHot.cid}">${catHot.cname}<span>(${catHot.totalPost})</span></a></li>
									</c:forEach>
								</ul>
								</c:when>
								<c:otherwise>
									<p>Không có danh mục nào!</p>
								</c:otherwise>
							</c:choose>
						</div>
					</div>