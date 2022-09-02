package bingoPrint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	private int[] arr; // 난수가 저장된 배열
	private int cnt = 1;
	private int size = 1;

	private JLabel labelNumber; // 난수 숫자가 출력되는 라벨
	private JLabel labelRecord; // 이전 선택된 숫자가 출력되는 라벨
	private JButton btn; // 추첨 버튼

	public MainFrame() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setTitle("빙고 출력 프로그램");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// 숫자 표시 라벨
		labelNumber = new JLabel("");
		labelNumber.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));
		labelNumber.setHorizontalAlignment(JLabel.CENTER);

		// 하단 버튼
		btn = new JButton("spin");
		btn.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		btn.addActionListener(this);

		// 상단 기록 라벨
		labelRecord = new JLabel(" ");
		labelRecord.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		labelRecord.setForeground(Color.gray);

		panel.add(labelNumber);
		panel.add(btn, BorderLayout.PAGE_END);
		panel.add(labelRecord, BorderLayout.PAGE_START);

		this.add(panel);
		this.setVisible(true);

		btn.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCord = e.getKeyCode();
				switch (keyCord) {
				case KeyEvent.VK_ENTER: // Enter키 입력 이벤트
					select();
					break;
				case KeyEvent.VK_END: // End키 입력 이벤트
					cnt = 1;
					labelNumber.setText("");
					labelRecord.setText(" ");
					setSize(size);
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				}
			}
		});
	}

	public void setSize(int s) {
		size = s;
		arr = new int[s * s];

		Random rand = new Random();
		for (int i = 0; i < size * size; i++) {
			arr[i] = rand.nextInt(size * size) + 1;
			for (int j = 0; j < i; j++) { // 난수 중복 시 재생성
				if (arr[i] == arr[j]) {
					i--;
					continue;
				}
			}
		}
		labelNumber.setText(Integer.toString(arr[0]));
		labelRecord.setText(labelRecord.getText() + " " + Integer.toString(arr[0]));
	}

	private void select() {
		if (cnt == size * size)
			return;
		labelNumber.setText(Integer.toString(arr[cnt]));
		labelRecord.setText(labelRecord.getText() + " " + Integer.toString(arr[cnt]));
		cnt++;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) { // 버튼 클릭 이벤트
			select();
		}
	}
}
