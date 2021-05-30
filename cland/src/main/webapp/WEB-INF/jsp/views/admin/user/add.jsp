<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
		  <div class="col-md-10">
				<form id="formAddUser" action="${pageContext.request.contextPath}/admin/user/add" method="POST">
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm người dùng</div>
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
											<input type="text" name="username" class="form-control" placeholder="Nhập tên người dùng">
											<c:if test="${not empty errEqual}">
												<label class="error" for="username">Tên người dùng đã tồn tại!</label>
											</c:if>
											<form:errors path="user.username" cssClass="err"/>
										</div>
										<div class="form-group">
											<label for="fullname">Tên đầy đủ</label>
											<input type="text" name="fullname" class="form-control" placeholder="Nhập họ và tên đầy đủ của bạn">
											<form:errors path="user.fullname" cssClass="err"/>
										</div>
										
										<select id="roleId" name="roleId" class="form-group">
										<option value="" selected="selected">--Role--</option>
											<c:choose>
												<c:when test="${not empty listRole}">
													<c:forEach items="${listRole}" var="role">
														<option value="${role.id}">${role.name}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<option value="">Không có quyền</option>
												</c:otherwise>
											</c:choose>						
										</select>
										<div class="form-group">
											<label for="password">Password</label>
											<input type="password" id="password" name="password" class="form-control" placeholder="Nhập password">
											<form:errors path="user.password" cssClass="err"/>
										</div>
										<div class="form-group">
											<label for="password">Password</label>
											<input type="password" name="repassword" class="form-control" placeholder="Nhập password">
										</div>
										
									</div>

									<div class="col-sm-6"></div>

								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm người dùng" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		</form>
		  </div><!-- /.col-md-10 -->
		