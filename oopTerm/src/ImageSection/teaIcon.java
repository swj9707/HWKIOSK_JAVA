package ImageSection;

import javax.swing.*;
import java.awt.*;

public class teaIcon extends ImageIcon {
	public ImageIcon teaImage;
	public ImageIcon greenTea;
	public ImageIcon blackTea;
	public ImageIcon milkTea;
	//다른 클래스에서 접근 가능하도록 ImageIcon을 public 처리
	//이 클래스는 tea 메뉴에서 사용하는 모든 ImageIcon 변수들을 처리함.
	public teaIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Tea.png");
		//image 폴더 내의 이미지파일에 접근해서 해당 객체 선언
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image 객체에 해당 이미지파일을 불러와서 크기 조절
		teaImage = new ImageIcon(img);
		//조절 된 그림 파일을 ImageIcon 객체로 선언
		
		before = new ImageIcon("images/tea/greenTea.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		greenTea = new ImageIcon(img);
		//greenTea ImageIcon 처리
		
		before = new ImageIcon("images/tea/blackTea.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		blackTea = new ImageIcon(img);
		//blackTea ImageIcon 처리
		
		before = new ImageIcon("images/tea/milkTea.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		milkTea = new ImageIcon(img);
		//milkTea ImageIcon 처리
		
		//같은 과정 반복. tea 메뉴의 제품들 ImageIcon을 해당 생성자로 처리.
	}
}