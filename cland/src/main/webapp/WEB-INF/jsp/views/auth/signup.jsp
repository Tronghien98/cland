<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>

<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			            <form id="formSignup" action="${pageContext.request.contextPath}/auth/signup" method="POST">
			            	<img width="100px" height="100px" class="img-circle" src="${adminContextPath}/images/icon-180x180.png">
			                <h6>Đăng ký</h6>
			            	
			                <div class="form-group">
			                	<label class="text-left pull-left" for="username">Tên đăng nhập: </label>
			               		<input class="form-control" type="text" name="username" placeholder="Username">
			               		<form:errors path="user.username" cssClass="err"/>
			                </div>
			                 <div class="form-group">
			                	<label class="text-left pull-left" for="fullname">Tên đầy đủ: </label>
			               		<input class="form-control" type="text" name="fullname" placeholder="Fullname">
			               		<form:errors path="user.fullname" cssClass="err"/>
			                </div>
			                
			                <div class="form-group">
			                	<label class="text-left pull-left" for="password">Mật khẩu:</label>
			                	<input class="form-control" type="password" name="password" placeholder="Password">
			                	<form:errors path="user.password" cssClass="err"/>
			                </div>
			                <div class="form-group">
			                	<label class="text-left pull-left" for="repassword">Mật khẩu:</label>
			                	<input class="form-control" type="password" id="password" name="repassword" placeholder="Confirm Password">
			                </div>
			                
			                <div class="action">
			                    <input class="btn btn-primary signup btn-block" type="submit" value="ĐĂNG KÝ" />
			                </div>   
			               </form>             
			            </div>
			        </div>

			        
			    </div>
			</div>
		</div>
	</div>
