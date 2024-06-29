package alexander.packages.com;

public class Form {

    public static void main(String[] args) {
        String name = "Alexander";

        Scheduler ventana = new Scheduler();
        ventana.setTitle("Formulario Básico");
        ventana.setSize(600, 400);
        ventana.setLocation(400,400);
        ventana.setVisible(true);

    }
}
