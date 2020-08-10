import javax.swing.JOptionPane;

public class TixOrder {
    private String name;
    private int tixCount;

    public TixOrder() {
        boolean reAsk = true;

        while (reAsk) {
            String input = JOptionPane.showInputDialog("Enter a name and a quantity separated by a colon." +
                    "\nExample: Gabbie:3" +
                    "\nEnter STOP to end the program.");

            if (input.equalsIgnoreCase("STOP")) {
                System.out.println("Exiting the program.");
                System.exit(1);
            } else if (!input.contains(":")) {
                System.out.println("Invalid entry");
                reAsk = true;
            } else {
                String[] array = input.split(":");
                name = array[0];
                tixCount = Integer.parseInt(array[1]);
                reAsk = false;
            }
        }
    }

//    public TixOrder (String name, int tixCount){
//        this.name = name;
//        this.tixCount = tixCount;
//    }

    public String getName() {
        return name;
    }

    public int getTixCount() {
        return tixCount;
    }

}