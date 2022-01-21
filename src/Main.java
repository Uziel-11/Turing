import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String entarada = "";
    static List<String> list = new ArrayList<String>();
    static String opcion = "";

    static Scanner leer = new Scanner(System.in);

    static public void pedirDatos (){

        System.out.println("Ingrese los datos: ");
        entarada =leer.nextLine();
        validarDatos(entarada);
    }

    static public void validarDatos(String dato){

        int aux = 0;

        //particionando dato de entrada
        for (int i=0; i< dato.length(); i++){
//            System.out.println(dato.substring(i,i+1));
            list.add(dato.substring(i,i+1));
        }

        //comprobando numeros
        for (int x = 0; x < list.size()+1 - aux; x++){

            switch (list.get(x)){
                case "0":
                    for (int i=x; i<list.size();i++){
                        System.out.print(list.get(i));
                    }
                    list.set(x,"1");
                    list.add(" ");
                    System.out.println("      "+"q0,1,D"+"      0 --> 1");
                    aux++;
                    break;
                case "1":
                    for (int i=x; i<list.size();i++){
                        System.out.print(list.get(i));
                    }
                    list.set(x,"0");
                    list.add(" ");
                    System.out.println("      "+"q0,0,D"+"      1 --> 0");
                    aux++;
                    break;
                case" ":
                    //System.out.println(list.size()-aux);
                    if (x == list.size()-aux){
                        System.out.println("         q1,B,I");
                        resultado();
                    }else {
                        System.out.println("Datos no Validos");
                        list.clear();
                    }

                    break;

                default:
                    System.out.println("El numero: "+list.get(x)+" no es valido, solo se aceptan 0's y 1's");
                    list.clear();
            }

        }

        //imprimiendo resultado
//        if (list.size() != 0){
//            resultado();
//        }
    }

    public static void resultado(){
        System.out.print("\nCadena convertida: ");
        for (int j=0;j<list.size();j++){
            System.out.print(list.get(j));
        }
        list.clear();

    }

    public static void main(String[] args) {
        do{
            pedirDatos();

            System.out.println("\n\nDesea Continuar S/n");
            opcion = leer.nextLine();


            if (opcion.equals("")){
                System.out.println("---------------------------------------------");
                opcion="S";
            }

        }while (opcion.equals("S"));
    }
}
