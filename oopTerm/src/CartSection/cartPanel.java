package CartSection;

import MenuSection.*;
import PaymentSection.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


public class cartPanel extends JPanel{
	public static JPanel cartList;//장바구니 역할을 실질적으로 할 패널
	public JScrollPane cartlistPanel;//제품이 많아지면 스크롤이 있어야 그 제품들을 다 담을 수 있기때문에 scrollpane 생성
	public static ArrayList<selectedItem> itemList;//선택받은 Item들의 List. 각각의 정보를 Panel class에 저장함
	public static int cartListHeight;//기본값 8. 8개보다 더 많은 제품이 장바구니에 입력될 경우, 더 추가하기 위해 변수선언.
	public static int totalPrice;//장바구니 안의 모든 제품들의 가격을 합친 값
	public static int indexNum;//현재 장바구니 내에 제품이 몇개 들어가있는가?
	
	//다른 class에서 접근 가능하도록 public, static처리
	public cartPanel() {
		
		setLayout(new BorderLayout());//North에 상품명, 수량, 가격을 표시하고 Center에 ScrollPane을 넣기 위해 BorderLayout 선언
		
		totalPrice = 0;//처음에 생성될 때, 모든 제품의 총합 가격은 0이 되어야 하므로 0으로 초기화.
		itemList = new ArrayList<>();//itemList라는 selectedItem class를 Element로 가지는 ArrayList 객체 선언		
		cartList = new JPanel();//cartList Panel선언
		cartListHeight = 8;//장바구니의 처음 용량. 처음엔 8개까지 입력 가능하고 ArrayList니까 갈수록 2배씩 늘어날것이다.
		indexNum = 0;
		
		JPanel infor = new JPanel();
		infor.setLayout(new GridLayout(1,3));
		infor.setBorder(new LineBorder(Color.BLACK));
		infor.setBackground(Color.WHITE);
		//상품의 이름, 수량, 가격 정보가 이 순서대로 나타난다고 보여주는 Panel. 차트식으로 만들것이기 때문에 이렇게 처리함.
		//다른 패널들과 구별하기 위하여 Border는 검은색으로, Background는 흰색으로 처리.
		
		JLabel itemName = new JLabel("상품명");
		itemName.setHorizontalAlignment(JLabel.CENTER);
		JLabel itemAmount = new JLabel("수량");
		itemAmount.setHorizontalAlignment(JLabel.CENTER);
		JLabel itemPrice = new JLabel("가격");
		itemPrice.setHorizontalAlignment(JLabel.CENTER);
		//상품 이름, 수량 가격 Label 만들고 중앙정렬
		
		infor.add(itemName);
		infor.add(itemAmount);
		infor.add(itemPrice);
		//세 Label을 infor Panel에 추가.
		
		add(infor,BorderLayout.NORTH);//infor Panel을 해당 패널 NORTH에 추가. 
		
		cartList.setLayout(new GridLayout(cartListHeight, 3,2,2));
		//cartList레이아웃을 행은 cartListHeight만큼, 열은 상품명, 수량, 가격 순서대로 들어가야하므로3
		//최소한 selectedItem끼리 구별은 되야 하므로 2씩 간격을 만듬. 처리 안하니까 경계선이 겹쳐서 이상하게 보임.
		cartlistPanel = new JScrollPane(cartList);
		//제품의 양이 많아지면 한정된 Panel에서 늘어난 제품들을 처리해야 하므로 JScrollPane 선언 후 추가.
		
		add(cartlistPanel, BorderLayout.CENTER);		
		//세팅이 끝난 cartlistPanel을 해당패널 CENTER에 추가.
	}
	public static void syncronizeCartList() {
		//cartList를 갱신하는 메서드. 
		//cartList 패널을 다시 그려야 할 일이 있을텐데 그럴 때 itemList 내에 저장되어있는 정보들을 다시 cartList에 입력해줘야한다.
		cartList.invalidate();
		//잠금해제.
		cartList.removeAll();
		//내부의 내용을 모두 지운다.
		for(Iterator<selectedItem> tmp = itemList.iterator() ; tmp.hasNext(); ) {
			//Iterator 처리를 하는 이유는 ArrayList 내의 Element를 삭제하거나 추가할 때 이렇게 안하면 에러가 남.
			selectedItem p = tmp.next();
			cartList.add(p);
			//itemList내부의 모든 Element들을 cartList에 추가.
		}
		cartList.validate();
		//다시 잠그고
		cartList.repaint();
		//해당 패널을 다시 그린다.
	}
	public static void selectItem(itemButton A) {
		selectedItem selected = new selectedItem(A.name,A.price,indexNum);
		//selectedItem 객체를 하나 선언.
		totalPrice += A.price;//전체 가격에 해당 객체의 가격만큼 더해준다.
		indexNum += 1;
		itemList.add(selected);
		//해당 객체는 itemList에 입력된다.
		if(itemList.size() <= cartListHeight) {
			cartList.add(selected);
			//cartListHeight 크기보다 itemList의 element 갯수가 작거나 같다면 그냥 cartList에 바로 add한다.
		}
		else {//만약에 크다면?
			cartListHeight += 1;//cartListHeight를 1만큼 더 증가시킨다.
			cartList.setLayout(new GridLayout(cartListHeight, 3, 2, 2));
			for(int i = 0; i < itemList.size(); i++) cartList.add(itemList.get(i));
			//갱신 된 cartListHeight를 바탕으로 cartList를 다시 세팅한다.
		}
	}
	public static void initalize() {
		//주문이 끝났으면 모든 것을 초기화시켜줘야 한다.
		totalPrice = 0;//총 가격을 0으로 초기화시키고
		indexNum = 0;//index값 또한 0으로 초기화시키고
		billPanel.renewBill(totalPrice);//초기화된 totalPrice를 바탕으로 billPanel을 갱신하고
		itemList.clear();
		cartList.invalidate();
		cartList.removeAll();
		cartList.validate();
		cartList.repaint();
		//cartList를 초기 상태로 초기화시킨다.
	}

}
