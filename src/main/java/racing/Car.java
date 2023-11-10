package racing;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public String visualizeMoveState() {
        StringBuilder sb = new StringBuilder(String.format("%-5s", name));
        sb.append(" : ");
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void move(int num) {
        if (num < 4) {
            return;
        }

        this.location++;
    }
}
