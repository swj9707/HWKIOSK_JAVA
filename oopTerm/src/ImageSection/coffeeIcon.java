package ImageSection;

import javax.swing.*;
import java.awt.*;

public class coffeeIcon extends ImageIcon {
	public ImageIcon coffeeImage;
	public ImageIcon americano;
	public ImageIcon latte;
	public ImageIcon mocha;
	public ImageIcon einspanner;
	
	//다른 클래스에서 접근 가능하도록 ImageIcon을 public 처리
	//이 클래스는 coffee 메뉴에서 사용하는 모든 ImageIcon 변수들을 처리함.
	public coffeeIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Coffee.png");
		//image 폴더 내의 이미지파일에 접근해서 해당 객체 선언
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image 객체에 해당 이미지파일을 불러와서 크기 조절
		coffeeImage = new ImageIcon(img);
		//조절 된 그림 파일을 ImageIcon 객체로 선언
		
		before = new ImageIcon("images/coffee/americano.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		americano = new ImageIcon(img);
		//americano ImageIcon 처리
		
		before = new ImageIcon("images/coffee/latte.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		latte = new ImageIcon(img);
		//latte ImageIcon 처리
		
		before = new ImageIcon("images/coffee/mocha.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		mocha = new ImageIcon(img);
		//mocha ImageIcon 처리
		
		before = new ImageIcon("images/coffee/einspanner.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		einspanner = new ImageIcon(img);
		//einspanner ImageIcon 처리
		
		//같은 과정 반복. coffee 메뉴의 제품들 ImageIcon을 해당 생성자로 처리.
	}
}
