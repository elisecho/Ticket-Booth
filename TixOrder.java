import javax.swing.JOptionPane;

public class TixOrder {
    private String name;
    private int tixCount;
    public void order(){
        String input = JOptionPane.showInputDialog("Enter a name and a quantity separated by a colon. \nExample: Gabbie:3 \nEnter STOP to end the program.");
        if(input.equalsIgnoreCase("end")){
            System.out.println("Exiting the program.");
            System.exit(0);
        }

        String[] array = input.split(":");

        String name = array[0];
        int tixCount = Integer.parseInt(array[1]);

        System.out.println(name + " " + tixCount);
    }

    public TixOrder (String name, int tixCount){
        this.name = name;
        this.tixCount = tixCount;
    }

    public String getName() {
        return name;
    }

    public int getTixCount() {
        return tixCount;
    }
}