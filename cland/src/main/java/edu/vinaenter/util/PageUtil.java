package edu.vinaenter.util;

public class PageUtil {
	public static int getOffset(Integer page, int totalRow) {
		return (page - 1) * totalRow;
	}
	
	public static int numberPage(int totalPage, int totalRow) {
		return (int) Math.ceil((double) totalPage/totalRow);
	}
}
