public class IntDivider {
    public Integer divide(String[] skaiciai){
        try{
           return Integer.parseInt(skaiciai[0]) / Integer.parseInt(skaiciai[1]);

        }catch (ArithmeticException e){
            System.out.println("Dalyba is 0 neimanoma");
        }
        return null;
    }
}
