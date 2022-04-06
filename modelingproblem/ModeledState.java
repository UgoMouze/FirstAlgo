package modelingproblem;

public class ModeledState {

    public final static String M3C3_M0C0 = "M3C3_M0C0";
    public final static String M3C1_M0C2 = "M3C1_M0C2";
    public final static String M3C2_M0C1 = "M3C2_M0C1";
    public final static String M2C2_M1C1 = "M2C2_M1C1";
    public final static String M1C1_M2C2 = "M1C1_M2C2";
    public final static String M0C1_M3C2 = "M0C1_M3C2";
    public final static String M0C3_M3C0 = "M0C3_M3C0";
    public final static String M0C2_M3C1 = "M0C2_M3C1";
    public final static String M0C0_M3C3 = "M0C0_M3C3";

    public String value;

    public ModeledState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof ModeledState) {
            return ((ModeledState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }

}
