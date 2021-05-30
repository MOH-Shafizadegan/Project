public class TIME {
    int n;

    public TIME(int n) {
        this.n = n;
    }

    public TIME(TIME time){
        this.n = time.n;
    }

    public static void TURN(int n){
        // Level.TIME.n += n
    }

    public static int diff(TIME time1, TIME time2){
        return Math.abs(time1.n- time2.n);
    }
}
