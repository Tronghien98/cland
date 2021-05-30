package edu.vinaenter.models.DTO;

import edu.vinaenter.models.Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDTO extends Categories {
	private int totalPost;
}
