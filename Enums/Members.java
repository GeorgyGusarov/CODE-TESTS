package Enums;

public enum Members {
    JERRY, BOBBY, PHIL;
}

class EnumTest1 {
    public static void main(String[] args) {

        Members n = Members.BOBBY;
        if (n.equals(Members.JERRY)) System.out.println("Джерррри!");
        if (n == Members.BOBBY) System.out.println("Rat Dog");

        Members ifName = Members.PHIL;
        switch (ifName) {
            case JERRY:
                System.out.println("пусть споёт");
            case PHIL:
                System.out.println("углубляйся, ");
            case BOBBY:
                System.out.println("Кессиди!");
        }
    }
}
