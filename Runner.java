import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {
    public static void main(String[] args) {

        // create the steel wire
        Material material1 = new Material("steel", 7850.0);
        Subject steelWire = new Subject("wire", material1, 0.03);

        // output the object content
        System.out.println(steelWire);

        // update the wire material and output it's mass
        Material material2 = new Material("copper", 8500.0);
        Subject copperWire = new Subject("wire", material2, 0.03);
        System.out.println("The wire mass is " + copperWire.getMass() + " kg");
    }
}
