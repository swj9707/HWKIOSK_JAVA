package PaymentSection;

import javax.swing.*;
import java.awt.*;

public class billPanel extends JPanel {
	static JLabel amountofPrice;//장바구니의 모든 제품들의 가격의 총 합.
	public billPanel(int AmountofPrice) {
		setLayout(new BorderLayout());//표 처럼 만들고 싶어서 BorderLayout처리
		JPanel nameTag = new JPanel();//총 합이라는 글자가 들어갈 JPanel
		JLabel billTag = new JLabel("총 합");//총 합이라는 글자가 들어갈 JLabel
		billTag.setHorizontalAlignment(JLabel.CENTER);//해당 Label 가운데정렬
		nameTag.setBackground(Color.WHITE);
		nameTag.setForeground(Color.BLACK);
		//배경색은 White, 글씨체는 Black으로 처리
		nameTag.add(billTag);
		//nameTag JPanel에 Label추가

		JPanel pricePanel = new JPanel();
		pricePanel.setBackground(Color.WHITE);
		amountofPrice = new JLabel(AmountofPrice+" Won");//모든 제품들의 총 가격을 나타내는 Label
		amountofPrice.setHorizontalAlignment(JLabel.CENTER);
		amountofPrice.setFont(new Font("Arial", Font.BOLD, 40));
		pricePanel.add(amountofPrice);
		//중앙 정렬 후 폰트 세팅
		
		add(nameTag,BorderLayout.NORTH);
		add(pricePanel, BorderLayout.CENTER);
		//각각의 용도에 맞게 위치 설정.
	}
	public static void renewBill(int AmountofPrice){
		amountofPrice.setText(AmountofPrice+" Won");
		amountofPrice.setHorizontalAlignment(JLabel.CENTER);
		amountofPrice.setFont(new Font("Arial", Font.BOLD, 40));
		//Parameter 값으로 amountofPrice Label을 재설정시키는 메서드
	}
}
