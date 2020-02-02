package Kiosk;

import MenuSection.*;
import CartSection.*;
import PaymentSection.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame {
	/*
	 * 메인 클래스. 이 Kiosk 클래스가 main 클래스
	 */
	public menuPanel menu; //메뉴 클래스
	public cartPanel cart; //장바구니 클래스
	public billPanel bill;//총 가격 클래스
	public paymentPanel payment; //결제창 클래스
	//다른 패키지에서 액션리스너 사용을 위해 필드에 객체선언
	public Kiosk() {
		setTitle("Sonstar Coffee KIOSK");//가게이름이 프로그램 창에 뜨게 하기 위해 삽입
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container Ct = getContentPane();
		Ct.setLayout(new GridLayout(2,1,10,10));//메뉴패널과 장바구니, 결제 패널을 반으로 분리하기 GridLayout사용
		
		menu = new menuPanel(); //메뉴 클래스
		cart = new cartPanel(); //장바구니 클래스
		bill = new billPanel(cart.totalPrice);//제품의 총 가격 클래스
		payment = new paymentPanel(); //결제창 클래스
		
		JPanel cart_paySection = new JPanel();//장바구니창과 결제창 클래스를 담을 패널
		cart_paySection.setLayout(new GridLayout(2,1));//반으로 나눠서 해결할 생각이므로 GridLayout 처리
		cart_paySection.add(cart);//cart_paySection에 cart추가.
		
		JPanel bill_paybuttonSection = new JPanel();//billPanel과 paymentPanel을 담을 패널
		bill_paybuttonSection.setLayout(new GridLayout(1,2));//반으로 나눌 생각이므로 GridLayout 처리
		bill_paybuttonSection.add(bill);//bill_paybutotnSection에 bill 클래스 추가
		bill_paybuttonSection.add(payment);//bill_paybutotnSection에 payment 클래스 추가
		
		cart_paySection.add(bill_paybuttonSection);//cart_paySection에 bill_paybuttonSection추가.
	
		Ct.add(menu);
		Ct.add(cart_paySection);
		//최종적으로 컨테이너에 menu와 cart_paySection추가
		
		//setLocationRelativeTo(null);//화면 중간에 프로그램 배치 
		setSize(600,800);//사이즈 조정
		setResizable(false);//사이즈 조절 불가능하도록 하기 위해 추가함
		setVisible(true);
	}
	public static void main(String[] args) {
		new Kiosk();
	}
}
