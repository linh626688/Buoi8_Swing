package com.t3h.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame {

	private MyContainer mContainer;
	private int widthFrame = 500;
	private int heightFrame = 300;

	public GUI() {
		int widthScreen = getToolkit().getScreenSize().width;
		int heightScreen = getToolkit().getScreenSize().height;

		setBounds((widthScreen - widthFrame) / 2,
				(heightScreen - heightFrame) / 2, widthFrame, heightFrame);

		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Game Form");

		mContainer = new MyContainer();
		//Buoc 4: Goi phuong thuc setDoiTuong can anh xa
		mContainer.setGUI(this);

		add(mContainer);
		addWindowListener(mAdapter);

		setVisible(true);
	}

	private WindowAdapter mAdapter = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// JOptionPane.showMessageDialog(null, "Ban co muon thoat khong?");
			int result = JOptionPane.showConfirmDialog(GUI.this,
					"Ban co muon dong chuong trinh khong?");
			if (result == JOptionPane.YES_OPTION) {
				// Dong chuong trinh
				GUI.this.dispose();
			}
		}
	};
}
