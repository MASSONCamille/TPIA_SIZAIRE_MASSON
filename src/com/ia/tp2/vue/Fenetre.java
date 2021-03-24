package com.ia.tp2.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.ia.tp2.model.Disque;
import com.ia.tp2.model.EtatJeu;
import com.ia.tp2.model.Tour;
import com.ia.tp2.model.TypeTour;

import javafx.scene.layout.Pane;

public class Fenetre extends JFrame implements ActionListener{
	
	private JPanel main_panel;
	private JPanel panel_jeu;
	private JButton button;
	private ArrayList<PanelTour> lstPanelTour;
	
	public Fenetre() {
		super();
		this.setTitle("Tour de Hanoi");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_panel = new JPanel();
		main_panel.setBackground(new Color(1f, 1f, 1f));
		main_panel.setLayout(new GridBagLayout());
		
		
		button = new JButton("Pause 3sec");
		button.setPreferredSize(new Dimension(100, 50));
		button.addActionListener(this);
		
		
		panel_jeu = new JPanel();
		panel_jeu.setPreferredSize(new Dimension(1500, 600));
		panel_jeu.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		lstPanelTour = new ArrayList<PanelTour>();
		lstPanelTour.add(new PanelTour(new Tour(TypeTour.D)));
		lstPanelTour.add(new PanelTour(new Tour(TypeTour.I)));
		lstPanelTour.add(new PanelTour(new Tour(TypeTour.A)));
		
		Stack<Disque> pdd = new Stack<Disque>();
		for (int i = 0; i < 3; i++) {
			pdd.push(new Disque(3 - i));
		}
		lstPanelTour.get(0).getT().setPile(pdd);
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		for (int i = 0; i < 3; i++) {
			lstPanelTour.get(i).remplir();
			gbc.gridx = i;
			gbc.gridy = 0;
			panel_jeu.add(lstPanelTour.get(i), gbc);
		}
		
	
		
		GridBagConstraints mc = new GridBagConstraints();
		mc.gridx = 0;
		mc.gridy = 0;
		main_panel.add(panel_jeu, mc);
		mc.gridy = 1;
		main_panel.add(button, mc);
		
		this.add(main_panel, BorderLayout.CENTER);
	}
	
	public void affiche() {
		this.pack();
		this.setVisible(true);
	}
	
	public void actualiser(EtatJeu j) {
		EtatJeu eJ = new EtatJeu(j);
		this.lstPanelTour.get(0).setT(eJ.getDepart());
		this.lstPanelTour.get(1).setT(eJ.getIntermediaire());
		this.lstPanelTour.get(2).setT(eJ.getArrivee());
		
		for (int i = 0; i < 3; i++) {
			lstPanelTour.get(i).remplir();
		}
		
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
