package wrapper_classes;

public class WrapperClasses {
    public static void main(String[] args) {
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("True");
        Boolean b3 = new Boolean("true");
        Boolean b4 = new Boolean("TrUe");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

        Boolean b5 = new Boolean("test");
        System.out.println(b5);

        Character character = new Character('a');

        // compile time error
//        Character character1 = new Character("a");
//        Character character2 = new Character( 23);

        int iVal = 100;
        long lVal = iVal;
        float fVal = iVal;
        float fVal1 = lVal;




    }
}
