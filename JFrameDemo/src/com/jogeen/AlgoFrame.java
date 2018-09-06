package com.jogeen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private int canvasWidth;
	private int canvasHight;
	
	public AlgoFrame(String title,int canvasWidth,int canvasHight) {
		super(title);
		this.canvasHight=canvasHight;
		this.canvasWidth=canvasWidth;
		
		
		AlgoCanvas canvas=new AlgoCanvas();
		setContentPane(canvas);
		pack();
		setSize(canvasWidth,canvasHight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public AlgoFrame(String title) {
		this(title,1024,768);
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHight() {
		return canvasHight;
	}
	
	private class AlgoCanvas extends JPanel{
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
			g2d.setColor(Color.RED);
			Ellipse2D circle=new Ellipse2D.Double(50, 50, 300, 300);
			g2d.draw(circle);
			
			Ellipse2D circle2=new Ellipse2D.Double(60, 60, 280, 280);
			g2d.fill(circle2);
			
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHight);
		}
		

	}
	

}
