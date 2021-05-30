<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
		  <div class="col-md-10">
				<form id="formAddLand" action="${pageContext.request.contextPath}/admin/land/add" method="POST" enctype="multipart/form-data">
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm tin tức</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="lname">Tên tin tức</label>
											<input type="text" name="lname" class="form-control" placeholder="Nhập tên tin tức">
											<form:errors path="land.lname" cssClass="err"/>
										</div>
										<select name="catId" class="form-group">
										<option value="">--Danh mục--</option>
										
										<c:choose>
											<c:when test="${not empty listCat}">
												<c:forEach items="${listCat}" var="cat">
												<option value="${cat.cid}">${cat.cname}</option>
											</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="">Danh sách danh mục rỗng</option>
											</c:otherwise>
										</c:choose>
										</select>
									<div class="form-group">
										<label for="file">Hình ảnh</label>
										<input type="file" name="file" value="Hình ảnh">
										
									</div>
									<div class="form-group">
											<label for="area">Diện tích</label>
											<input type="text" name="area" class="form-control" placeholder="Nhập diện tích">
											<form:errors path="land.area" cssClass="err"/>
									</div>
									<div class="form-group">
											<label for="address">Địa chỉ</label>
											<input type="text" name="address" class="form-control" placeholder="Nhập địa chỉ">
											<form:errors path="land.address" cssClass="err"/>
									</div>
									<div class="form-group">
											<label for="description">Mô tả</label> <br />
											<input type="text" name="description" class="form-control" placeholder="Nhập mô tả">
											<form:errors path="land.description" cssClass="err"/>
									</div>
									<div class="form-group">
											<label for="detail">Chi tiết</label> <br />
											<textarea rows="5" cols="80" name="detail" placeholder="Nhập thông tin chi tiết"></textarea>
											<form:errors path="land.detail" cssClass="err"/>
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
		