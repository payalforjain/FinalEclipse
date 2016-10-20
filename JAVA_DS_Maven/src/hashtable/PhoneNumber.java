package hashtable;


import java.util.HashSet;

public final class PhoneNumber {
    private final int area;   // area code (3 digits)
    private final int exch;   // exchange  (3 digits)
    private final int ext;    // extension (4 digits)

    public PhoneNumber(int area, int exch, int ext) {
        this.area = area;
        this.exch = exch;
        this.ext  = ext;
    }

    // how you're supposed to implement equals
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        PhoneNumber that = (PhoneNumber) y;
        return (this.area == that.area) && (this.exch == that.exch) && (this.ext == that.ext);
    }

    // 0 for padding with leading 0s
    public String toString() {
        return String.format("(%03d) %03d-%04d", area, exch, ext);
    }

    // satisfies the hashCode contract
    public int hashCode() {
        return 31 * (area + 31 * exch) + ext;
    }


    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 003, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println("Added a, b, and c");
        System.out.println("contains a:  " + set.contains(a));
        System.out.println("contains b:  " + set.contains(b));
        System.out.println("contains c:  " + set.contains(c));
        System.out.println("contains d:  " + set.contains(d));
        System.out.println("contains e:  " + set.contains(e));
        System.out.println("b == e:      " + (b == e));
        System.out.println("b.equals(e): " + (b.equals(e)));
    }



}
