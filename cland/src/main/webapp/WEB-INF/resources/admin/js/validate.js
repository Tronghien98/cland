$(document).ready(function() {

	$("#formSearch").validate({
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
	
	$("#formAddCat").validate({
		rules: {
			cname: {
				required: true,
				minlength: 2,
			},
		},
		messages: {
			cname: {
				required: "Vui lòng nhập tên danh mục",
				minlength: "Tên danh mục phải có ít nhất 2 kí tự",
			},
		}
	});
	
	
	$("#formUpdateCat").validate({
		rules: {
			cname: {
				required: true,
				minlength: 2,
			},
		},
		messages: {
			cname: {
				required: "Vui lòng nhập tên danh mục",
				minlength: "Tên danh mục phải có ít nhất 2 kí tự",
			},
		},
	});
	
	
	$("#formAddLand").validate({
		rules: {
			lname: {
				required: true,
				minlength: 6,
				maxlength: 200,
			},
			catId: {
				required: true,
			},
			file: {
				required: true,
			},
			area: {
				required: true,
				number: true,
			},
			address: {
				required: true,
				minlength: 6,
				maxlength: 200,
			},
			description: {
				required: true,
			},
			detail: {
				required: true,
			}
		},
		messages: {
			lname: {
				required: "Vui lòng nhập tên tin tức!",
				minlength: "Tên danh mục phải có ít nhất 6 kí tự!",
				maxlength: "Tên danh mục nhiều nhất 200 kí tự!",
			},
			catId: {
				required: "Bạn phải chọn danh mục!"
			},
			file: {
				required: "Bạn chưa chọn file nào!",
			},
			area: {
				required: "Vui lòng nhập tên danh mục!",
				number: "Bạn phải nhập vào số!",
			},
			address: {
				required: "Vui lòng nhập địa chỉ!",
				minlength: "Tên danh mục phải có ít nhất 6 kí tự!",
				maxlength: "Tên danh mục nhiều nhất 200 kí tự!",
			},
			description: {
				required: "Bạn phải nhập nội dung mô tả!",
			},
			detail: {
				required: "Bạn phải nhập nội dung chi tiết!",
			}
		}
	});
	
	$("#formUpdateLand").validate({
		rules: {
			lname: {
				required: true,
				minlength: 6,
				maxlength: 200,
			},
			catId: {
				required: true,
			},
			
			area: {
				required: true,
				number: true,
			},
			address: {
				required: true,
				minlength: 6,
				maxlength: 200,
			},
			description: {
				required: true,
			},
			detail: {
				required: true,
			}
		},
		messages: {
			lname: {
				required: "Vui lòng nhập tên danh mục!",
				minlength: "Tên danh mục phải có ít nhất 6 kí tự!",
				maxlength: "Tên danh mục nhiều nhất 200 kí tự!",
			},
			catId: {
				required: "Bạn phải chọn danh mục!"
			},
			
			area: {
				required: "Vui lòng nhập tên danh mục!",
				number: "Bạn phải nhập vào số!",
			},
			address: {
				required: "Vui lòng nhập địa chỉ!",
				minlength: "Tên danh mục phải có ít nhất 6 kí tự!",
				maxlength: "Tên danh mục nhiều nhất 200 kí tự!",
			},
			description: {
				required: "Bạn phải nhập nội dung mô tả!",
			},
			detail: {
				required: "Bạn phải nhập nội dung chi tiết!",
			}
		}
	});
	
	
	$("#formAddUser").validate({
		rules: {
			username: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			fullname: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			roleId:{
				required: true,
			},
			password: {
				required: true,
				minlength: 8,
			},
			repassword: {
				required: true,
				equalTo: "#password",
			}
		},
		messages: {
			username: {
				required: "Tên người dùng không được bỏ trống!",
				minlength:"Tên người dùng tối thiểu 6 kí tự!",
				maxlength: "Tên người dùng tối đa 100 kí tự!",
			},
			fullname: {
				required: "Tên đầy đủ không được để trống!",
				minlength: "Tên đầy đủ tối thiểu 6 kí tự!",
				maxlength: "Tên đầy đủ tối đa 100 kí tự!",
			},
			roleId:{
				required: "Quyền truy cập của tài khoản không được để trống!",
			},
			password: {
				required: "Mật khẩu không được để trống!",
				minlength: "Mật khẩu tối thiểu phải có 8 kí tự!",
			},
			repassword: {
				required: "Cần xác nhận lại mật khẩu!",
				equalTo: "Cần nhập đúng lại mật khẩu bạn đã nhập trước đó!",
			}
		}
	});
	
	
	$("#formUpdateUser").validate({
		rules: {
			username: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			fullname: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			roleId:{
				required: true,
			},
			repassword: {
				equalTo: "#password",
			}		
		},
		messages: {
			username: {
				required: "Tên người dùng không được bỏ trống!",
				minlength:"Tên người dùng tối thiểu 6 kí tự!",
				maxlength: "Tên người dùng tối đa 100 kí tự!",
			},
			fullname: {
				required: "Tên đầy đủ không được để trống!",
				minlength: "Tên đầy đủ tối thiểu 6 kí tự!",
				maxlength: "Tên đầy đủ tối đa 100 kí tự!",
			},
			roleId:{
				required: "Quyền truy cập của tài khoản không được để trống!",
			},
			repassword: {
				equalTo: "Cần nhập đúng lại mật khẩu bạn đã nhập trước đó!",
			}
		}
	});
	
	$("#formUpdateProfile").validate({
		rules: {
			username: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			fullname: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			
			password: {
				required: true,
				minlength: 8,
			},
			repassword: {
				required: true,
				equalTo: "#password",
			}
		},
		messages: {
			username: {
				required: "Tên người dùng không được bỏ trống!",
				minlength:"Tên người dùng tối thiểu 6 kí tự!",
				maxlength: "Tên người dùng tối đa 100 kí tự!",
			},
			fullname: {
				required: "Tên đầy đủ không được để trống!",
				minlength: "Tên đầy đủ tối thiểu 6 kí tự!",
				maxlength: "Tên đầy đủ tối đa 100 kí tự!",
			},
			
			password: {
				required: "Mật khẩu không được để trống!",
				minlength: "Mật khẩu tối thiểu phải có 8 kí tự!",
			},
			repassword: {
				required: "Cần xác nhận lại mật khẩu!",
				equalTo: "Cần nhập đúng lại mật khẩu bạn đã nhập trước đó!",
			}
		}
	});
	$("#formSignup").validate({
		rules: {
			username: {
				required: true,
			},
			fullname: {
				required: true,
				minlength: 6,
				maxlength: 100,
			},
			password: {
				required: true,
				minlength: 8,
			},
			repassword: {
				required: true,
				equalTo: "#password",
			}
		},
		messages: {
			username: {
				required: "Tên người dùng không được bỏ trống!",
				minlength:"Tên người dùng tối thiểu 6 kí tự!",
				maxlength: "Tên người dùng tối đa 100 kí tự!",
			},
			fullname: {
				required: "Tên đầy đủ không được để trống!",
				minlength: "Tên đầy đủ tối thiểu 6 kí tự!",
				maxlength: "Tên đầy đủ tối đa 100 kí tự!",
			},
			
			password: {
				required: "Mật khẩu không được để trống!",
				minlength: "Mật khẩu tối thiểu phải có 8 kí tự!",
			},
			repassword: {
				required: "Cần xác nhận lại mật khẩu!",
				equalTo: "Cần nhập đúng lại mật khẩu bạn đã nhập trước đó!",
			}
		}
	});
	
	$("#formLogin").validate({
		rules: {
			username: {
				required: true,
			},
			password: {
				required: true,
			}
		},
		messages: {
			username: {
				required: "Vui lòng nhập tên đăng nhập!",
			},
			password: {
				required: "Vui lòng nhập mật khẩu",
			}
		}
	});
});