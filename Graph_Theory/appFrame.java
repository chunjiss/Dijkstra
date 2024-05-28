package ThanhThuy_Graph_Theory;

import javax.swing.JFrame;

public class appFrame extends JFrame {
	MyPanel myPanel;
	public appFrame() {
		myPanel = new MyPanel();
		this.add(myPanel);
		this.setTitle("Graph App by ThanhThuy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new appFrame();
	}

}
