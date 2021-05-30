<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<div class="sidebar content-box" style="display: block;">
                <!-- Nav-bar -->
				<ul class="nav">
				    <!-- Main menu -->
				    <li class="current"><a href="${pageContext.request.contextPath}/admin"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
				    <li><a href="${pageContext.request.contextPath}/admin/cat/index"><i class="glyphicon glyphicon-list"></i> Danh mục</a></li>
				    <li><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-book"></i> Truyện</a></li>
				    <li><a href="${pageContext.request.contextPath}/admin/user/index"><i class="glyphicon glyphicon-user"></i> Người dùng</a></li>
				    <li><a href="${pageContext.request.contextPath}/admin/contact/index"><i class="glyphicon glyphicon-envelope"></i> Liên hệ</a></li>
				    <li class="submenu">
				         <a href="#">
				            <i class="glyphicon glyphicon-list"></i> Pages
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				  			<c:choose>
				  				<c:when test="${not empty sessionScope.username}">
				  					<li><a href="${pageContext.request.contextPath}/auth/logout">Logout</a></li>
				  					<li><a href="${pageContext.request.contextPath}/admin/user/profile/${sessionScope.username}">Profile</a></li>
				  				</c:when>
				  				<c:otherwise>
				  					<li><a href="${pageContext.request.contextPath}/auth/logout">Login</a></li>
				  					<li><a href="javascript:void(0)">Signup</a></li>
				  				</c:otherwise>
				  			</c:choose>
				            
				         
				            
				        </ul>
				    </li>
				</ul>
				<!-- /.nav-bar -->
             </div>