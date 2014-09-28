package com.n9mtq4.math.lib.parts;

import com.n9mtq4.math.lib.Main;
import com.n9mtq4.math.lib.parts.manager.EditPoint2d;
import com.n9mtq4.math.lib.parts.manager.NewPoint2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Will on 9/4/14.
 */
public class PartManager {
	
	public ArrayList<Point2d> point2d = new ArrayList<Point2d>();
	public ArrayList<LineSegment2d> lineSegment2d = new ArrayList<LineSegment2d>();
	public ArrayList<Arc2d> arc2d = new ArrayList<Arc2d>();
	
	public PartManager() {
		
	}
	
	public void managerAll() {
		
		JFrame frame = new JFrame("Object Manager");
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String text = ((JButton) actionEvent.getSource()).getText();
				if (text.equalsIgnoreCase("point manager")) {
					pointManager();
				}else if (text.equalsIgnoreCase("line segment manager")) {
					newLineSegment();
				}else if (text.equalsIgnoreCase("arc manager")) {
					arcManager();
				}
			}
		};
		
		JPanel panel = new JPanel(new GridLayout(3, 1));
		JButton[] buttons = new JButton[3];
		JScrollPane scroll = new JScrollPane(panel);
		buttons[0] = new JButton("Point Manager");
		buttons[1] = new JButton("Line Segment Manager");
		buttons[2] = new JButton("Arc Manager");
		for (JButton b : buttons) {
			b.addActionListener(al);
			panel.add(b);
		}
		
		frame.add(scroll);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.setSize(200, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void arcManager() {
		
	}
	
	public void pointManager() {
		
		JFrame frame = new JFrame("Points");
		
		JPanel[] panels = new JPanel[2];
		JButton[] buttons = new JButton[3];
		JScrollPane[] scrolls = new JScrollPane[2];
		JPanel main = new JPanel(new GridLayout(1, 2));
		
		Object[] o = new Object[point2d.size()];
		for (int i = 0; i < o.length; i++) {
			o[i] = point2d.get(i).getLabel();
		}
		
		final JList list = new JList();
		list.setListData(o);
		
		panels[0] = new JPanel(new GridLayout(3, 1));
		panels[1] = new JPanel(new GridLayout(1, 1));
		
		buttons[0] = new JButton("New");
		buttons[1] = new JButton("Edit");
		buttons[2] = new JButton("Delete");
		for (JButton b : buttons) {
			panels[0].add(b);
		}
		panels[1].add(list);
		
		scrolls[0] = new JScrollPane(panels[0]);
		scrolls[1] = new JScrollPane(panels[1]);
		
		main.add(scrolls[0]);
		main.add(scrolls[1]);
		
		frame.add(main);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(350, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(Main.getWindow().getDisplay());
		frame.setVisible(true);
		
		ActionListener buttonAL = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String text = ((JButton) actionEvent.getSource()).getText();
				if (text.equalsIgnoreCase("new")) {
					newPoint2d();
				}else if (text.equalsIgnoreCase("edit")) {
					String select = (String) ((JList) actionEvent.getSource()).getSelectedValue();
					Point2d point = null;
					for (Point2d p : point2d) {
						if (p.getLabel().equalsIgnoreCase(select)) {
							point = p;
						}
					}
					if (point != null) {
//						TODO: open editor
					}else {
						System.out.println("Error");
						return;
					}
				}
			}
		};
		for (JButton b : buttons) {
			b.addActionListener(buttonAL);
		}
		
	}
	
	public void newPoint2d() {
		
		new NewPoint2d(this);
		
	}
	
	public void newPoint2d(String x, String y) {
		
		NewPoint2d p = new NewPoint2d(this, true);
		p.setDefaultx(x);
		p.setDefaulty(y);
		p.invoke();
		
	}
	
	public void editPoint2d(Point2d point) {
		
		new EditPoint2d(this, point);
		
	}
	
	public void newLineSegment() {
		
		JFrame frame = new JFrame("new lineseg");
		final JTextField[] fields = new JTextField[7];
		JRadioButton[] toggles = new JRadioButton[6];
		JPanel panel = new JPanel(new GridLayout(8, 1));
		JScrollPane scroll = new JScrollPane(panel);
		JButton ok = new JButton("Add");
		
		fields[0] = new JTextField(); //x
		fields[1] = new JTextField(); //y
		fields[2] = new JTextField(); //x1
		fields[3] = new JTextField(); //y1
		fields[4] = new JTextField(); //r
		fields[5] = new JTextField(); //g
		fields[6] = new JTextField(); //b
		
		for (JTextField f : fields) {
			panel.add(f);
		}
		panel.add(ok);
		
		frame.add(scroll);
		
//		TODO: change to DISPOSE_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(200, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					
					double x = Double.parseDouble(fields[0].getText());
					double y = Double.parseDouble(fields[1].getText());
					double x1 = Double.parseDouble(fields[2].getText());
					double y1 = Double.parseDouble(fields[3].getText());
					int r = Integer.parseInt(fields[4].getText());
					int g = Integer.parseInt(fields[5].getText());
					int b = Integer.parseInt(fields[6].getText());
					
					if (x + 5 > Main.getWindow().getDisplay().getWidth() / 2 || x - 5 < -Main.getWindow().getDisplay().getWidth()) {
						new TextArea("x coord is out of bounds");
						return;
					}
					if (y + 5 > Main.getWindow().getDisplay().getHeight() / 2 || y - 5 < -Main.getWindow().getDisplay().getHEIGHT()) {
						new TextArea("y coord is out of bounds");
						return;
					}
					
					lineSegment2d.add(new LineSegment2d(x, y, x1, y1, new Color(r, g, b), true));
					
				}catch (NumberFormatException e) {
					System.out.println("error");
				}
			}
		});
		
	}
	
}
