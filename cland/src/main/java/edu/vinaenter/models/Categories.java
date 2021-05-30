package edu.vinaenter.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categories {
	private int cid;
	
	@NotBlank(message = "Tên danh mục không được để trống!")
	@Size(min = 2)
	private String cname;	
}
