package animalCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimalCounterGUI extends JFrame implements ActionListener {
	
	
	JLabel welcomeMessage = new JLabel("Welcome to the Animal Counter");
	JLabel alligatorCount = new JLabel("Number of alligators: 0");
	JLabel sheepCount = new JLabel("Number of sheep: 0");
	
	JButton addAlligator = new JButton("Add alligator");
	JButton addSheep = new JButton("Add sheep");
	JButton displayCounts = new JButton("Display counts");
	JButton resetCounts = new JButton("Reset counts");
	
	JRadioButton sheepRadio = new JRadioButton("Sheep");
	JRadioButton alligatorRadio = new JRadioButton("Alligator");
	
	JButton exit = new JButton("Exit");
	
	Alligator alligator;
	Sheep sheep;
	
	public AnimalCounterGUI() {
		super("Animal Counter");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		
		sheep = new Sheep();
		alligator = new Alligator(sheep);
		
		ButtonGroup group = new ButtonGroup();
		group.add(sheepRadio);
		group.add(alligatorRadio);
		
		add(welcomeMessage);
		add(alligatorCount);
		add(sheepCount);
		add(addAlligator);
		add(addSheep);
		add(displayCounts);
		add(resetCounts);
		add(sheepRadio);
		add(alligatorRadio);
		add(exit);
		
		addAlligator.addActionListener(this);
		addSheep.addActionListener(this);
		displayCounts.addActionListener(this);
		resetCounts.addActionListener(this);
		exit.addActionListener(this);
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addAlligator) {
			alligator.incrementCount();
			alligatorCount.setText("Number of alligators: " + alligator.getCount());
			sheepCount.setText("Number of sheep: "+ sheep.getCount());
		} else if (e.getSource()== addSheep) {
			sheep.incrementCount();
			sheepCount.setText("Number of sheep: "+ sheep.getCount());
		} else if (e.getSource() == displayCounts) {
			alligatorCount.setText("Number of alligators: " + alligator.getCount());
			sheepCount.setText("Number of sheep: "+ sheep.getCount());
		} else if (e.getSource() == resetCounts) {
			if (alligatorRadio.isSelected()) {
				alligator.resetCount();
				alligatorCount.setText("Number of alligators: " + alligator.getCount());
			} else if (sheepRadio.isSelected()) {
				sheep.resetCount();
				sheepCount.setText("Number of sheep: "+ sheep.getCount());
			}
		} else if (e.getSource() == exit) {
			System.exit(0);
		}
		
		
		if (alligator.getCount() > sheep.getCount()) {
			JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators.");
		}
		if (alligator.getCount() == 0) {
			JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe.");
		}
	}
	
	
}
