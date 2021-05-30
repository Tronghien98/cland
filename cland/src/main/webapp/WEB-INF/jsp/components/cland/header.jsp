<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.html"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form id="searchCland" action="${pageContext.request.contextPath}/search" method="get">
							<input type="text" name="ql" placeholder="Search"/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
							<li id="dropdown"><a href="#">Bất động sản</a>
							<c:if test="${not empty listCat}">
							<ul>
								<c:forEach items="${listCat}" var="cat">
									<li><a href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname}</a></li>
								</c:forEach>
							</ul>
							</c:if>
							</li>
							<li><a href="${pageContext.request.contextPath}/single">Giới thiệu</a></li>
							<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>