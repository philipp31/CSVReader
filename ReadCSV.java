import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class ReadCSV {
	
	public static void main(String[] args) {
		
		Scanner leser;
		try {
            leser = new Scanner(new File("C:/Users/philipp/Desktop/csv.txt"));
			leser.useDelimiter(",");
            int i;
            double d;
			int numColumns = 0;	// in the csv we have 5 columns each line!
			
            while (leser.hasNext()) {
                if (leser.hasNextInt()) {
                    i = leser.nextInt();
                    System.out.println("Int: " + i);
					numColumns++;
                } else if (leser.hasNextDouble()) {
                    d = leser.nextDouble();
                    System.out.println("Double: " + d );
					numColumns++;
                } else {
				//throwing new line and carriage return away if new line beginns:
					char[] k = leser.next().toCharArray();	
					for(int h = 2; h < k.length; h++) {
						System.out.print("Int: " + k[h]);
						System.out.println("");
					}
					numColumns++;
                }
            }
            leser.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();	
        }
    }
}