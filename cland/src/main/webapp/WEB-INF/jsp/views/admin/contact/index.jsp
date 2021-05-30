<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
    
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý liên hệ</div>
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

					</div>
                	<div class="col-md-4">
                 	 <form id="formSearch" action="${pageContext.request.contextPath}/admin/contact/search" method="GET">
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
								<th>Fullname</th>
								<th>Email</th>
								<th>Subject</th>
								<th width="400px">Content</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty contactList}">
								<c:forEach items="${contactList}" var="contact">
							<tr class="odd gradeX">
								<td>${contact.cid}</td>
								<td>${contact.fullname}</td>
								<td>${contact.email}</td>
								<td>${contact.subject}</td>
								<td width="400px">${contact.content}</td>
								<td class="center text-center">
                                    <a href="${pageContext.request.contextPath}/admin/contact/del/id=${contact.cid}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">Không có dữ liệu để hiển thị</td>
								</tr>
							</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<c:choose>
						<c:when test="${not empty searchContact}">
							<c:if test="${not empty totalPage}">
						<c:if test="${not empty curPage && not empty searchContact}">
							<c:if test="${totalPage > 1}">
							<nav class="text-center" aria-label="...">
							   <ul class="pagination">
							   	<c:if test="${curPage > 1}">
							   		<li><a href="${pageContext.request.contextPath}/admin/contact/search?ql=${searchContact}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							   	</c:if>
							   	<c:forEach var="i" begin="1" end="${totalPage}">
							   		<c:choose>
							   			<c:when test="${curPage == i}">
							   			 <li class="active"><a href="${pageContext.request.contextPath}/admin/contact/search/${i}?ql=${searchContact}">${i} <span class="sr-only">(current)</span></a></li>
							   			</c:when>
							   			<c:otherwise>
							   			<li><a href="${pageContext.request.contextPath}/admin/contact/search/${i}?ql=${searchContact}">${i}</a></li>
							   			</c:otherwise>
							   		</c:choose>
							   	</c:forEach>
							    <c:if test="${curPage < totalPage}">
							    	<li><a href="${pageContext.request.contextPath}/admin/contact/search/${totalPage}?ql=${searchContact}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
							    </c:if>
							   </ul>
							</nav>
							</c:if>
						</c:if>
					</c:if>
						</c:when>
						<c:otherwise>
							<c:if test="${not empty totalPage && totalPage > 1}">
						<c:if test="${not empty curPage }">
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					   <c:if test="${curPage > 1}">
					   		<li><a href="${pageContext.request.contextPath}/admin/contact/index" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					   </c:if>
					   <c:forEach var="i" begin="1" end="${totalPage}">
					   		<c:choose>
					   			<c:when test="${curPage == i}">
					   			<li class="active"><a href="${pageContext.request.contextPath}/admin/contact/index/${i}">${i} <span class="sr-only">(current)</span></a></li>
					   			</c:when>
					   			<c:otherwise>
					   			<li><a href="${pageContext.request.contextPath}/admin/contact/index/${i}">${i}</a></li>
					   			</c:otherwise>
					   		</c:choose>
					   </c:forEach>
					    <c:if test="${curPage < totalPage}">
					    	<li><a href="${pageContext.request.contextPath}/admin/contact/index/${totalPage}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					    </c:if>
					      
					   </ul>
					</nav>
						</c:if>
					</c:if>
						</c:otherwise>
					</c:choose>
					
					<!-- Pagination -->
					
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->
		  </div>
		 