package ImageSection;

import javax.swing.*;
import java.awt.*;

public class musicPlayerImage extends ImageIcon {
	public ImageIcon musicPlayerIcon;//음악플레이어 ImageIcon
	public musicPlayerImage() {
		Image img;
		ImageIcon before = new ImageIcon("images/MusicPlayer.png");
		//image 폴더 내의 이미지파일에 접근해서 해당 객체 선언
		img = before.getImage();
		img.getScaledInstance(180, 270, Image.SCALE_SMOOTH);
		//Image 객체에 해당 이미지파일을 불러와서 크기 조절
		musicPlayerIcon = new ImageIcon(img);
		//조절 된 그림 파일을 ImageIcon 객체로 선언
	}
}
