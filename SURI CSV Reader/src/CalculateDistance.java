import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class CalculateDistance {
	private static final String TAB_DELIMITER = "	";
	private static final String COMMA_DELIMITER = ","; 
	public final static String LNG = "lng";
	public final static String LAT = "lat";
    public static ArrayList<Pair> wayPoints = new ArrayList<Pair>();
    public static ArrayList<Pair> log = new ArrayList<Pair>();
    public static LinkedHashSet<Pair> smallestDistances = new LinkedHashSet<Pair>();


	public static void main(String[] str) throws FileNotFoundException {		
		readWaypoints();			
		readFlightData(); 	 	    
	}	
	
	private static void readWaypoints() throws FileNotFoundException {				
		try {
			File file = new File("C:\\Users\\MMcNa\\Desktop\\flgiht data\\2018-09-17 23-19-34-0.waypoints.txt");
	        InputStream ips = new FileInputStream(file);
	        InputStreamReader ipsr = new InputStreamReader(ips);
	        BufferedReader br = new BufferedReader(ipsr);
	        String line;       
	        double longitude, lattitude;
	        long lon, lat;
	        while ((line = br.readLine()) != null) {	        	
	            String[] points = line.split(getTabDelimiter());	            
	             longitude = Double.parseDouble(points[8]);
	             lattitude = Double.parseDouble(points[9]);
	            
	            if(longitude !=0 && lattitude !=0) {
	            String str1 = Double.toString(longitude);
	 	        String str2 = Double.toString(lattitude);
	 	    
	 	       StringBuilder strb1 = new StringBuilder(str1);
	 	  	   StringBuilder strb2 = new StringBuilder(str2);	 	  	
	 	  	    
	 	 	    strb1.deleteCharAt(str1.indexOf('.'));
	 	 	    strb2.deleteCharAt(str2.indexOf('.'));
	 	 	    String str11 = strb1.toString();
	 	 	    String str21 = strb2.toString();
	 	 	    
	 	        lon = Integer.parseInt(str11);
	 	        lat = Integer.parseInt(str21);	 	     
	 	    
	            wayPoints.add(new Pair(Math.abs(lon), Math.abs(lat)));
	        }
	      }
	        br.close();
  	    } catch (Exception e1) {
  	        e1.printStackTrace();
  	    }
			
	}
	
	private static void readFlightData() throws FileNotFoundException {	
		 long longitude = 0;
	     long lattitude = 0;
		 
	     File file = new File("C:\\Users\\MMcNa\\Desktop\\flgiht data\\flightData.csv");
	      
			Scanner scanner;
			try {				
				scanner = new Scanner(file);
				scanner.useDelimiter(COMMA_DELIMITER);
				while(scanner.hasNext()) 
				{	
					String temp = scanner.next();					
					if (temp.equals(LNG)) {
		                longitude = scanner.nextLong();
		                String templong = Long.toString(longitude);
		                
		                if(longitude==0) {
		                	longitude = Long.parseLong(templong);
		                }
		                else if(longitude<0){
		                	templong = templong.substring(0,9);
		                }
		                longitude = Long.parseLong(templong);

					}
		            if (temp.equals(LAT)) {		            	
		                lattitude = scanner.nextLong();
		                String templat = Long.toString(lattitude);
		                
		                if(lattitude==0) {
		                	lattitude = Long.parseLong(templat);
		                }
		                else {
		                	templat = templat.substring(0,8);
		                }
		                lattitude = Long.parseLong(templat);
		                
		            }
		                log.add(new Pair(longitude, lattitude)); 
		                
				}	
			}			
			catch (FileNotFoundException fe) 
			{
				fe.printStackTrace();
			}
	}
	
	public void fillTempArray(ArrayList<Pair> wayPoints, ArrayList<Pair> log) {
		/*for(int i = 0; i < wayPoints.size(); i++) {
			for(int j = 0; j < log.size(); j++) {
				if(wayPoints.get(i)!=log.get(j)) {
					while(wayPoints.get(i)!=log.get(j)) {
						long tempChecl = 
						if(wayPoints.get(i)!=log.get(j)) {
							
						}
					}
				}
				else {
					smallestDistances.add(log.get(j));
				}
			}*/
	}
	
	public static String getTabDelimiter() {
		return TAB_DELIMITER;
	}
}
	

