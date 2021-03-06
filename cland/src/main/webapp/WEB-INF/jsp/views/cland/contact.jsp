<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/components/taglib.jsp" %>
							
						<div class="clearfix content">
							
						<div class="contact_us">
							
							<h1>Liên hệ với chúng tôi</h1>
							
							<p>
							TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
							Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
							Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
							</p>
							<c:if test="${not empty msg}">
								<div class="alert alert-success" role="alert">
								  ${msg}
								</div>
							</c:if>
							<form id="formContact" action="${pageContext.request.contextPath}/contact/add" method="post">
								<p><input type="text" class="wpcf7-text" name="fullname" placeholder="Họ tên *"/>
									<form:errors path="contact.fullname" cssClass="err"/>
								</p>
								<p><input type="text" class="wpcf7-email" name="email" placeholder="Email *"/>
									<form:errors path="contact.email" cssClass="err"/>
								</p>
								<p><input type="text" class="wpcf7-text" name="subject" placeholder="Chủ đề *"/>
									<form:errors path="contact.subject" cssClass="err"/>
								</p>
								<p><textarea class="wpcf7-textarea" name="content" placeholder="Nội dung *"></textarea>
									<form:errors path="contact.content" cssClass="err"/>
								</p>
								<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
							</form>
							
						</div>
						
					</div>