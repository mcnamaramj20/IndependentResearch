import java.util.Iterator;

public class NormalizeFlightData {
	
	    //Iterator<Pair> iterator = FlightData.log.iterator();
	    Iterator<Pair> iterator2 = FlightData.log.iterator();
	    
	    double waypointP1 = 0;
	    double waypointP2 = 0;
	    double flightdataP1 = 0;
	    double flightdataP2 = 0;
	    
	    int counter =0;
	    double point1 = 0;
		double point2 = 0;
		
	    while (iterator2.hasNext() && counter<100) {
 		
 		Pair pair2 = iterator2.next();
 		
 		if(counter ==0) {
 			  point1 = pair2.getP1();
 			  point2 = pair2.getP2();
 		}
 		
 		double x1 = pair2.getP1()-point1;
 		double y2 = pair2.getP2()-point2;
 		
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
			//System.out.println("x = "+ x1);
			//System.out.println("y = "+ y2);
			//pnlOne.revalidate();
		   // pnlOne.repaint();
		   // this.setVisible(true);

			//.draw(new Line2D.Double( Math.abs(pair.getP1()), Math.abs(pair.getP2()),  Math.abs(pair.getP1()), Math.abs(pair.getP2())));
			// g2d.drawLine();
 		
			counter ++;
			
		}
}
}
