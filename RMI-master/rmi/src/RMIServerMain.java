public class RMIServerMain {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try 
        {
            RMIService ws = new RMIService();
           
            int suma = ws.getSuma(123, 10);

            System.out.println("suma: " + suma); 
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex);
        }
    }
}