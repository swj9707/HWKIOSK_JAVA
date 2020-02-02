package MenuSection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class itemPanel extends JPanel{
	public static CardLayout card;/*
	상품들이 전환될 때 카드레이아웃을 사용할 것이기 때문에, 그리고
	액션리스너를 kiosk 클래스에서 사용할것이기 때문에 public 처리
	*/
	public coffeePanel coffeePanel = new coffeePanel();
	public teaPanel teaPanel = new teaPanel();
	public yogurtPanel yogurtPanel = new yogurtPanel();
	public juicePanel juicePanel = new juicePanel();
	//각각 상품 패널들 객체 선언
	public itemPanel() {
		card = new CardLayout(5,5);
		setLayout(card);//카드레이아웃 처리
		add("Coffee",coffeePanel);
		add("Tea",teaPanel);
		add("Yogurt",yogurtPanel);
		add("Juice",juicePanel);
		//show 함수를 사용하기 위해 각 패널을 추가하면서 닉네임 추가.
		coffeePanel.latteButton.setToolTipText("우유와 에스프레소의 조합! 부드러움을 선사해드립니다!");
		coffeePanel.americanoButton.setToolTipText("직접 로스팅한 커피로 추출한 신선한 에스프레소 본연의 맛입니다!");
		coffeePanel.mochaButton.setToolTipText("누가 커피와 초콜릿의 조합을 발견했을까요! 혀 끝까지 달콤해지고 싶으신 분에게 추천합니다!");
		coffeePanel.einspannerButton.setToolTipText("꾸덕한듯 아닌듯 한 크림과 진한 커피의 조합! 단짠이 아닌 단쓴 조합을 아는 분들은 커피를 좀 아신다는 것이겠지요!");
		//coffeePanel 버튼들 툴팁 추가 (추가구현사항)
		teaPanel.blackteaButton.setToolTipText("차는 뭐니뭐니해도 홍차죠! 진한 차 향을 원하시는 분 께 추천합니다!");
		teaPanel.greenteaButton.setToolTipText("깔끔하고 한국인의 입맛에 딱! 사먹을 만한 가치를 느끼실겁니다!");
		teaPanel.milkteaButton.setToolTipText("어떤 천재가 홍차와 우유의 조합을 발견해냈을까요?? 부드러움의 끝으로 여러분을 초대합니다!");
		//teaPanel 버튼들 툴팁 추가 (추가구현사항)
		yogurtPanel.appleYogurtButton.setToolTipText("사과와 요거트의 조합! 아침에 먹으면 그날 하루가 싱그럽겠지요?");
		yogurtPanel.plainButton.setToolTipText("기본에 충실한 요거트의 맛! 그 자체로도 완벽합니다!");
		yogurtPanel.strawberryYogurtButton.setToolTipText("싱그러운 딸기와 요거트의 조합! 어머 이건 사야되!!");
		//yogurtPanel 버튼들 툴팁 추가 (추가구현사항)
		juicePanel.applejuiceButton.setToolTipText("싱그러운 사과과즙 그 자체입니다. 아침에 마시는걸 추천합니다. 그래야 하루종일 싱그럽죠.");
		juicePanel.grapejuiceButton.setToolTipText("과수원에 서서 바로 따 먹는 포도의 맛입니다. 포도는 먹고싶은데 씹긴 싫다? 그럼 이걸 사드세요!");
		juicePanel.kiwijuiceButton.setToolTipText("키위는 과일의 왕이라고도 하죠. 싱그러운 키위 향과 함께 하루를 보내보세요!");
		juicePanel.orangejuiceButton.setToolTipText("주스 하면 오렌지주스! 명불허전의 달콤한 맛과 향!");
		juicePanel.strawberryjuiceButton.setToolTipText("딸기 맛을 아시는 당신! 순수한 딸기의 맛을 선사해드립니다!");
		//juicePanel 버튼들 툴팁 추가 (추가구현사항)
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(300000);	
	}
	public class coffeePanel extends JPanel{
		private static final long serialVersionUID = 1L;
		public itemButton latteButton;
		public itemButton americanoButton;
		public itemButton mochaButton;
		public itemButton einspannerButton;
		//다른 클래스에서 접근 가능하도록 필드에 선언 후 Public 처리	
		public coffeePanel() {
			setLayout(new GridLayout(2,4,10,10));//규격화된 상품 진열을 위해 GridLayout 처리
			
			latteButton = new itemButton("Latte",2500, "Latte");
			americanoButton = new itemButton("Americano", 2000, "Americano");
			mochaButton = new itemButton("Mocha", 2500, "Mocha");
			einspannerButton = new itemButton("Einspanner", 3000, "Einspanner");
			//해당 패널에 추가하고싶은 상품을 itemButton 객체로 생성
			
			add(latteButton);
			add(americanoButton);
			add(mochaButton);
			add(einspannerButton);
			//생성한 itemButton 객체를 해당 패널에 추가
			for(int i = 0; i < 4; i++) add(new JPanel());//아직 추가하지 않은 상품들은 모두 빈 패널로 처리
		}
	}

	public static class teaPanel extends JPanel{
		public itemButton greenteaButton;
		public itemButton blackteaButton;
		public itemButton milkteaButton;
		//다른 클래스에서 접근 가능하도록 필드에 선언 후 Public 처리
		public teaPanel() {
			setLayout(new GridLayout(2,4,10,10));//규격화된 상품 진열을 위해 GridLayout 처리
			
			greenteaButton = new itemButton("GreenTea", 2000,"GreenTea");
			blackteaButton = new itemButton("BlackTea", 2500,"BlackTea");
			milkteaButton = new itemButton("MilkTea", 2800,"MilkTea");
			//해당 패널에 추가하고싶은 상품을 itemButton 객체로 생성
			
			add(greenteaButton);
			add(blackteaButton);
			add(milkteaButton);
			//생성한 itemButton 객체를 해당 패널에 추가
			for(int i = 0; i < 5; i++) add(new JPanel());//아직 추가하지 않은 상품들은 모두 빈 패널로 처리
		}
	}
	public static class yogurtPanel extends JPanel{
		public itemButton plainButton;
		public itemButton appleYogurtButton;
		public itemButton strawberryYogurtButton;
		//다른 클래스에서 접근 가능하도록 필드에 선언 후 Public 처리
		public yogurtPanel() {
			setLayout(new GridLayout(2,4,10,10));//규격화된 상품 진열을 위해 GridLayout 처리
			
			plainButton = new itemButton("PlainYogurt", 2000,"PlainYogurt");
			appleYogurtButton = new itemButton("AppleYogurt", 2500,"AppleYogurt");
			strawberryYogurtButton = new itemButton("StrawBerryYogurt", 2700,"StrawBerryYogurt");
			//해당 패널에 추가하고싶은 상품을 itemButton 객체로 생성
			
			add(plainButton);
			add(appleYogurtButton);
			add(strawberryYogurtButton);
			//생성한 itemButton 객체를 해당 패널에 추가
			for(int i = 0; i < 5; i++) add(new JPanel());//아직 추가하지 않은 상품들은 모두 빈 패널로 처리
		}
	}
	public static class juicePanel extends JPanel{
		public itemButton applejuiceButton;
		public itemButton orangejuiceButton;
		public itemButton grapejuiceButton;
		public itemButton kiwijuiceButton;
		public itemButton strawberryjuiceButton;
		//다른 클래스에서 접근 가능하도록 필드에 선언 후 Public 처리
		public juicePanel() {
			setLayout(new GridLayout(2,4,10,10));//규격화된 상품 진열을 위해 GridLayout 처리

			applejuiceButton = new itemButton("AppleJuice", 2500,"AppleJuice");
			orangejuiceButton = new itemButton("OrangeJuice", 2300,"OrangeJuice");
			grapejuiceButton = new itemButton("GrapeJuice", 2500,"GrapeJuice");
			kiwijuiceButton = new itemButton("KiwiJuice", 2500,"KiwiJuice");
			strawberryjuiceButton = new itemButton("StrawBerryJuice", 2500,"StrawBerryJuice");
			//해당 패널에 추가하고싶은 상품을 itemButton 객체로 생성
			
			add(applejuiceButton);
			add(orangejuiceButton);
			add(grapejuiceButton);
			add(kiwijuiceButton);
			add(strawberryjuiceButton);
			//생성한 itemButton 객체를 해당 패널에 추가
			for(int i = 0; i < 3; i++) add(new JPanel());//아직 추가하지 않은 상품들은 모두 빈 패널로 처리
		}
	}
	//상품들이 나열되는 패널들 클래스들
}

