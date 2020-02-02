package ImageSection;

import javax.swing.*;
import java.awt.*;

public class juiceIcon extends ImageIcon {
	public ImageIcon juiceImage;
	public ImageIcon appleJuice;
	public ImageIcon grapeJuice;
	public ImageIcon kiwiJuice;
	public ImageIcon orangeJuice;
	public ImageIcon strawberryJuice;
	//다른 클래스에서 접근 가능하도록 ImageIcon을 public 처리
	//이 클래스는 Juice 메뉴에서 사용하는 모든 ImageIcon 변수들을 처리함.
	public juiceIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Juice.png");
		//image 폴더 내의 이미지파일에 접근해서 해당 객체 선언
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image 객체에 해당 이미지파일을 불러와서 크기 조절
		juiceImage = new ImageIcon(img);
		//조절 된 그림 파일을 ImageIcon 객체로 선언
		
		before = new ImageIcon("images/juice/appleJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		appleJuice = new ImageIcon(img);
		//appleJuice ImageIcon 처리
		
		before = new ImageIcon("images/juice/grapeJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		grapeJuice = new ImageIcon(img);
		//grapeJuice ImageIcon 처리
		
		before = new ImageIcon("images/juice/kiwiJuice.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		kiwiJuice = new ImageIcon(img);
		//kiwiJuice ImageIcon 처리
		
		before = new ImageIcon("images/juice/orangeJuice.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		orangeJuice = new ImageIcon(img);
		//orangeJuice ImageIcon 처리
		
		before = new ImageIcon("images/juice/strawberryJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		strawberryJuice = new ImageIcon(img);
		//strawberryJuice ImageIcon 처리
		
		//같은 과정 반복. juice 메뉴의 제품들 ImageIcon을 해당 생성자로 처리.
	}
}