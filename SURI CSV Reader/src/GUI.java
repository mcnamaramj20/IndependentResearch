	//jtable for representing whatever needs to be put in a table
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

	/**
	 * @author Michael McNamara
	 *
	 */
	public class GUI extends JFrame implements Runnable{
		private static final long serialVersionUID = 1L;
		public static final int WIDTH = 1920;
		public static final int HEIGHT = 1080;
		

		private JPanel pnlTwo;
		private JPanel pnlFour;
		private JPanel pnlFive;
		private JPanel pnlBtn;
		
		private JButton flightData;	
		private JButton OrgWaypoints;
		private JButton calAccuracy;
		
	    FlightData flightdatavar = new FlightData(pnlBtn, null);
			
	    DrawPane pnlOne = new DrawPane();//createPanel(Color.WHITE);
		
	    OrgWaypoints waypoint = new OrgWaypoints(pnlOne,this);
	    FlightData flightdata1 = new FlightData(pnlOne, this);
		    
		public GUI(String arg0) throws HeadlessException {
			super(arg0);
		}
		
		public void createGUI() {
			setSize(WIDTH, HEIGHT);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setLayout(new BorderLayout());
		    
		    pnlTwo = createPanel(Color.LIGHT_GRAY);
		    pnlFour = createPanel(Color.LIGHT_GRAY);
		    pnlFive = createPanel(Color.LIGHT_GRAY);
		    pnlBtn = createPanel(Color.BLACK);
		    
		    
		    
		    flightData = createButton("Load flightdata file");
		    OrgWaypoints = createButton("load waypoints");
		    calAccuracy = createButton("Calculate Accuracy");
		    layoutButtonPanel(); 
		    
		    this.getContentPane().add(pnlBtn,BorderLayout.NORTH);
		   //this.getContentPane().add(pnlFour,BorderLayout.EAST);
		   // this.getContentPane().add(pnlFive,BorderLayout.WEST);
		   // repaint(); 
		    
		    
			
		  
		    flightData.addActionListener(flightdatavar); 
		    OrgWaypoints.addActionListener(waypoint);
		    calAccuracy.addActionListener(new DrawPlot());
			  
		    this.getContentPane().add(pnlOne,BorderLayout.CENTER);
		    //pnlOne.revalidate();
		    //pnlOne.repaint();
		   // this.getContentPane().add(pnlTwo,BorderLayout.NORTH);
			
		    
		    this.setVisible(true);
		}
	
		
		private JPanel createPanel(Color c) {
			JPanel jp = new JPanel();
			jp.setBackground(c);
			return jp;
		}
	
		private JButton createButton(String str) {
			JButton jb = new JButton(str); 
			return jb; 
		}
		
		
		private void layoutButtonPanel() {
			GridBagLayout layout = new GridBagLayout();
		    pnlBtn.setLayout(layout);
		    
		    //add components to grid
		    GridBagConstraints constraints = new GridBagConstraints(); 
		    
		    //Defaults
		    constraints.fill = GridBagConstraints.NONE;
		    constraints.anchor = GridBagConstraints.CENTER;
		    constraints.weightx = 300;
		    constraints.weighty = 300;		    
		  
		    addToPanel(pnlBtn, flightData, constraints,4,1,3,2); 
		    addToPanel(pnlBtn, OrgWaypoints, constraints, 20, 1, 3, 2);
		    addToPanel(pnlBtn, calAccuracy, constraints, 10, 1, 3, 2);
		    
		}
	   private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints, int x, int y, int w, int h) {  
	      constraints.gridx = x;
	      constraints.gridy = y;
	      constraints.gridwidth = w;
	      constraints.gridheight = h;
	      jp.add(c, constraints);
	      		      
	   }
	   
		public void run() {
			createGUI(); 	
			
		}
		
		 public class DrawPane extends JPanel{
			 public void paintComponent(Graphics g){
				 //draw on g here e.g.
				 
		        	 super.paintComponents(g);

					    Graphics2D g2d = (Graphics2D) g;
					    Graphics2D g3d = (Graphics2D) g;
					    g2d.setColor(Color.blue);
					    g3d.setColor(Color.red);
					  // draw(g2d);
					    
					    Iterator<Pair> iterator = waypoint.wayPoints.iterator();
					    Iterator<Pair> iterator2 = flightdata1.log.iterator();

					    while (iterator2.hasNext()) {
			        		
			        		Pair pair2 = iterator2.next();
			        		//System.out.println("test");
			        		int constvalue = 1000;
			        		int constvalue1 = constvalue*36;
			        		int constvalue2 = constvalue*76;
			        		int constvalue3 = 1790;
			        		int constvalue4 = 3436;
			        		double x =Math.abs(pair2.getP1()*constvalue);//normalize here
			        		double y = Math.abs(pair2.getP2()*constvalue);//normalize here
			    			if(x>0) {
			    			 x-=constvalue1;
			    			 x-=constvalue3;
			    			 x*=120;
			    			}
			    			if(y>0) {
			    			y-=constvalue2;
			    			y-=constvalue4;
			    			y*=120;
			    			}
			    			System.out.println("x = "+ x);
			    			System.out.println("y = "+ y);
			    			g3d.drawOval((int)x, (int)y, 5, 5);
			    			//pnlOne.revalidate();
			    		   // pnlOne.repaint();
			    		   // this.setVisible(true);

			    			//.draw(new Line2D.Double( Math.abs(pair.getP1()), Math.abs(pair.getP2()),  Math.abs(pair.getP1()), Math.abs(pair.getP2())));
			    			 //g2d.drawLine();
			    			
			    		}
			 
			        	while (iterator.hasNext()) {
			        		
			        		Pair pair = iterator.next();
			        		//System.out.println("test");
			        		int constvalue = 1000;
			        		int constvalue1 = constvalue*36;
			        		int constvalue2 = constvalue*76;
			        		int constvalue3 = 1790;
			        		int constvalue4 = 3436;
			        		double x =Math.abs(pair.getP1()*constvalue);//normalize here
			        		double y = Math.abs(pair.getP2()*constvalue);//normalize here
			    			if(x>0) {
			    			 x-=constvalue1;
			    			 x-=constvalue3;
			    			 x*=120;
			    			}
			    			if(y>0) {
			    			y-=constvalue2;
			    			y-=constvalue4;
			    			y*=120;
			    			}
			    			System.out.println(x);
			    			System.out.println(y);
			    			//draw(g2d);
			    			 //g.fillRect(0,  0,  (int)Math.abs(pair.getP1()),  (int)Math.abs(pair.getP2()));
			    			g2d.drawOval((int)x, (int)y, 5, 5);
			    			//pnlOne.revalidate();
			    		   // pnlOne.repaint();
			    		   // this.setVisible(true);

			    			//.draw(new Line2D.Double( Math.abs(pair.getP1()), Math.abs(pair.getP2()),  Math.abs(pair.getP1()), Math.abs(pair.getP2())));
			    			 //g2d.drawLine();
			    			
			    		}
			        	
			        	
		         }
		 }

			/*private void draw(Graphics2D g2d) {
				
				for (int i = 0; i <= 100000; i++) {
					
				  Dimension size = getSize();
				  
				  int w = size.width ;
				  int h = size.height;
				  Random r = new Random();
				  
				  int x = Math.abs(r.nextInt()) % w;
				  int y = Math.abs(r.nextInt()) % h;
				  
				  g2d.drawLine(x, y, x, y);
				  
			}*/
				
		
		      
	}
		 






