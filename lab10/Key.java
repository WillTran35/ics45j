package labs.lab10;
public enum Key {
    C(0), CSHARP_DFLAT(1), D(2), DSHARP_EFLAT(3), E(4), F(5), FSHARP_GFLAT(6),
    G(7), GSHARP_AFLAT(8),
    A(9), ASHARP_BFLAT(10), B(11);
    private int code;
    private Key(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public static Key getValue(int value) {
        for (Key k : Key.values()) {
            if (k.code == value) {
                return k;
            }
        }
        return null; // not found
    }
}
