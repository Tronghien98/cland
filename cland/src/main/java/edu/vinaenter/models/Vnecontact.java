package edu.vinaenter.models;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vnecontact {
	private int cid;
	
	@NotBlank(message = "Vui lòng nhập tên người liên hệ")
	private String fullname;
	
	@NotBlank(message = "Vui lòng nhập email!")
	private String email;
	
	@NotBlank(message = "Vui lòng nhập subject")
	private String subject;
	
	@NotBlank(message = "Vui lòng nhập nội dung")
	private String content;
}
