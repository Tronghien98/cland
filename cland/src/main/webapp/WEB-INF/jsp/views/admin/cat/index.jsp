<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý danh mục</div>
		  			</div>
				</div>
				<hr>
				<c:if test="${not empty msg}">
				<div class="alert alert-success" role="alert">
				  ${msg}
				</div>
				</c:if>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/cat/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty catList}">
								<c:forEach items="${catList}" var="cat">
							<tr class="odd gradeX">
								<td>${cat.cid}</td>
								<td>${cat.cname}</td>
								<td class="center text-center">
									<a href="${pageContext.request.contextPath}/admin/cat/update/id=${cat.cid}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="${pageContext.request.contextPath}/admin/cat/del/id=${cat.cid}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">Không có dữ liệu để hiển thị</td>
								</tr>
							</c:otherwise>
							</c:choose>
						</tbody>
					</table>
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>