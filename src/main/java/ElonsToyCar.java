public class ElonsToyCar {
    private int distance;
    private int battery=100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven "+distance+" meters";
    }

    public String batteryDisplay() {
        if(battery<=0) {
            return "Battery empty";
        } else {
            return "Battery at "+battery+"%";
        }
    }

    public void drive() {
        if(battery>0) {
            distance += 20;
            battery -= 1;
        }
    }
}
