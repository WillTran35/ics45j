package labs.lab10;
public enum Mode {
    MAJOR(1), MINOR(0);
    private int code;
    private Mode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public static Mode getValue(int value) {
        for (Mode m : Mode.values()) {
            if (m.code == value) {
                return m;
            }
        }
        return null; // not found
    }
}
