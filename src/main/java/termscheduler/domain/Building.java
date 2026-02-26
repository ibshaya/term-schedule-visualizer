package termscheduler.domain;
public class Building {
    private String code;
    private String name;
    private double x, y;

    public Building(String code, String name, double x, double y) {
        this.code = code;
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Building other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public String getCode(){
        return code;
    }
    public double getX(){
        return x;
    }
    public double getY(){ return y; }


}
