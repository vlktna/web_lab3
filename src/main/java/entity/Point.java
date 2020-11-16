package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Point implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "x")
    private double valueX;

    @Column(name = "y")
    private double valueY;

    @Column(name = "r")
    private double valueR;

    @Column
    private String result;

    @Column
    private String time;

    public Point() {
    }

    public long getId() {
        return id;
    }

    public double getValueX() {
        return valueX;
    }

    public double getValueY() {
        return valueY;
    }

    public double getValueR() {
        return valueR;
    }

    public String getResult() {
        return result;
    }

    public String getTime() {
        return time;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValueX(double valueX) {
        this.valueX = valueX;
    }

    public void setValueY(double valueY) {
        this.valueY = valueY;
    }

    public void setValueR(double valueR) {
        this.valueR = valueR;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
