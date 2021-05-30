<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			            <form id="formLogin" action="${pageContext.request.contextPath}/auth/login" method="post">
			            	<img width="100px" height="100px" class="img-circle" src="${adminContextPath}/images/icon-180x180.png">
			                <h6>Đăng nhập</h6>
			            	
			                <div class="form-group">
			                	<label class="text-left pull-left" for="username">Tên đăng nhập: </label>
			               		<input class="form-control" type="text" name="username" placeholder="Username">
			                </div>
			                
			                <div class="form-group">
			                	<label class="text-left pull-left" for="password">Mật khẩu:</label>
			                	<input class="form-control" type="password" name="password" placeholder="Password">
			                </div>
			                
			                <div class="action">
			                    <input class="btn btn-primary signup btn-block" type="submit" value="Login" />
			                </div>   
			               </form>             
			            </div>
			        </div>

			        <div class="already">
			            <p>Don't have an account yet?</p>
			            <a href="${pageContext.request.contextPath}/auth/signup">Sign Up</a>
			        </div>
			    </div>
			</div>
		</div>
	</div>
