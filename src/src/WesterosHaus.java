import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WesterosHaus {
    static class Entry{
        int id;
        String MitgliederName;
        public  enum Haus{
            Stark,Lannister,Targaryen,Baratheon,Greyjoy,Martell,Tyrell
        }
        Haus h;
        String Ereignis;
        Date datum;
        Entry(int id, String MitgliederName, String Ereignis, Date datum) {
            this.id = id;
            this.MitgliederName = MitgliederName;
            this.h = h;
            this.Ereignis = Ereignis;
            this.datum = datum;
        }

    }
    public static void main(String[] args) throws IOException {
        String inputFileName = "C:\\Users\\blaja\\IdeaProjects\\BlajAndrei721Aufgabe1\\src\\src\\evenimente.json";

        List<Entry> entries = readFile(inputFileName);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an uppercase letter: ");
        char letter = scanner.next().charAt(0);
    }
    static List<Entry> readFile(String fileName) throws IOException {
        List<Entry> entries = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            String[] parts = line.split("&");
            int id = Integer.parseInt(parts[0]);
            String MitgliederName = parts[1];
         //   Entry.Haus h= WesterosHaus.Entry.valueOf(parts[2]);
            String Ereignis = parts[3];
            Date datum = parts[4] == null ? null : new Date(parts[4]);
            entries.add(new Entry(id,MitgliederName,Ereignis,datum));
        }
        return entries;
    }
    
}
