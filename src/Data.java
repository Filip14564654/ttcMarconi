import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    public void chooseSource() throws IOException {
        System.out.println("Zadejte celé kladné číslo, pokud chcete načítat data z konzlole, " +
                "nebo cestu k souboru s čísly");
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        try{
            //CONSOLE
            Integer.parseInt(source);
            System.out.println("Pokud chcete, zadejte adresu, kam bude výsledek uložen. " +
                    "Pokud chcete výsledek zapsat do konzole, zadejte čísla oddělená mezerou.");
            String s1 = scanner.nextLine();
            s1 = s1.trim();
            if (s1.contains(" ")){
                //CONSOLE -> CONSOLE
                System.out.println(parseData(s1));
            }else {
                //CONSOLE -> FILE
                System.out.println("Zadejte čísla oddělená mezerou.");
                String s2 = scanner.nextLine();
                PrintWriter printWriter = new PrintWriter(s1);
                printWriter.println(parseData(s2));
                printWriter.close();
            }

        }
        catch (NumberFormatException nfe){
            //FILE
            System.out.println("Pokud si přejete výsledek zapsat do souboru, napište adresu. " +
                    "Pokud chcete zapsat výsledek do konzole, stiskněte enter.");
            String output = scanner.nextLine();
            FileReader fileReader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if(output.isEmpty()){
                // FILE -> CONSOLE
                System.out.println(parseData(bufferedReader.readLine()));

            }else {
                // FILE -> FILE
                PrintWriter printWriter = new PrintWriter(output);
                printWriter.println(parseData(bufferedReader.readLine()));
                printWriter.close();

            }
        }
    }


    public String parseData(String string){
        String[] strings = string.split(" ");
        int[] arr = new int[strings.length];
        for(int i=0; i<strings.length; i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();

        if(arr.length % 2 == 0){
            for (int i : arr) {
                if (i % 2 == 0){
                    res.add(i);
                }
            }
        }else {
            for (int i : arr) {
                if (i % 2 == 1){
                    res.add(i);
                }
            }
        }

        String result = "";
        for (Integer i : res) {
            result = result + " " + i.toString();
        }
        result = result.trim();
        return result;

    }

}
