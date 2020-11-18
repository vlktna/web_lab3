package entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

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

    public Point(){}

    public Point(long id, double valueX, double valueY, double valueR, String result, String time) {
        super();
        this.id = id;
        this.valueX = valueX;
        this.valueY = valueY;
        this.valueR = valueR;
        this.result = result;
        this.time = time;
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
