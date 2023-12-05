package fan;

public class Fan {

    private String color = "blue";
    private boolean on;
    private int speed = Speed.SLOW.valueSpeed;
    private int radius = 5;

    public boolean isOn() {
        return on;
    }
    public void on() {
        if (!on){
            on = true;
        }else on = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
        if (on) return String.format("fanSpeed: {%s}, fanColor: {%s}, fanRadius: {%s}",
                speed, color, radius);
        else return String.format("Fan-Color: {%s}, Fan-Radius: {%s}, Fan is off ",
                color, radius);
    }
}
