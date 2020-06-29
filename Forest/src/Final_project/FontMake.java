package Final_project;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontMake {
	
	public void fontChange(GraphicsEnvironment ge) {
		String path = "C:\\Users\\SMHRD\\AppData\\Local\\Microsoft\\Windows\\Fonts\\NanumBarunGothic.ttf";
		// ���κп� �ʿ��Ͻ� ��Ʈ�� �ּҸ� �ٲٸ鼭 ����ϸ� ��
		
		try {
			Font recipe = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(12f);
			
			ge.registerFont(recipe);
			// ������ ������ ��Ʈ�� ����־����ϴ�.
		
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
