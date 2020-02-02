package ImageSection;

import javax.swing.*;
import java.awt.*;

public class yogurtIcon extends ImageIcon {
	public ImageIcon yogurtImage;
	public ImageIcon plainYogurt;
	public ImageIcon appleYogurt;
	public ImageIcon strawberryYogurt;
	//다른 클래스에서 접근 가능하도록 ImageIcon을 public 처리
	//이 클래스는 yogurt 메뉴에서 사용하는 모든 ImageIcon 변수들을 처리함.
	public yogurtIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Yogurt.png");
		//image 폴더 내의 이미지파일에 접근해서 해당 객체 선언
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image 객체에 해당 이미지파일을 불러와서 크기 조절
		yogurtImage = new ImageIcon(img);
		//조절 된 그림 파일을 ImageIcon 객체로 선언
		
		before = new ImageIcon("images/yogurt/plainYogurt.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		plainYogurt = new ImageIcon(img);
		//plainYogurt ImageIcon 처리
	
		before = new ImageIcon("images/yogurt/appleYogurt.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		appleYogurt = new ImageIcon(img);
		//appleYogurt ImageIcon 처리
		
		before = new ImageIcon("images/yogurt/strawberryYogurt.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		strawberryYogurt = new ImageIcon(img);
		//strawberryYogurt ImageIcon 처리
		
		//같은 과정 반복. yogurt 메뉴의 제품들 ImageIcon을 해당 생성자로 처리.
	}
}