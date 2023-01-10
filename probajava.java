import java.util.Scanner;
public class probajava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contraseña="eureka";
        //System.out.println("Maximo de intetos");
        System.out.println("Introduce el número de intentos: ");
        int INTENTOS = sc.nextInt();
        //Esta variable booleana, nos controlara que en caso de que acierte la condicion cambie
        boolean acierto=false;
        String password;
        for (int i=0;i<INTENTOS && !acierto;i++){
            System.out.println("Introduce una contraseña");
            password = sc.next();
            //Comprobamos si coincide, no usamos ==, usamos el metodo equals
            if (password.equals(contraseña)){
                System.out.println("Enhorabuena, acertaste");
                acierto=true;
            }
        }
    }
}
