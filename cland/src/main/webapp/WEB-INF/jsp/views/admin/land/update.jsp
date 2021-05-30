<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
	<c:if test="${not empty land}">
		  <div class="col-md-10">
				<form id="formUpdateLand" action="${pageContext.request.contextPath}/admin/land/update/${land.id}" method="POST" enctype="multipart/form-data">
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa tin tức</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
									
										<div class="form-group">
											<label for="lname">Tên tin tức</label>
											<input type="text" name="lname" class="form-control" value="${land.lname}">
										</div>
										<select name="catId" class="form-group">
										<option value="">--Danh mục--</option>
										<c:choose>
											<c:when test="${not empty listCat}">
												<c:forEach items="${listCat}" var="cat">
													<c:choose>
														<c:when test="${cat.cid == land.cat.cid}">
															<option value="${cat.cid}" selected="selected">${cat.cname}</option>
														</c:when>
														<c:otherwise>
															<option value="${cat.cid}">${cat.cname}</option>
														</c:otherwise>
													</c:choose>
												
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
											<input type="text" name="area" class="form-control" value="${land.area}">
									</div>
									<div class="form-group">
											<label for="address">Địa chỉ</label>
											<input type="text" name="address" class="form-control" value="${land.address}">
									</div>
									<div class="form-group">
											<label for="description">Mô tả</label> <br />
											<input type="text" name="description" class="form-control" value="${land.description}">
									</div>
									<div class="form-group">
											<label for="detail">Chi tiết</label> <br />
											<textarea rows="5" cols="80" name="detail">${land.detail}</textarea>
									</div>
															
									</div>
									<div class="col-sm-6"></div>

								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Cập nhật" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		</form>
		  </div><!-- /.col-md-10 -->
			</c:if>		