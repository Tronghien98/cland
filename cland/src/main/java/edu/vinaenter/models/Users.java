package edu.vinaenter.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
	private int id;
	
	@NotBlank(message = "Bạn phải nhập tên người dùng!")
	@Size(min = 6, max = 100)
	private String username;
	
	@NotBlank(message = "Bạn phải nhập tên đầy đủ!")
	@Size(min = 6, max = 100)
	private String fullname;
	
	@NotBlank(message = "Bạn phải nhập mật khẩu!")
	@Size(min = 8)
	private String password;
	private boolean enable;
	private Role role;
}
