package entity;

import utils.Validator;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="points_seq")
    @SequenceGenerator(name="points_seq", sequenceName="SEQ_POINT", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "x")
    private double valueX;

    @Column(name = "y")
    private double valueY;

    @Column(name = "r")
    private double valueR;

    @Column(name = "result")
    private String result;

    @Column(name = "time")
    private String time;

    private boolean checkRectangle(){
        return valueX >= 0 && valueY <= 0 && valueX <= valueR/2 && valueY >= -valueR;
    }

    private boolean checkQuarterCircle(){
        return valueX >= 0 && valueY >= 0 && valueX*valueX + valueY*valueY <= valueR*valueR;
    }

    private boolean checkTriangle(){
        return valueX <= 0 && valueY >= 0 && valueY <= valueX + valueR;
    }

    public boolean calculateResult(){
        return (checkRectangle() || checkQuarterCircle() || checkTriangle()) && Validator.isValid(valueX, valueY, valueR);
    }

    public Point(){
    }

    @Override
    public String toString() {
        return "Point{" +
                "valueX=" + valueX +
                ", valueY=" + valueY +
                ", valueR=" + valueR +
                ", result='" + result + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public double getValueX() {
        return valueX;
    }

    public void setValueX(double valueX) {
        this.valueX = valueX;
    }

    public double getValueY() {
        return valueY;
    }

    public void setValueY(double valueY) {
        this.valueY = valueY;
    }

    public double getValueR() {
        return valueR;
    }

    public void setValueR(double valueR) {
        this.valueR = valueR;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
