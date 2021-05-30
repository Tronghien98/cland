$(document).ready(function() {	
		$("#formContact").validate({
		rules: {
			fullname: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			email:{
				required: true,
				email: true,
			},
			subject: {
				required: true,
				minlength: 8,
			},
			content: {
				required: true,
			}
		},
		messages: {
			fullname: {
				required: "Tên đầy đủ không được để trống!",
				minlength: "Tên đầy đủ tối thiểu 6 kí tự!",
				maxlength: "Tên đầy đủ tối đa 100 kí tự!",
			},
			email:{
				required: "Email không được để trống!",
				email: "Nhập vào định dạng email!",
			},
			subject: {
				required: "subject không được để trống!",
				minlength: "subject tối thiểu phải có 8 kí tự!",
			},
			content: {
				required: "Nội dung không được để trống!",
			}
		}
	});
	
	$("#searchCland").validate({
		rules: {
			ql: {
				required: true,
			},
		},
		messages: {
			ql: {
				required: "Vui lòng nhập nội dung tìm kiếm!!",
			},
		}
	});
	
});