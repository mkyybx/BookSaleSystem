package homework7;

import java.util.ArrayList;
import java.util.Collections;

public class _14211278_满柯宇_7_BookType {
	public static final int COMPUTER_NON_TEXTBOOK = 0;
	public static final int TEXTBOOK = 1;
	public static final int COMIC = 2;
	public static final int HEALTH = 3;
	public static final int OTHER = 4;
	
	private static final String[] STRING_NAME = {"非教材计算机类","教材","连环画","养生类","其他类"};
	public static final ArrayList<String> NAME = new ArrayList<String>();
	private static final boolean temp = Collections.addAll(NAME, STRING_NAME);
	
	private _14211278_满柯宇_7_BookType() {
		
	}
}
