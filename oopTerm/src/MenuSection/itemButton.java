 package MenuSection;

import CartSection.*;
import ImageSection.*;
import PaymentSection.billPanel;

import javax.swing.*;
import ImageSection.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemButton extends JButton{
	/*
	 * itemPanel에 들어갈 itemButton 클래스
	 * 해당 클래스에 상품의 이름과 가격 정보, 상품 사진 레이블이 들어가있다.
	 * */
	public String name;//상품의 이름
	public int price;//상품의 가격
	//후에 장바구니, 결제 기능 구현할 때 사용하기 위해 public 처리
	
	JLabel ImageLabel;
	//상품 사진이 들어가게 될 레이블
	
	coffeeIcon coffeeIcon = new coffeeIcon();
	teaIcon teaIcon = new teaIcon();
	yogurtIcon yogurtIcon = new yogurtIcon();
	juiceIcon juiceIcon = new juiceIcon();
	//ImageSection 패키지에서 가져온 각각의 imageicon 객체들. 후에 더 추가 예정.
	
	public itemButton(String name, int price, String menuName) {
		this.name = name;//객체를 생성할 때, 이름과 가격, 상품이름을 입력받는다.
		this.price = price;
		
		if(menuName.equals("Coffee")) ImageLabel = new JLabel(coffeeIcon.coffeeImage);
		else if(menuName.equals("Americano")) ImageLabel = new JLabel(coffeeIcon.americano);
		else if(menuName.equals("Latte")) ImageLabel = new JLabel(coffeeIcon.latte);
		else if(menuName.equals("Mocha")) ImageLabel = new JLabel(coffeeIcon.mocha);
		else if(menuName.equals("Einspanner")) ImageLabel = new JLabel(coffeeIcon.einspanner);
		//coffee메뉴의 제품들의 ImageLabel를 처리 하는 조건문
		else if(menuName.equals("Tea")) ImageLabel = new JLabel(teaIcon.teaImage);
		else if(menuName.equals("GreenTea")) ImageLabel = new JLabel(teaIcon.greenTea);
		else if(menuName.equals("BlackTea")) ImageLabel = new JLabel(teaIcon.blackTea);
		else if(menuName.equals("MilkTea")) ImageLabel = new JLabel(teaIcon.milkTea);
		//tea메뉴의 제품들의 ImageLabel를 처리 하는 조건문
		else if(menuName.equals("Yogurt")) ImageLabel = new JLabel(yogurtIcon.yogurtImage);
		else if(menuName.equals("PlainYogurt")) ImageLabel = new JLabel(yogurtIcon.plainYogurt);
		else if(menuName.equals("AppleYogurt")) ImageLabel = new JLabel(yogurtIcon.appleYogurt);
		else if(menuName.equals("StrawBerryYogurt")) ImageLabel = new JLabel(yogurtIcon.strawberryYogurt);
		//yogurt메뉴의 제품들의 ImageLabel를 처리 하는 조건문
		else if(menuName.equals("Juice")) ImageLabel = new JLabel(juiceIcon.juiceImage);
		else if(menuName.equals("AppleJuice")) ImageLabel = new JLabel(juiceIcon.appleJuice);
		else if(menuName.equals("GrapeJuice")) ImageLabel = new JLabel(juiceIcon.grapeJuice);
		else if(menuName.equals("KiwiJuice")) ImageLabel = new JLabel(juiceIcon.kiwiJuice);
		else if(menuName.equals("OrangeJuice")) ImageLabel = new JLabel(juiceIcon.orangeJuice);
		else if(menuName.equals("StrawBerryJuice")) ImageLabel = new JLabel(juiceIcon.strawberryJuice);
		//juice메뉴의 제품들의 ImageLabel를 처리 하는 조건문
		else ImageLabel = new JLabel();
		//menuName의 입력에 따라 ImageLabel에 알맞은 Imageicon을 추가. 후에 더 많은 사진들을 추가할 예정 
		//만약 해당 부분에 조건에 없는 문자열이 들어가는 경우, 그냥 빈 레이블 객체 생성
		
		JLabel textLabel = new JLabel(name);//상품 이름이 입력된 레이블
		textLabel.setHorizontalAlignment(JLabel.CENTER);//중앙 정렬
		
		JLabel priceLabel = new JLabel(Integer.toString(price));//상품 가격이 입력된 레이블
		priceLabel.setHorizontalAlignment(JLabel.CENTER);//중앙 정렬
		
		setBackground(Color.WHITE);//버튼 배경 색 생성
		JPanel Base = new JPanel();//ItemButton 위에 올려질 패널 생성
		Base.setLayout(new BorderLayout());
		Base.setBackground(Color.WHITE);//Base패널 배경 색 생성
		Base.add(textLabel,BorderLayout.NORTH);//BorderLayout 북쪽에 상품 이름
		Base.add(ImageLabel,BorderLayout.CENTER);//BorderLayout 중앙에 상품 사진
		Base.add(priceLabel,BorderLayout.SOUTH);//BorderLayout 남쪽에 상품 가격
		add(Base);
		//최종적으로 완성된 Base 패널을 추가
		addActionListener(new itemButtonAction());
		//객체가 생성되면서 자동으로 액션리스너 추가되게 처리함.
	}
	class itemButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			itemButton b = (itemButton)e.getSource();
			//itemButton 자체의 정보를 받아온다.
			int result = JOptionPane.showConfirmDialog(null,b.name+" 를 선택하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
			//해당 버튼을 누르면 해당 버튼의 제품 이름이 나오면서 선택 할지 말지를 Yes or No로 선택 할 수 있다.
			if(result == JOptionPane.YES_OPTION) {//Yes를 선택하면
				cartPanel.selectItem(b);//cartPanel의 selectItem 메소드를 사용하여 해당 버튼의 정보를 itemList에 추가함.
				billPanel.renewBill(cartPanel.totalPrice);//제품을 하나 선택했으니 제품 가격만큼 총 가격도 증가됬을테니 갱신
			}
			else if(result == JOptionPane.NO_OPTION) {//No를 선택하면
				JOptionPane.showMessageDialog(null, "취소되었습니다.");
				//팝업창 뜨면서 끝
			}
		}
	}
	//버튼을 누르면 해당 itemButton Class 내의 상품 정보들이 cartPanel의 itemList에 저장되는 방식.
}

