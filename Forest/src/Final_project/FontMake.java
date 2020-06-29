package Final_project;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontMake {
	
	public void fontChange(GraphicsEnvironment ge) {
		String path = "C:\\Users\\SMHRD\\AppData\\Local\\Microsoft\\Windows\\Fonts\\NanumBarunGothic.ttf";
		// 윗부분에 필요하신 폰트의 주소를 바꾸면서 사용하면 됨
		
		try {
			Font recipe = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(12f);
			
			ge.registerFont(recipe);
			// 위에서 생성한 폰트를 집어넣었습니다.
		
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
