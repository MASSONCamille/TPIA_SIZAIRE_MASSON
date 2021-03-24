package com.ia.tp2.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ia.tp2.model.Disque;
import com.ia.tp2.model.Tour;

public class PanelTour extends JPanel{
	private Tour t;
	
	public PanelTour(Tour t) {
		super();
		this.t = t;
		
		this.setBackground(new Color(.9f, .9f, .9f));
		this.setLayout(new GridBagLayout());
		
		
		
		switch (t.getType()) {
		case D:
			this.setBorder(BorderFactory.createTitledBorder("Depart"));
			break;
		case I:
			this.setBorder(BorderFactory.createTitledBorder("Intermediaire"));
			break;
		case A:
			this.setBorder(BorderFactory.createTitledBorder("Arrivee"));
			break;
		}
	}

	public Tour getT() {
		return t;
	}
	public void setT(Tour t) {
		this.t = t;
	}

	public void remplir() {
		this.removeAll();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		for (int i = 0; i < this.t.getPile().size(); i++) {
			JPanel pDisque = new JPanel();
			pDisque.setBackground(new Color(1f, 1f, 1f));
			pDisque.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			
			JLabel lDisque = new JLabel(""+this.t.getPile().get(i).getNum());
			pDisque.add(lDisque);
			
			c.gridy = this.t.getPile().size() - 1 - i;
			this.add(pDisque, c);
		}
	}

	@Override
	public String toString() {
		return "PanelTour [t=" + t + "]";
	}
}
