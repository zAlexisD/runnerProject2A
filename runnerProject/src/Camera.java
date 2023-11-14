public class Camera {
    //two coordinates as sets
    private int x;
    private int y;

    //constructor
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //Override of toString()
    @Override
    public String toString(){
        return this.x+","+this.y;
    }
}
