import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
	import javax.swing.filechooser.FileSystemView;

public class OrgWaypoints extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;
		JButton openButton, saveButton;
		public static File selectedFile;
		final String TAB_DELIMITER = "	";
		Scanner scanner = null;
		
		
        static ArrayList<Pair> wayPoints = new ArrayList<Pair>();
        Double longitude = 0.0;
        Double lattitude = 0.0;
       
        private JPanel mainplot;
        private JFrame mainframe;

        public OrgWaypoints(JPanel mainplot, JFrame mainframe) {
            this.mainplot = mainplot;
            this.mainframe = mainframe;
        }

        
        int count = 0;
	      public void actionPerformed(ActionEvent e) {
	    	  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	  		int returnValue = jfc.showOpenDialog(null);
	  		if (returnValue == JFileChooser.APPROVE_OPTION) {
	  			selectedFile = jfc.getSelectedFile();
	  			System.out.println(selectedFile.getAbsolutePath());
	  			}				
	  		try {
	  	        InputStream ips = new FileInputStream(selectedFile.getAbsolutePath());
	  	        InputStreamReader ipsr = new InputStreamReader(ips);
	  	        BufferedReader br = new BufferedReader(ipsr);
	  	        String line;
		        //double average = 0;
		        //double averageLong= 0;
	  	        while ((line = br.readLine()) != null) {
	  	        	
	  	            String[] points = line.split(TAB_DELIMITER);
	  	            
	  	            longitude = Double.parseDouble(points[8]);
	  	            lattitude = Double.parseDouble(points[9]);
	  	            
	  	            String str1 = Double.toString(longitude);
	  	 	        String str2 = Double.toString(lattitude);
	  	 	    
	  	 	        String str11 = str1.substring(str1.indexOf('.') +1);
	  	 	        String str21 = str2.substring(str2.indexOf('.') +1);
	  	 	    
	  	 	        longitude = (double) Integer.parseInt(str11);
	  	 	        lattitude = (double) Integer.parseInt(str21);
	  	 	    
	  	 	    
	  	            //averageLong+= longitude;
	    			//average+= lattitude;
	  	            //count++;
	  	            wayPoints.add(new Pair(longitude, lattitude));
	                //System.out.println("point coord long: " + longitude + "and Lat: " + lattitude);

	  	         }
	  	      /*  System.out.println("average");
	  	        System.out.println("average for long" +averageLong/26);
  	            System.out.println("average for lat"+average/26);*/
  	          NormalizeWayPoints();
  	          mainplot.revalidate();
  	          mainplot.repaint();

  	        mainframe.revalidate();
  	        mainframe.repaint();
  	        
	  	        br.close();
	  	    } catch (Exception e1) {
	  	        e1.printStackTrace();
	  	    }
		
		}
	     
	      
	    public void drawWayPoints() {
	    	
	    	
	    }
	    
	//    public double accuracy() {
	    	
	   // }
	    
		public  ArrayList<Pair> getWayPoints() {
			
			return wayPoints;
		}
	public static void NormalizeWayPoints (){
			
		    //Iterator<Pair> iterator = FlightData.log.iterator();
		    Iterator<Pair> iterator = OrgWaypoints.wayPoints.iterator();
		    
			
		    while (iterator.hasNext()) {
	 		
	 		Pair pair = iterator.next();
	 		
	 		System.out.println(pair.getP1() );
	 		long constant = (long) 1E8;
	 		
	 		double x2 = Math.abs(pair.getP1())/constant;
	 		double y2 = Math.abs(pair.getP2())/constant;
	 		
	 		
	 	    String str1 = Double.toString(x2);
	 	    String str2 = Double.toString(y2);
	 	    
	 	    System.out.println(str1.length());
	 	    if(str1.length()>7 && str2.length()>7 ) {
	 	    
	 	    //String str11 = str1.substring(str1.indexOf('.'), str1.indexOf('.') +6);
	 	    //String str21 = str2.substring(str2.indexOf('.'), str2.indexOf('.') + 6);
	 	    	
	 	    StringBuilder strb1 = new StringBuilder(str1);
	  	    StringBuilder strb2 = new StringBuilder(str2);
	  		
	 	    strb1.deleteCharAt(str1.indexOf('.'));
	 	    strb2.deleteCharAt(str2.indexOf('.'));
	 	    String str11 = strb1.toString();
	 	    String str21 = strb2.toString();
	 	    
	 	    str11 = str11.substring(0, str11.length());
	 	    str21 = str21.substring(1, str21.length());
	 	    	
	 	    	
	 	    int x22 = Integer.parseInt(str11);
	 	    int y22 = Integer.parseInt(str21);
	 	    
	 	   System.out.println("this is it x = "+ x22);
		   System.out.println("this is it y = "+ y22);
		
	 	    }
	 	    
	 	    
	 	    
	 	    
	 		/*if(counter ==0) {
	 			  point1 = pair2.getP1();
	 			  point2 = pair2.getP2();
	 		}
	 		
	 		double x1 = pair2.getP1()-point1;
	 		double y2 = pair2.getP2()-point2;*/
	 		
	 		
	 		
			/*	if(x>0) {
				 x-=constvalue1;
				 x-=constvalue3;
				 x*=120;
				}
				if(y>0) {
				y-=constvalue2;
				y-=constvalue4;
				y*=120;
				}*/
					//pnlOne.revalidate();
			   // pnlOne.repaint();
			   // this.setVisible(true);

				//.draw(new Line2D.Double( Math.abs(pair.getP1()), Math.abs(pair.getP2()),  Math.abs(pair.getP1()), Math.abs(pair.getP2())));
				// g2d.drawLine();
	 		
				
			}
			
	}
		
		/*public static Double getP1(ArrayList<Pair>) {
			
			
			
		}*/
	  		
			
	}

			
		
		





		

		
		




