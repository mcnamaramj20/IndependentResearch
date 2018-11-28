import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
	import javax.swing.filechooser.FileSystemView;

public class FlightData extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;
		JButton openButton, saveButton;
		public static File selectedFile;
		final String COMMA_DELIMITER = ",";
		Scanner scanner = null;
		
		
        static ArrayList<Pair> log = new ArrayList<Pair>();
        String lng = "lng";
        String lat = "lat";
        Double longitude = 0.0;
        Double lattitude = 0.0;
        int count = 0;
        
        private JPanel mainplot;
        private JFrame mainframe;
        
        public FlightData(JPanel mainplot, JFrame mainframe) {
            this.mainplot = mainplot;
            this.mainframe = mainframe;
        }
	      public void actionPerformed(ActionEvent e) {
	    	  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	  		int returnValue = jfc.showOpenDialog(null);
	  		if (returnValue == JFileChooser.APPROVE_OPTION) {
	  			selectedFile = jfc.getSelectedFile();
	  			System.out.println(selectedFile.getAbsolutePath());
	  			}				
			try {
				
				scanner = new Scanner(FlightData.selectedFile);
				scanner.useDelimiter(COMMA_DELIMITER);
				while(scanner.hasNext()) 
				{	
					String temp = scanner.next();
					Double tempDouble;
					
					if (temp.equals(lng)) {
		                longitude = scanner.nextDouble();
		                longitude.shortValue();
					}
		            if (temp.equals(lat)) {
		                lattitude = scanner.nextDouble();
		                lattitude.shortValue();
		            }
		                log.add(new Pair(longitude, lattitude));
		                count++;
		               // System.out.println("point coord long: " + longitude + "and Lat: " + lattitude);

			}
				  //mainplot.revalidate();
	  	          //mainplot.repaint();

	  	        //mainframe.revalidate();
	  	        //mainframe.repaint();
			//	System.out.println(count);
				NormalizeFlightData();
				
			}
			
			catch (FileNotFoundException fe) 
			{
				fe.printStackTrace();
			}
			finally
			{
				scanner.close();
			}
		
		}
		public ArrayList<Pair> getLog() {
			return log;
		}  
		
		public static void NormalizeFlightData (){
			
		    //Iterator<Pair> iterator = FlightData.log.iterator();
		    Iterator<Pair> iterator2 = FlightData.log.iterator();
		    
			
		    while (iterator2.hasNext()) {
	 		
	 		Pair pair2 = iterator2.next();
	 		
	 		System.out.println(pair2.getP1() );
	 		long constant = (long) 1E8;
	 		
	 		double x2 = Math.abs(pair2.getP1())/constant;
	 		double y2 = Math.abs(pair2.getP2())/constant;
	 		
	 		
	 	    String str1 = Double.toString(x2);
	 	    String str2 = Double.toString(y2);
	 	    
	 	   // System.out.println(str1.length());
	 	    if(str1.length()>7 && str2.length()>7 ) {
	 	    
	 	    //String str11 = str1.substring(str1.indexOf('.'), str1.indexOf('.') +6);
	 	    //String str21 = str2.substring(str2.indexOf('.'), str2.indexOf('.') + 6);
	 	    	
	 	    StringBuilder strb1 = new StringBuilder(str1);
	  	    StringBuilder strb2 = new StringBuilder(str2);
	  		
	 	    strb1.deleteCharAt(str1.indexOf('.'));
	 	    strb2.deleteCharAt(str2.indexOf('.'));
	 	    String str11 = strb1.toString();
	 	    String str21 = strb2.toString();
	 	    
	 	    str11 = str11.substring(0, 6);
	 	    str21 = str21.substring(0, 6);
	 	    	
	 	    	
	 	    int x22 = Integer.parseInt(str11);
	 	    int y22 = Integer.parseInt(str21);
	 	    
	 	   //System.out.println("x = "+ x22);
		   //System.out.println("y = "+ y22);
		
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
}

			
		
		





		

		
		




