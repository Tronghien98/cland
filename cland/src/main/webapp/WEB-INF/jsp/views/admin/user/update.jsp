<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
		  <div class="col-md-10">
				<c:if test="${not empty user}">
				<form id="formUpdateUser" action="${pageContext.request.contextPath}/admin/user/update/id=${user.id}" method="POST">
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa người dùng</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								<c:if test="${not empty msg}">
									<div class="alert alert-danger" role="alert">
									  ${msg}
									</div>
								</c:if>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="username">Tên người dùng</label>
											<input type="text" name="username" class="form-control" value="${user.username }">
											<c:if test="${not empty errEqual}">
												<label class="error" for="username">Tên người dùng đã tồn tại!</label>
											</c:if>
											<form:errors path="user.username" cssClass="err"/>
										</div>
										<div class="form-group">
										
											<label for="fullname">Tên đầy đủ</label>
											<input type="text" name="fullname" class="form-control" value="${user.fullname}">
											<form:errors path="user.fullname" cssClass="err"/>
										</div>
										
										<div class="form-group">
											<label for="password">Password</label>
											<input type="password" id="password" name="password" class="form-control" placeholder="Nhập password">
											<form:errors path="user.password" cssClass="err"/>
										</div>
										<div class="form-group">
											<label for="password">Repassword</label>
											<input type="password" name="repassword" class="form-control" placeholder="Nhập lại password">
										</div>
										
									</div>

									<div class="col-sm-6"></div>

								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Sửa" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>
								
							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		</form>
	  		</c:if>
		  </div><!-- /.col-md-10 -->
		