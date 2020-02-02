package MenuSection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class menuPanel extends JPanel{
	public buttonPanel buttonPanel = new buttonPanel();//상품들을 전환할 때 사용할 buttonPanel 객체 선언
	public itemPanel itemPanel = new itemPanel();//상품들이 나열되어있는 itemPanel 객체 선언
	//나중에 이벤트처리 등을 위해 public 처리

	public menuPanel() {
		setLayout(new BorderLayout());
		JPanel nameTag = new JPanel();//kiosk 맨 위에 카페 이름을 입력하기위해 선언한 패널
		JLabel name = new JLabel("SonStar Coffee");//nameTag 패널에 입력 될 카페 이름 레이블
		name.setHorizontalAlignment(JLabel.CENTER);//해당 레이블의 문자열 중앙정렬
		nameTag.setBackground(Color.LIGHT_GRAY);
		nameTag.setForeground(Color.BLACK);
		//nameTag 패널의 색과 글자 색 설정
		nameTag.add(name);
		
		JPanel button_item = new JPanel();//buttonPanel과 itemPanel을 담을 패널 객체 생성
		button_item.setLayout(new BorderLayout());
		button_item.add(buttonPanel, BorderLayout.NORTH);
		button_item.add(itemPanel, BorderLayout.CENTER);
		//해당 패널에 buttonPanel과 itemPanel을 추가함으로써 하나의 패널로 처리
		buttonPanel.coffeeButton.addActionListener(new menuButtonAction());
		buttonPanel.teaButton.addActionListener(new menuButtonAction());
		buttonPanel.yogurtButton.addActionListener(new menuButtonAction());
		buttonPanel.juiceButton.addActionListener(new menuButtonAction());
		//각각 버튼에 액션리스너 추가.
		add(nameTag, BorderLayout.NORTH);
		add(button_item, BorderLayout.CENTER);
		//최종적으로 menuPanel에 nameTag, button_item 패널 추가
	}
	class menuButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton Button = (JButton)e.getSource();
			if(Button.equals(buttonPanel.coffeeButton)) {
				itemPanel.card.show(itemPanel,"Coffee");
			}
			else if(Button.equals(buttonPanel.teaButton)) {
				itemPanel.card.show(itemPanel,"Tea");
			}
			else if(Button.equals(buttonPanel.yogurtButton)) {
				itemPanel.card.show(itemPanel,"Yogurt");
			}
			else if(Button.equals(buttonPanel.juiceButton)){
				itemPanel.card.show(itemPanel,"Juice");
			}
			/*상품들이 나타나는 패널은 카드레이아웃 처리 해서
			 * buttonPanel의 버튼들을 눌렀을 때, 어떤 버튼이 눌러지느냐에 따라
			 * 패널에 저장된 카드(패널)가 나타나도록 프로그래밍 한 액션리스너 
			 * */
			//개선사항 : 전에는 버튼의 String을 받아왔지만 이번엔 Object 자체를 받아옴.
			//그리고 메인 클래스가 복잡해지지 않도록 menuPanel에서 바로 액션리스너를 처리.
		}
	}
}
