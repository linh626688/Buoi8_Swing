package com.t3h.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyContainer extends JPanel {
	private Menu mMenu;
	private PlayGame mPlayGame;
	private CardLayout mCardLayout;
	public static final String TAG_MENU = "tag_menu";
	public static final String TAG_PLAYGAME = "tag_playgame";

	// Buoc 1: Khai bao 1 thuoc tinh la doi tuong can anh xa
	private GUI gui;

	// Buoc 2: Xay dung phuong thuc set doi tuong anh xa
	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	// Buoc 3: Tim noi de goi phuong thuc setdoituong
	public MyContainer() {
		setBackground(Color.WHITE);
		mCardLayout = new CardLayout();
		setLayout(mCardLayout);

		mMenu = new Menu();
		mPlayGame = new PlayGame();

		add(mMenu, TAG_MENU);
		add(mPlayGame, TAG_PLAYGAME);

		mPlayGame.addMouseListener(mMouseAdapter);
		mMenu.addMouseListener(mMouseAdapter);

		// Hien thi PlayGame
		mCardLayout.show(this, TAG_PLAYGAME);
	}

	private MouseAdapter mMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(mPlayGame)) {
				// mCardLayout.show(MyContainer.this, TAG_MENU);

				JOptionPane.showMessageDialog(null,
						gui.getWidth() + ":" + gui.getHeight());
			
			} else if (e.getSource().equals(mMenu))
				mCardLayout.show(MyContainer.this, TAG_PLAYGAME);
			// mPlayGame.setBackground(Color.RED);
			// JOptionPane.showMessageDialog(null, e.getX()+":"+e.getY());

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// mPlayGame.setBackground(Color.WHITE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// mPlayGame.setBackground(Color.GREEN);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// mPlayGame.setBackground(Color.YELLOW);
		}
	};

}
