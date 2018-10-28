import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] symp = { false, false, false, false, false };

    static boolean[][] disease = { { false, false, false, false, false }, { false, true, true, false, false },
            { false, true, true, false, true }, {false, false, false, false, true} };

    static void check() {
        int[] similarity = { 0, 0, 0, 0 };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (symp[j] == disease[i][j]) {
                    similarity[i]++;
                }
            }
        }
        if (similarity[0] >= similarity[1] && similarity[0] >= similarity[2] && similarity[0]>=similarity[3]) {
            System.out.println("Patient has no disease so far");
        } else if (similarity[1] >= similarity[0] && similarity[1] >= similarity[2] && similarity[1] >= similarity[3]) {
            System.out.println("Patient seems to have common fever");
        } else if(similarity[2] >= similarity[0] && similarity[2] >= similarity[1] && similarity[2] >= similarity[3]){
            System.out.println("Patient might have common cold");
        }else {
            System.out.println("Patient might be just Tired");
        }
    }

    static {
    }

    static void ask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you feel dizzy?(Y/N)");
        if (br.readLine().equals("y")) {
            symp[0] = true;
        }
        System.out.println("Do you have fever?(Y/N)");
        if (br.readLine().equals("y")) {
            symp[1] = true;
        }
        System.out.println("Do you have headache?(Y/N)");
        if (br.readLine().equals("y")) {
            symp[2] = true;
        }
        System.out.println("Do you feel nauseated?(Y/N)");
        if (br.readLine().equals("y")) {
            symp[3] = true;
        }
        System.out.println("Do you have body pain?(Y/N)");
        if (br.readLine().equals("y")) {
            symp[4] = true;
        }
    }
    
    static void loadDatabase(String dbfile) {
        try {
            FileReader db = new FileReader(dbfile);
            BufferedReader br = new BufferedReader(db);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Error Loading Database File\nFile Not Found");
        }
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Medical Expert System");
        int choice = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (choice != 3) {
            System.out.println("1. New Patient\n2. Previous Result\n3. Exit");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
            case 1: {
                ask();
                check();
                break;
            }
            case 2:
                check();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Incorrect Choice");
            }
        }
    }
}
