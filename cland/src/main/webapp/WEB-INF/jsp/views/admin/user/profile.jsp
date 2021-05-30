<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Thông tin người dùng</div>
		  			</div>
				</div>
				<hr>
				<c:choose>
					<c:when test="${not empty user}">
					<div class="row">
  						<div class="panel-body">
	  						<span>
		  						<p><strong>Username: ${user.username}</strong> </p> <br/><br/>
		  						<p><strong>Fullname: ${user.fullname}</strong></p> <br/><br/>
		  						<p>
		  							<strong>
		  								Status: <c:choose>
		  										<c:when test="${user.enable}"> Được kích hoạt </c:when>
		  										<c:otherwise>Không được kích hoạt</c:otherwise>
		  									</c:choose>
		  							</strong>
		  						</p> <br/><br/>
	  						</span>	
  						</div>
  					</div><!-- /.row -->
					</c:when>
				</c:choose>
				
				
				<div class="row">
					<a href="${pageContext.request.contextPath}/admin/user/profile/update/${user.username}" class="btn btn-success">
						Cập nhật thông tin
					</a>
				</div>

				
  			</div><!-- /.content-box-large -->



		  </div>