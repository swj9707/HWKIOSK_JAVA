package PaymentSection;

import ImageSection.*;
import CartSection.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import javax.sound.sampled.*;

public class paymentPanel extends JPanel {
	public JPanel paybuttonPanel;
	//payButton, cancelButton을 담을 JPanel
	public JButton payButton;
	public JButton cancelButton;
	//결제버튼과 결제취소 버튼  JButton
	//다른 클래스에서도 접근 가능하게 public처리
	private Clip clip;
	//음악 재생하는데 필요한 Clip
	public paymentPanel() {
		setLayout(new GridLayout(1,2));
		//버튼이 들어갈 자리와 추가구현(음악플레이어)가 들어갈 자리 반으로 나누기 위해 GridLayout처리
		
		paybuttonPanel = new JPanel();		
		paybuttonPanel.setLayout(new GridLayout(2,1));
		//버튼 두개가 들어가야 하므로 GridLayout처리
		
		payButton = new JButton("결제하기");
		payButton.setBackground(Color.WHITE);
		payButton.setFont(new Font("바탕",Font.BOLD, 20));
		cancelButton = new JButton("결제취소");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("바탕", Font.BOLD, 20));
		paybuttonPanel.add(payButton);
		paybuttonPanel.add(cancelButton);
		//결제버튼과 결제취소 버튼을 paybuttonPanel에 추가.
		
		musicPlayerImage deco = new musicPlayerImage();
		//장식용 이미지 decorationImage 객체 선언
		JPanel musicPlayer = new JPanel();
		JPanel musicButton = new JPanel();
		//MusicPlayer가 들어갈 JPanel과 그 MusicPlayer를 제어할 버튼이 들어갈 musicButton JPanel 선언
		musicButton.setLayout(new GridLayout(1,2));
		JButton start = new JButton("Start");
		start.setBackground(Color.LIGHT_GRAY);
		JButton stop = new JButton("Stop");
		stop.setBackground(Color.LIGHT_GRAY);
		//start 버튼과 stop 버튼 선언 및 배경 색 추가.
		musicButton.add(start);
		musicButton.add(stop);
		//start 버튼과 stop 버튼을 musicButton 패널에추가
		
		musicPlayer.setLayout(new BorderLayout());
		try{
			clip = AudioSystem.getClip();
			File audioFile = new File("music/bgm.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
		}//그냥 클립으로만 처리하면 오류나기 때문에 try로 감싸고
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		//생길 수 있는 몇가지 오류에 대비하여 예외처리
		start.addActionListener(new audioAction());
		stop.addActionListener(new audioAction());
		//두 버튼에 audioAction 액션리스너를 추가
		
		JLabel decoration = new JLabel(deco.musicPlayerIcon);
		//이미지가 들어갈 decoration JLabel
		musicPlayer.add(decoration,BorderLayout.CENTER);
		musicPlayer.add(musicButton, BorderLayout.SOUTH);
		
		payButton.addActionListener(new paymentAction());
		cancelButton.addActionListener(new paymentAction());
		//결제버튼과 취소버튼 액션리스너처리
		add(paybuttonPanel);
		add(musicPlayer);	
		//최종적으로 두 객체를 추가.
	}

	class paymentAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			//버튼엔 String 밖에 없기 때문에 굳이 getSource안씀.
			if(str.equals("결제하기")) {//결제하기 버튼을 눌렀을 때
				int result = JOptionPane.showConfirmDialog(null, cartPanel.totalPrice+"원을 결제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or No 팝업창으로 최종적으로 결제를 할지 안할지를 판단
				if(result == JOptionPane.YES_OPTION) {//만약 Yes를 누른다면
					JOptionPane.showMessageDialog(null,cartPanel.totalPrice+" 원이 결제 되었습니다!");
					//결제가 되었다는 알림 팝업
					cartPanel.initalize();//cartPanel을 초기화시키는 메서드 실행
				}
				else if(result == JOptionPane.NO_OPTION) {//만약 No를 누른다면
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
					//취소가 되었다는 알림 팝업
				}
			}
			else if(str.equals("결제취소")) {//결제취소 버튼을 눌렀을 때
				int result = JOptionPane.showConfirmDialog(null, "결제 취소하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or No 팝업창으로 최종적으로 결제취소를 할지 안할지를 판단
				if(result == JOptionPane.YES_OPTION) {//만약 Yes를 누른다면
				cartPanel.initalize();//cartPanel을 초기화시키는 메서드 실행
				JOptionPane.showMessageDialog(null, "결제 취소되었습니다.");
				}
				//No는 굳이 구현안함. 
			}
		}
	}
	class audioAction implements ActionListener{
		//추가구현사항
		//음악재생 액션 리스너입니다.
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Start" : 
				clip.start();//Start 버튼을 누르면 clip 시작
				clip.setFramePosition(0);//그리고 다시 재생 할 수 있게 FramePosition 을 0으로 세팅
				break;
			case "Stop" : 
				clip.stop();//Stop 버튼을 누르면 clip 정지
				clip.setFramePosition(0);//다시 재생 할 수 있게 FramePosition을 0으로 세팅
				break;
			}
		}
	}
}
