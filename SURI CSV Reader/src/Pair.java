import javafx.beans.binding.DoubleExpression;

public class Pair{
    long p1, p2;
        Pair(long p1, long p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

    public long getP1() {
        return p1;
    }

    public void setP1(long p1) {
        this.p1 = p1;
    }

    public void setP2(long p2) {
        this.p2 = p2;
    }

    public long getP2() {
        return p2;
    }

    public void printString (){
        //System.out.println("point coord long: " + this.p1 + "and Lat: " + this.p2);
    }

}
