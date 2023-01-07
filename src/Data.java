import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    public void parseInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        String data;

        if (strings[0].contains(".")){
            FileReader fileReader = new FileReader(strings[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
        }else {
            try{
                Integer.parseInt(strings[0]);
                System.out.println("Zadejte čísla oddělená mezerou.");
                data = scanner.nextLine();
            }catch (NumberFormatException nfe){
                System.out.println("Nezadali jste validní input.");
                parseInput();
                return;
            }
            scanner.close();
        }

        if (strings.length == 1){
            // OUTPUT IS CONSOLE
            System.out.println(parseData(data));
        }else {
            // OUTPUT IS FILE
            PrintWriter printWriter = new PrintWriter(strings[1]);
            printWriter.println(parseData(data));
            printWriter.close();
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
