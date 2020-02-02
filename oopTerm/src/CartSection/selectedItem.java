package CartSection;

import PaymentSection.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectedItem extends JPanel{
	//선택 된 제품 클래스. 
	//장바구니에 들어가는 제품 패널 클래스.
	public String itemName;//제품 이름
	public int itemPrice;//제품 가격
	public int itemAmount;//제품 갯수
	public int amountofPrice;//제품 총 가격
	public int index;
	//deleteSelectedItem 메서드에서 해당 변수가 없으면 똑같은 itemName과 itemAmount를 가진 객체가 itemList에 있을 때
	//나중에 추가한 제품을 삭제하려고 하면 itemList의 맨 위에 있는 객체가 삭제되는 현상 발생. 그래서 각각 제품에 추가된 순서를 저장하는
	//index 변수를 추가.
	
	public JLabel Amount;//갯수가 적힐 JLabel
	public JLabel PriceLabel;//총 가격이 적힐 JLabel
	public JButton Plus, Minus, delete;
	//제품의 양을 증가시키는 plus, 감소시키는 minus, 제품을 삭제하는 delete 버튼
	
	public selectedItem(String itemName, int itemPrice, int indexnum) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemAmount = 1;
		this.amountofPrice = itemPrice;
		this.index = indexnum;
		//생성자가 처음 생성될 때 itemButton 클래스에서 itemName과 itemPrice를 받아옴. 
		//cartPanel의 selectItem 메소드를 활용한 액션 리스너를 만들어 itemButton 에 추가.
		
		setLayout(new GridLayout(1,3));//제품 이름, 갯수, 총 가격으로 파트를 나눌것이기 때문에 GridLayout으로 처리.
		setBorder(new LineBorder(Color.BLACK));//경계선 처리를 해주지 않으면 제품끼리 구별이 잘 안되므로 경계선을 만듬.
		setBackground(Color.WHITE);
		
		JPanel NamePanel = new JPanel();//이름이 들어갈 패널
		JLabel NameLabel = new JLabel(itemName);//NamePanel위에 올라갈 NameLabel. 여기에 itemName을 입력.
		NameLabel.setHorizontalAlignment(JLabel.CENTER);//NameLabel 가운데정렬
		NameLabel.setFont(new Font("Arial",Font.BOLD, 20));//NameLabel 볼드처리, 폰트 크기를 크게처리.
		NamePanel.setBackground(Color.WHITE);//배경과 구별되야하므로 배경색을 흰색으로 처리.
		NamePanel.setBorder(new LineBorder(Color.BLACK));//selectedItem 내부에 들어갈 패널끼리 구별되야 하므로 경계선을 만듬.
		NamePanel.add(NameLabel);//NamePanel에 NameLabel을 추가합니다.
		
		JPanel PricePanel = new JPanel();//총 가격이 들어갈 패널
		PricePanel.setBackground(Color.WHITE);//배경과 구별되야하므로 배경색을 흰색으로 처리.
		PricePanel.setBorder(new LineBorder(Color.BLACK));//selectedItem 내부에 들어갈 패널끼리 구별되야 하므로 경계선을 만듬.
		PriceLabel = new JLabel(Integer.toString(amountofPrice));//총 가격이 들어갈 PriceLabel
		PriceLabel.setHorizontalAlignment(JLabel.CENTER);//PriceLabel 가운데정렬
		PriceLabel.setFont(new Font("Arial",Font.BOLD, 20));//PriceLabel 볼드처리, 폰트 크기를 크게처리.
		PricePanel.add(PriceLabel);//PricePanel에 PriceLabel을 추가.
		
		JPanel AmountPanel = new JPanel();//상품의 총 갯수를 나타내는 패널
		JPanel buttonPanel = new JPanel();//plus,minus,delete 버튼이 들어갈 패널
		
		AmountPanel.setLayout(new BorderLayout());//총 갯수를 나타내는 AmountLabel, 버튼들이 모인 buttonPanel을 적당한 위치에 넣어야 하므로 BorderLayout처리.
		AmountPanel.setBackground(Color.WHITE);//배경과 구별되야하므로 배경색을 흰색으로 처리합니다.
		AmountPanel.setBorder(new LineBorder(Color.BLACK));//selectedItem 내부에 들어갈 패널끼리 구별되야 하므로 경계선을 만듬.
		buttonPanel.setLayout(new GridLayout(3,1));//plus, minus, delete 버튼이 일정한 모양으로 들어가야 하므로 GridLayout
		
		Amount = new JLabel(""+itemAmount);//itemAmout, 즉 제품의 총 량을 입력
		Plus = new JButton("+");//Plus 버튼 JButton객체 선언
		Minus = new JButton("-");//Minus 버튼 JButton객체 선언
		delete = new JButton("X");//Delete 버튼 JButton객체 선언
		
		Plus.setBackground(Color.LIGHT_GRAY);
		Minus.setBackground(Color.LIGHT_GRAY);
		delete.setBackground(Color.LIGHT_GRAY);
		
		Amount.setFont(new Font("Arial",Font.BOLD,20));//Amount 볼드처리, 폰트 크기를 크게처리.
		Amount.setHorizontalAlignment(JLabel.CENTER);//Amount 중앙정렬
		Plus.addActionListener(new plus_minus_delete());
		Minus.addActionListener(new plus_minus_delete());
		delete.addActionListener(new plus_minus_delete());
		//plus, minus, delete 버튼에 plus_minus_delete 액션리스너를 추가합니다.
		
		buttonPanel.add(Plus);
		buttonPanel.add(Minus);
		buttonPanel.add(delete);
		
		AmountPanel.add(Amount, BorderLayout.CENTER);
		AmountPanel.add(buttonPanel, BorderLayout.EAST);
		
		add(NamePanel);
		add(AmountPanel);
		add(PricePanel);
	}
	public static void deleteSelectedItem(String Name, int Amount, int index) {
		int flag = 0;
		for(Iterator<selectedItem> tmp = cartPanel.itemList.iterator() ; tmp.hasNext(); ) {
			//Iterator로 itemList의 전체를 다 체크해본다.
			selectedItem p = tmp.next();
			if(p.itemName == Name && p.itemAmount == Amount && p.index == index) { //만약 parameter값과 같은 element가 있다면?
				cartPanel.totalPrice -= p.amountofPrice;//제품을 지웠으니까 그 제품의 총 가격만큼을 전체 총 가격에서 뺀다.
				tmp.remove();//그리고 해당 Iterator를 지워버린다. 아예 그 제품을 지워야하니까.
				flag = 1;//제품을 삭제했다는 flag 처리.
				continue;//다음 반복으로 패스
			}
			if(flag == 1) {//flag가 1일 때, 즉 삭제된 객체 이후의 itemList의 모든 객체에 대해 
				p.index -=1;//인덱스값을 하나씩 줄여준다. 삭제된 객체의 빈자리를 채워줘야 하므로. 
			}
			
	}
	billPanel.renewBill(cartPanel.totalPrice);//billPanel을 바뀐 totalPrice로 갱신한다.
	cartPanel.syncronizeCartList();
	//cartList를 초기화하고 다시 세팅한다.
}
	public class plus_minus_delete implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();//이벤트가 일어나면 String을 받아옴. 
			if(str.equals("+")){//Plus 버튼을 눌렀을 때
				itemAmount += 1;//제품 총 량 1 증가
				amountofPrice = itemAmount * itemPrice;//제품 총 가격 = 제품 총 량 * 제품 가격
				cartPanel.totalPrice += itemPrice;//총합 가격에 제품 가격을 한번 더함.
			
				Amount.setText(""+itemAmount);//Amount에 다시 재 조정된 itemAmount 입력
				PriceLabel.setText(Integer.toString(amountofPrice));//PriceLabel에 다시 재 조정된 amountofPrice 입력
				billPanel.renewBill(cartPanel.totalPrice);//총 합 가격이 출력되는 billPanel의 renewBill 메소드로 billPanel 재설정
				//Amount JLabel, PriceLabel 재설정
			}
			else if(str.equals("-")){//Minus 버튼을 눌렀을 때
				if(itemAmount == 1) {
					int result = JOptionPane.showConfirmDialog(null,itemName+" 을 장바구니에서 삭제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					//Yes or no popup 창 실행
					if(result == JOptionPane.YES_OPTION) {//Yes를 눌렀을 때
						deleteSelectedItem(itemName, itemAmount, index);//cartPanel의 deleteSelectedItem 메소드를 사용해서 해당 selectedItem 객체를 itemList에서 제거
						JOptionPane.showMessageDialog(null, itemName+" 삭제되었습니다.");
					}
					else if(result == JOptionPane.NO_OPTION) {//No를 눌렀을 때
						JOptionPane.showMessageDialog(null, "취소되었습니다.");
					}
				}
				else if (itemAmount >= 2) {
					itemAmount -= 1;//제품 총 량 1 감소
					amountofPrice = itemAmount * itemPrice;//제품 총 가격 = 제품 총 량 * 제품 가격
					cartPanel.totalPrice -= itemPrice;//총합 가격에 제품 가격을 한번 뺌.
					
					Amount.setText(""+itemAmount);//Amount에 다시 재 조정된 itemAmount 입력
					PriceLabel.setText(Integer.toString(amountofPrice));//PriceLabel에 다시 재 조정된 amountofPrice 입력
					billPanel.renewBill(cartPanel.totalPrice);//총 합 가격이 출력되는 billPanel의 renewBill 메소드로 billPanel 재설정
				}
			}
			else if(str.equals("X")) {//Delete버튼을 눌렀을 때
				int result = JOptionPane.showConfirmDialog(null,itemName+" 을 장바구니에서 삭제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or no popup 창 실행
				if(result == JOptionPane.YES_OPTION) {//Yes를 눌렀을 때
					deleteSelectedItem(itemName, itemAmount, index);//cartPanel의 deleteSelectedItem 메소드를 사용해서 해당 selectedItem 객체를 itemList에서 제거
					JOptionPane.showMessageDialog(null, itemName+" 삭제되었습니다.");
				}
				else if(result == JOptionPane.NO_OPTION) {//No를 눌렀을 때
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
				}
			}
	 	}
	}
}
