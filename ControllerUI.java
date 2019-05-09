

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.security.MessageDigest;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ControllerUI extends JPanel {
	
	static String input = "01112131415191A103313323380090083C300";
	static int xPosition = 75;

	
	public void paintComponent (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// ============== OUTLINE ===============
		g2.setColor(Color.BLACK);
		g2.drawRect(100, 75, 800, 500);
		// ============== TRIGGERS ===============
		g2.setColor(Color.YELLOW);
		g2.drawRect(200, 49, 100, 25); //left trigger
		g2.drawRect(700, 49, 100, 25); //right trigger
		// ============== VERTICAL ===============
		g2.setColor(Color.RED);
		g.drawPolygon(new int[] {238, 250 ,262}, new int[] {125, 100 ,125}, 3); // left up
		g.drawPolygon(new int[] {238, 250 ,262}, new int[] {150, 175 ,150}, 3); // left down
		g.drawPolygon(new int[] {738, 750 ,762}, new int[] {125, 100 ,125}, 3); // right up
		g.drawPolygon(new int[] {738, 750 ,762}, new int[] {150, 175 ,150}, 3); // right down
		// ============== 5 WAY SWITCHES ===============
		g2.setColor(Color.BLACK);
		//5 way 1
		g.drawPolygon(new int[] {238, 250 ,262}, new int[] {225, 200 ,225}, 3); // up
		g.drawPolygon(new int[] {238, 250 ,262}, new int[] {270, 295 ,270}, 3); // down
		g.drawPolygon(new int[] {228, 203 ,228}, new int[] {235, 247, 259}, 3); // left
		g.drawPolygon(new int[] {273, 298, 273}, new int[] {235, 247 ,259}, 3); // right	
		g.drawOval(238, 235, 25, 25); //pressed
		// 5 way 2
		g.drawPolygon(new int[] {338, 350 ,362}, new int[] {325, 300 ,325}, 3); // up
		g.drawPolygon(new int[] {338, 350 ,362}, new int[] {370, 395 ,370}, 3); // down
		g.drawPolygon(new int[] {328, 303 ,328}, new int[] {335, 347, 359}, 3); // left
		g.drawPolygon(new int[] {373, 398, 373}, new int[] {335, 347 ,359}, 3); // right	
		g.drawOval(338, 335, 25, 25); //pressed		
		// 5 way 3
		g.drawPolygon(new int[] {738, 750, 762}, new int[] {225, 200 ,225}, 3); // up
		g.drawPolygon(new int[] {738, 750, 762}, new int[] {270, 295 ,270}, 3); // down
		g.drawPolygon(new int[] {728, 703, 728}, new int[] {235, 247, 259}, 3); // left
		g.drawPolygon(new int[] {773, 798, 773}, new int[] {235, 247 ,259}, 3); // right
		g.drawOval(738,235,25,25); //pressed
		// ============== HORIZONTAL SCROLL ======================
		// ============== BUTTONS ===============
		g2.setColor(Color.BLUE);
		g.drawOval(600, 450, 75, 75); // button 4
		g.drawOval(500, 350, 75, 75); // button 5
		g.drawOval(350, 450, 75, 75); // button 2
		g2.setColor(Color.YELLOW);
		g.drawOval(750, 450, 75, 75); // button 6
		g2.setColor(Color.RED);
		g.drawOval(200, 400, 75, 75); // button 1
		g.drawOval(450, 225, 75, 75); // button 3
		
		 
		
		// =============== CHECKS ====================

		// =============== BUTTONS ====================
		
		g2.setColor(Color.RED);
		if(input.substring(1, 2).equals("E")) 
			g.fillOval(200, 400, 75, 75); // button 3	
		g2.setColor(Color.BLUE);
		if(input.substring(3, 4).equals("E")) 
			g.fillOval(350, 450, 75, 75); // button 4
		g2.setColor(Color.RED);
		if(input.substring(5, 6).equals("E")) 
			g.fillOval(450, 225, 75, 75); // button 1 
		g2.setColor(Color.YELLOW);
		if(input.substring(11, 12).equals("E")) 
			g.fillOval(750, 450, 75, 75); // button 6
		g2.setColor(Color.BLUE);
		if(input.substring(7, 8).equals("E")) 
			g.fillOval(500, 350, 75, 75); // button 2
		g2.setColor(Color.BLUE);
		if(input.substring(9, 10).equals("E")) 
			g.fillOval(600, 450, 75, 75); // button 5
		
		// =============== TRIGGERS ====================
		g2.setColor(Color.YELLOW);
		if(input.substring(13, 14).equals("E"))
			g2.fillRect(200, 49, 100, 25); //left trigger
		if(input.substring(15, 16).equals("E"))
			g2.fillRect(700, 49, 100, 25); //right trigger
		
		// ================ 5 WAY SWITCHES ====================
		//5 way 1
		g2.setColor(Color.RED);
		switch(input.substring(17,19)) {
			case "AA": // left
				g.fillPolygon(new int[] {228, 203 ,228}, new int[] {235, 247, 259}, 3); // left
				break;
			case "5A": // right
				g.fillPolygon(new int[] {273, 298, 273}, new int[] {235, 247 ,259}, 3); // right
				break;
			case "55": // up
				g.fillPolygon(new int[] {238, 250 ,262}, new int[] {225, 200 ,225}, 3); // up
				break;
			case "A5": // down
				g.fillPolygon(new int[] {238, 250 ,262}, new int[] {270, 295 ,270}, 3); // down
				break;	
			case "CC": // pressed
				g.fillOval(238, 235, 25, 25); //pressed
				break;
			default:
				break;
		}
		switch(input.substring(20,22)) {
			case "AA": // left
				g.fillPolygon(new int[] {328, 303 ,328}, new int[] {335, 347, 359}, 3); // left
				break;
			case "5A": // right
				g.fillPolygon(new int[] {373, 398, 373}, new int[] {335, 347 ,359}, 3); // right
				break;
			case "55": // up
				g.fillPolygon(new int[] {338, 350 ,362}, new int[] {325, 300 ,325}, 3); // up
				break;
			case "A5": // down
				g.fillPolygon(new int[] {338, 350 ,362}, new int[] {370, 395 ,370}, 3); // down
				break;	
			case "CC": // pressed
				g.fillOval(338, 335, 25, 25); //pressed
				break;
			default:
				break;
		}
		switch(input.substring(23,25)) {
			case "AA": // left
				g.fillPolygon(new int[] {728, 703, 728}, new int[] {235, 247, 259}, 3); // left
				break;
			case "5A": // right
				g.fillPolygon(new int[] {773, 798, 773}, new int[] {235, 247 ,259}, 3); // right
				break;
			case "55": // up
				g.fillPolygon(new int[] {738, 750, 762}, new int[] {225, 200 ,225}, 3); // up
				break;
			case "A5": // down
				g.fillPolygon(new int[] {738, 750, 762}, new int[] {270, 295 ,270}, 3); // down
				break;	
			case "CC": // pressed
				g.fillOval(738, 235, 25, 25); //pressed
				break;
			default:
				break;
		}
		g2.setColor(Color.BLACK);
		// ============== SLEW ===============
		g2.drawString(Short.valueOf(input.substring(26,28),16).byteValue() + ", "
				+ Short.valueOf(input.substring(29,31),16).byteValue(), 725 , 350);
		
		// ============== VERTICAL SCROLL ======================
		g2.setColor(Color.RED);
		switch(input.substring(31,33)) {
			case "B0": // up
				g.fillPolygon(new int[] {238, 250 ,262}, new int[] {125, 100 ,125}, 3); 
				break;
			case "8C": // down
				g.fillPolygon(new int[] {238, 250 ,262}, new int[] {150, 175 ,150}, 3); 
				break;
			default:
				break;
		}
		switch(input.substring(33,35)) {
			case "F0": // up
				g.fillPolygon(new int[] {738, 750 ,762}, new int[] {125, 100 ,125}, 3);
				break;
			case "CC": // down
				g.fillPolygon(new int[] {738, 750 ,762}, new int[] {150, 175 ,150}, 3);
				break;
			default:
				break;
		}
		
		// ============== HORIZONTAL SCROLL ======================
		
		g2.setColor(Color.BLACK);
		g2.drawString(Short.valueOf(input.substring(35,37),16).byteValue() + "" , 200, 350);
		
	}

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = InetAddress.getByName("169.254.67.28");
		System.out.println(ip);
		try {
			int port = 4321;
			DatagramSocket serverSocket = new DatagramSocket(port,ip);
			byte[] buf = new byte[256];
			
			ControllerUI ui = new ControllerUI();
			JFrame frame = new JFrame("controller ui");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(ui);
			frame.setSize(1000, 750);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
				
				serverSocket.receive(receivePacket);
				input = new String(receivePacket.getData());
				System.out.println("RECEIVED: " + input);
				
				
				frame.revalidate();
				frame.repaint();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
