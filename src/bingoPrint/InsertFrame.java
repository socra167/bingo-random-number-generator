package bingoPrint;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertFrame extends JFrame {

	int size; // 입력받은 빙고의 행렬 크기

	private JLabel label; // 안내 라벨
	private JTextField tf; // 칸 수를 입력받을 텍스트 필드
	private JButton btn; // 확인 버튼

	public InsertFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 80);
		setLocationRelativeTo(null);
		this.setTitle("칸 수를 입력하세요");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label = new JLabel("빙고 행열 크기 입력");
		label.setFont(new Font("굴림", Font.BOLD, 20));

		tf = new JTextField(3);
		tf.setFont(new Font("굴림", Font.BOLD, 20));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(tf.getText());
				setVisible(false);
				MainFrame m = new MainFrame();
				m.setSize(size);
			}
		});

		panel.add(label);
		panel.add(tf);

		this.add(panel);
		this.setVisible(true);
	}
}
