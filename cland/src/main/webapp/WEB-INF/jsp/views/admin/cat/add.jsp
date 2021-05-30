<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
		  <div class="col-md-10">
		  		
				<form id="formAddCat" action="${pageContext.request.contextPath}/admin/cat/add" method="POST">
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm danh mục</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
				  			<c:if test="${not empty msg1 }">
				  				<p>${msg1}</p>
				  			</c:if>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="cname">Tên danh mục</label>
											<input type="text" name="cname" class="form-control" placeholder="Nhập tên danh mục">
											<form:errors path="cat.cname" cssClass="err"/>
										</div>
										
									</div>

									<div class="col-sm-6"></div>

								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		</form>
		  </div><!-- /.col-md-10 -->
		