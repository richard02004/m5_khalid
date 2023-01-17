import java.io.*;
import java.util.Scanner;

public class Activitat12 {

    static int totHabDona = 0, totHabHome = 0, totHabMinEdatHome = 0, totHabMinEdatDona = 0, totHabEdatLaboralHome = 0, totHabEdatLaboralDona = 0,
    totMenorsHome = 0, totMenorsDona = 0, vivendesMoltOcupades = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String filePath = sc.nextLine();

        File file = new File(filePath);

        checkFile(file);

        llegirDades(file);

        mostrarInformacio();
    }

    static void checkFile(File file) {
        if (!file.exists())
            throw new RuntimeException("File not found exception");
    }

    static void llegirDades(File file) {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while(reader.ready()) {
                String line = reader.readLine();

                String[] data = line.split(" ");

                saveData(data);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error llegint fitxer", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error llegint fitxer", e);
                }
            }
        }
    }

    static void saveData(String... data) {
        saveTotHabDona(Integer.parseInt(data[3]), Integer.parseInt(data[5]), Integer.parseInt(data[7]));
        saveTotHabHome(Integer.parseInt(data[4]), Integer.parseInt(data[6]), Integer.parseInt(data[8]));
        saveTotHabMinEdatHome(Integer.parseInt(data[4]));
        saveTotHabMinEdatDones(Integer.parseInt(data[3]));
        saveTotHabEdatLaboralHome(Integer.parseInt(data[6]));
        saveTotHabEdatLaboralDona(Integer.parseInt(data[5]));
        saveTotMenorsHome(Integer.parseInt(data[8]));
        saveTotMenorsDona(Integer.parseInt(data[7]));

        saveVivendesMoltoOcupades(data);


    }

    static void saveVivendesMoltoOcupades(String... data) {
        int persones = Integer.parseInt(data[4]) + Integer.parseInt(data[5]) + Integer.parseInt(data[6]) + Integer.parseInt(data[7])
                + Integer.parseInt(data[8]) + Integer.parseInt(data[3]);

        if(persones > 6)
            vivendesMoltOcupades++;
    }

    static void saveTotHabDona(int... habDona) {
        totHabDona += habDona[0] += habDona[1] += habDona[2];
    }

    static void saveTotHabHome(int... habHome) {
        totHabHome += habHome[0] += habHome[1] += habHome[2];
    }

    static void saveTotHabMinEdatHome(int data) {
        totHabMinEdatHome += data;
    }

    static void saveTotHabMinEdatDones(int data) {
        totHabMinEdatDona += data;
    }

    static void saveTotHabEdatLaboralHome(int data) {
        totHabEdatLaboralHome += data;
    }

    static void saveTotHabEdatLaboralDona(int data) {
        totHabEdatLaboralDona += data;
    }

    static void saveTotMenorsHome(int data) {
        totMenorsHome += data;
    }

    static void saveTotMenorsDona(int data) {
        totMenorsDona += data;
    }

    static void mostrarInformacio() {
        System.out.println("Total d'habitants de la població i la distribució per sexe: " + totHabDona + " Dones, " + totHabHome +
        " Homes");
        System.out.println("Total d'habitants majors de 67 anys i la distribució per sexe: " + totHabMinEdatDona + " Dones, " + totHabMinEdatHome +
        " Homes");
        System.out.println("Total d'habitants en edat laboral i la distribució per sexe: " + totHabEdatLaboralDona + " Dones, " + totHabEdatLaboralHome +
        " Homes");
        System.out.println("Total d'habitants de menors d’edat i la distribució per sexe: " + totMenorsDona + " Dones, " + totMenorsHome +
        " Homes");

        System.out.println("Quantitat de vivendes amb més de 6 persones censades: " + vivendesMoltOcupades);
    }
}