package labs.lab1;
/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * create a sheet of size A0
     */
    private int width;
    private int length;
    private String name;
    private int size;

    public Sheet() {
        this.width = 841;
        this.length = 1189;
        this.name = "A0" ;
        this.size = 0;
// FILL IN
    }
    public Sheet(int width, int length, String name, int size){
        this.width = width;
        this.length = length;
        this.name = name;
        this.size = size;
    }
    /**
     * @return the width of the paper
     */
    public int getWidth() {
        return this.width; // FIX ME
    }
    /**
     * @return the length of the paper
     */
    public int getLength() {
        return this.length; // FIX ME
    }

    public int getSize(){
        return this.size;
    }
    /**
     * @return the ISO name for the paper
     */
    public String getName() {
        return this.name; // FIX ME
    }
    /**
     *
     * @return a sheet that is cut in half along the length
     */
    public Sheet cutInHalf() {
        int curlength = this.getLength();
        int curwidth = this.getWidth();
        int cursize = this.getSize();
        if (curlength > curwidth){
            curlength /= 2;
            int temp = curwidth;
            if (curlength < curwidth){
                curwidth = curlength;
                curlength = temp;
            }
        }
        else if (curlength < curwidth){
            curwidth /=2 ;
            int temp = curlength;
            if (curwidth < curlength){
                curlength = curwidth;
                curwidth = temp;
            }
        }
        cursize += 1;
        return new Sheet(curwidth, curlength, "A" + cursize, cursize); // FIX ME
    }
    public static void main (String[] args){
        Sheet sheet = new Sheet();

        System.out.println(sheet.getName()); // Expected: "A0"
        System.out.println(sheet.getWidth()); // Expected: 841
        System.out.println(sheet.getLength()); // Expected: 1189

        sheet = sheet.cutInHalf();
        System.out.println(sheet.getName()); // Expected: "A1"
        System.out.println(sheet.getWidth()); // Expected: 594
        System.out.println(sheet.getLength()); // Expected: 841

        sheet = sheet.cutInHalf();
        System.out.println(sheet.getName()); // Expected: "A2"
        System.out.println(sheet.getWidth()); // Expected: 420
        System.out.println(sheet.getLength()); // Expected: 594
    }
}
