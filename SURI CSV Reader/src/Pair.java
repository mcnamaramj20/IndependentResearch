import javafx.beans.binding.DoubleExpression;

public class Pair{
    Double p1, p2;
        Pair(Double p1, Double p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public void setP2(Double p2) {
        this.p2 = p2;
    }

    public Double getP2() {
        return p2;
    }

    public void printString (){
        System.out.println("point coord long: " + this.p1 + "and Lat: " + this.p2);
    }

}
