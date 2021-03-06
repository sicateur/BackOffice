package com.massconnections.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.massconnections.Domains.Crowd;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	public static JPanel contentPane;
	public static JPanel bodyPanel;
	public static Crowd currentUser;

	public static Crowd getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Crowd currentUser) {
		MainFrame.currentUser = currentUser;
	}

	private static MainFrame mainFrameInstance;

	/**
	 * Create the frame.
	 */
	private MainFrame(final Crowd currentUser) {
		this.currentUser = currentUser;
		setTitle("MassConnections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(27, 188, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

		final JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE,
								213, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, 722,
								Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane
				.createParallelGroup(Alignment.TRAILING)
				.addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, 451,
						Short.MAX_VALUE)
				.addComponent(menuPanel, Alignment.LEADING,
						GroupLayout.PREFERRED_SIZE, 451, Short.MAX_VALUE));

		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/menu.png")));

		JButton labelProject = new JButton("");

		labelProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("projects"));
				bodyPanel.repaint();
				bodyPanel.revalidate();
			}
		});
		labelProject.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/project.png")));

		JButton labelChallenge = new JButton("");
		labelChallenge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("challenges"));
				bodyPanel.repaint();
				bodyPanel.revalidate();
			}
		});
		labelChallenge.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/challenge.png")));

		JButton labelUser = new JButton("");
		labelUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("crowds"));
				bodyPanel.repaint();
				bodyPanel.revalidate();
			}
		});
		labelUser.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/users.png")));

		JButton labelStat = new JButton("");
		labelStat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new StatPanel());
				bodyPanel.repaint();
				bodyPanel.revalidate();
			}
		});
		labelStat.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/stat.png")));

		JButton labelMessage = new JButton("");
		labelMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bodyPanel.removeAll();
				bodyPanel.add(new MessagePanel(currentUser));
				bodyPanel.repaint();
				bodyPanel.revalidate();

			}
		});
		labelMessage.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/msg.png")));

		JButton lblLogout = new JButton("");
		lblLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AuthentificationFrame().setVisible(true);
			}
		});
		lblLogout.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/signout.png")));

		JButton btnCateg = new JButton("");
		btnCateg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new CategoriesPanel());
				bodyPanel.repaint();
				bodyPanel.revalidate();

			}
		});
		btnCateg.setIcon(new ImageIcon(MainFrame.class
				.getResource("/com/massconnections/img/Manage cat.png")));

		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(gl_menuPanel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_menuPanel
						.createSequentialGroup()
						.addGroup(
								gl_menuPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLogout,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(labelMessage,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(labelStat,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(labelUser,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(labelChallenge,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(labelProject,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(lblMenu,
												Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE,
												211, Short.MAX_VALUE)
										.addComponent(btnCateg,
												GroupLayout.PREFERRED_SIZE, 1,
												Short.MAX_VALUE))
						.addContainerGap()));
		gl_menuPanel.setVerticalGroup(gl_menuPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_menuPanel
						.createSequentialGroup()
						.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(labelProject, GroupLayout.PREFERRED_SIZE,
								63, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(labelChallenge,
								GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(labelUser, GroupLayout.PREFERRED_SIZE,
								63, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(labelStat, GroupLayout.PREFERRED_SIZE,
								63, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(labelMessage, GroupLayout.PREFERRED_SIZE,
								63, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(btnCateg, GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 1,
								Short.MAX_VALUE)
						.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE,
								63, GroupLayout.PREFERRED_SIZE).addGap(1)));
		menuPanel.setLayout(gl_menuPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(gl_contentPane);

	}

	public static MainFrame getInstance(Crowd currentUser) {
		if (mainFrameInstance == null) {
			mainFrameInstance = new MainFrame(currentUser);
		} else {
			mainFrameInstance.setCurrentUser(currentUser);
		}
		return mainFrameInstance;

	}
}
