import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
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
		
		
        ArrayList<Pair> log = new ArrayList<Pair>();
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
					}
		            if (temp.equals(lat)) {
		                lattitude = scanner.nextDouble();
		            }
		                log.add(new Pair(longitude, lattitude));
		                count++;
		                System.out.println("point coord long: " + longitude + "and Lat: " + lattitude);

			}
				mainplot.revalidate();
	  	          mainplot.repaint();

	  	        mainframe.revalidate();
	  	        mainframe.repaint();
				System.out.println(count);
				
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
			
	}

			
		
		





		

		
		




