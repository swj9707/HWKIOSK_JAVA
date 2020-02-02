package MenuSection;

import javax.swing.*;
import java.awt.*;


public class buttonPanel extends JPanel {
	/*
	 * kiosk의 맨 위에 메뉴를 선택하는 버튼들이 모여있는 패널 클래스
	 * */
	public JButton coffeeButton = new JButton("Coffee");
	public JButton teaButton = new JButton("Tea");
	public JButton yogurtButton = new JButton("Yogurt");
	public JButton juiceButton = new JButton("Juice");
	//메뉴 선택하는데 쓰일 JButton객체들. 다른 클래스에서 접근 가능하도록 Public 처리
	public buttonPanel() {
		coffeeButton.setBackground(Color.WHITE);
		coffeeButton.setFont(new Font("Arial", Font.BOLD, 20));
		teaButton.setBackground(Color.WHITE);
		teaButton.setFont(new Font("Arial", Font.BOLD, 20));
		yogurtButton.setBackground(Color.WHITE);
		yogurtButton.setFont(new Font("Arial", Font.BOLD, 20));
		juiceButton.setBackground(Color.WHITE);
		juiceButton.setFont(new Font("Arial", Font.BOLD, 20));
		//각각 버튼들의 배경 색 설정
		
		setLayout(new GridLayout(1,4,5,5)); //버튼들이 모여있는 구간이므로 편하게 GridLayout 사용
		setBackground(Color.LIGHT_GRAY);
		//buttonPanel 배경 색 설정
		add(coffeeButton);
		add(teaButton);
		add(yogurtButton);
		add(juiceButton);
		//넣고싶은 순서대로 각 버튼을 해당 패널에 추가
	}
}
