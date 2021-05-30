<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
<c:url value="/resources/upload" var="urlUpload"/>
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý truyện</div>
		  			</div>
				</div>
				<c:if test="${not empty msg}">
					<div class="alert alert-secondary" role="alert">
					  ${msg}
					</div>
				</c:if>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/land/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                	<form id="formSearch" action="${pageContext.request.contextPath}/admin/land/search" method="GET">
                 	 <div class="input-group form">
	                 	 
	                       <input type="text" class="form-control" name="ql" placeholder="Search...">
	                       
	                       <span class="input-group-btn">
	                         <input class="btn btn-primary" type="submit" value="Search">
	                       </span>
	                     	
                  	 </div>
                  	 		<c:if test="${not empty err}">
	                       	<label id="ql-error" class="error" for="ql">${err}</label>
	                       </c:if>
                  	 </form>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
  					
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Danh mục</th>
								<th>Ngày đăng</th>
								<th width="400px">Mô tả</th>
								<th>Lượt đọc</th>
								<th width="300px">Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>
					<c:choose>
  					<c:when test="${not empty landList }">
  					
						<tbody>
						<c:forEach items="${landList}" var="land">
						
							<tr class="odd gradeX">
								<td>${land.id}</td>
								<td>${land.lname}</td>
								<td>${land.cat.cname}</td>
								<td width="400px">${land.dateCreate}</td>
								<td>${land.description}</td>
								<td class="center">${land.countView}</td>
								<td class="center text-center" width="300px">
									<c:choose>
										<c:when test="${not empty land.picture}">
											<img width="300px" height="300px"  src="${urlUpload}/${land.picture}" />
										</c:when>
										<c:otherwise>
											<img width="300px" height="300px"  src="${adminContextPath}/images/no_images.jpg" />
										</c:otherwise>
									</c:choose>
									
									
								</td>
								<td class="center text-center">
									<a href="${pageContext.request.contextPath}/admin/land/update/${land.id}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="${pageContext.request.contextPath}/admin/land/del/${land.id}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
							
						</c:forEach>
							
						</tbody>
						</c:when>
						<c:otherwise>
							<td class="center text-center" colspan="8">
									Không có dữ liệu để hiển thị!
							</td>
						</c:otherwise>
						</c:choose>
					</table>

					<!-- Pagination -->
					<c:if test="${not empty totalPage }">
						<c:if test="${not empty curPage}">
							<c:if test="${totalPage > 1}">
							<nav class="text-center" aria-label="...">
							   <ul class="pagination">
							   	<c:if test="${curPage > 1}">
							   		<li><a href="${pageContext.request.contextPath}/admin/land/index" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							   	</c:if>
							   	<c:forEach var="i" begin="1" end="${totalPage}">
							   		<c:choose>
							   			<c:when test="${curPage == i}">
							   			 <li class="active"><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i} <span class="sr-only">(current)</span></a></li>
							   			</c:when>
							   			<c:otherwise>
							   			<li><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i}</a></li>
							   			</c:otherwise>
							   		</c:choose>
							   	</c:forEach>
							    <c:if test="${curPage < totalPage}">
							    	<li><a href="${pageContext.request.contextPath}/admin/land/index/${totalPage}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
							    </c:if>
							   </ul>
							</nav>
							</c:if>
						</c:if>
					</c:if>
					
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>