package edu.vinaenter.models;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Lands {
	private int id;
	
	@NotBlank(message = "Vui lòng nhập tên bài viết!")
	@Size(min = 6, max = 200)
	private String lname;
	
	@NotBlank(message = "Vui lòng nhập mô tả!")
	private String description;
	
	@NotBlank(message = "Vui lòng nhập chi tiết!")
	private String detail;
	private Date dateCreate;
	private Date dateUpdate;
	private Categories cat;
	private String picture;
	
	@NotNull
	private Integer area;
	
	@NotBlank(message = "Vui lòng nhập địa chỉ!")
	private String address;
	private int countView;
}
