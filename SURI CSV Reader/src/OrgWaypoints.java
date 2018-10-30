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
		
		
        ArrayList<Pair> wayPoints = new ArrayList<Pair>();
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
		        double average = 0;
		        double averageLong= 0;
	  	        while ((line = br.readLine()) != null) {
	  	        	
	  	            String[] points = line.split(TAB_DELIMITER);
	  	            
	  	            longitude = Double.parseDouble(points[8]);
	  	            lattitude = Double.parseDouble(points[9]);
	  	            averageLong+= longitude;
	    			average+= lattitude;
	  	            count++;
	  	            wayPoints.add(new Pair(longitude, lattitude));
	                //System.out.println("point coord long: " + longitude + "and Lat: " + lattitude);

	  	         }
	  	        System.out.println("average");
	  	        System.out.println("average for long" +averageLong/26);
  	            System.out.println("average for lat"+average/26);
  	           
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
		
		/*public static Double getP1(ArrayList<Pair>) {
			
			
			
		}*/
	  		
			
	}

			
		
		





		

		
		




