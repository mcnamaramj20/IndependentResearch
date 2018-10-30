import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;

import org.jfree.ui.RefineryUtilities;

public class LoadCSV extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton openButton, saveButton;
	public static File selectedFile;
	final String COMMA_DELIMITER = ",";
	Scanner scanner = null;
	static Map<String, ArrayList<Double>> map = new HashMap<>();

    static ArrayList<Double> groundDistance = new ArrayList<Double>();
    static ArrayList<Double> flowY = new ArrayList<Double>();
    static ArrayList<Double> flowX = new ArrayList<Double>();

	static double[] groundDis = new double[73];
	static double[] mvalX = new double[73];
	static double[] mvalY = new double[73];
    
	String ground_distance = "ground_distance";
	String flow_comp_m_x = "flow_comp_m_x";
	String flow_comp_m_y = "flow_comp_m_y";
	
	int counterground =0;
	int counterx = 0;
	int countery = 0;
      public void actionPerformed(ActionEvent e) {
    	  JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
  		int returnValue = jfc.showOpenDialog(null);
  		if (returnValue == JFileChooser.APPROVE_OPTION) {
  			selectedFile = jfc.getSelectedFile();
  			System.out.println(selectedFile.getAbsolutePath());
  			}				
		try {
			
			scanner = new Scanner(LoadCSV.selectedFile);
			scanner.useDelimiter(COMMA_DELIMITER);
			while(scanner.hasNext()) 
			{	
				String temp = scanner.next();
				Double tempDouble;
				
				if(temp.equals(ground_distance)) {
					tempDouble = scanner.nextDouble();
					groundDistance.add(tempDouble);
					map.put(ground_distance, groundDistance);
					groundDis[counterground]=tempDouble;
					counterground++;
			}		
				if(temp.equals(flow_comp_m_x)) {
					tempDouble = scanner.nextDouble();
					flowX.add(tempDouble);
					map.put(flow_comp_m_x, flowX);
					mvalX[counterx]=tempDouble;
					counterx++;

			}				
				if(temp.equals(flow_comp_m_y)) {
					tempDouble = scanner.nextDouble();
					flowY.add(tempDouble);
					map.put(flow_comp_m_y, flowY);
					mvalY[countery]=tempDouble;
					countery++;
					}
				
				else {
					
			}

		}
			
			for (Map.Entry entry : map.entrySet()) {
			    System.out.println(entry.getKey() + ", " + entry.getValue());
			}	
		} 
		catch (FileNotFoundException fe) 
		{
			fe.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		 final GraphPanel demo = new GraphPanel("CSV Graph");
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);
		
	
	}
  		
		
}

		
	
	





	

	
	

