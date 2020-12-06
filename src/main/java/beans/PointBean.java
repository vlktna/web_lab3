package beans;

import dao.JpaPointDao;
import entity.Point;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class PointBean implements Serializable {

    private Point point;
    private List<Point> pointsList;
    private JpaPointDao service;

    @PostConstruct
    public void postConstruct(){
        point = new Point();
        point.setValueR(2.25);
        pointsList = new ArrayList<>();
        service = new JpaPointDao();
        service.createEntityManager();
    }

    public void addPoint(){
        point.setTime(String.valueOf(new Date()));
        point.setResult(String.valueOf(point.calculateResult()));
        pointsList.add(point);
        service.save(point);
        point = new Point();
    }

    public void clear(){
        pointsList = new ArrayList<>();
        service.deleteAll();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Point> getPointsList() {
        return pointsList;
    }

    public void setPointsList(List<Point> pointsList) {
        this.pointsList = pointsList;
    }
}
