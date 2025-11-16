//Slip 1
import java.io.*;
import java.util.Scanner;

public class LowerCaseDecoratorExample {
public static void main(String[] args) throws IOException {

Scanner scanner = new Scanner(System.in);
System.out.print("Enter text: ");
String input = scanner.nextLine();


InputStream inputStream = new ByteArrayInputStream(input.getBytes());
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

OutputStreamWriter writer = new OutputStreamWriter(System.out);

int ch;

while ((ch = reader.read()) != -1) {
writer.write(Character.toLowerCase(ch));
}

writer.flush();

reader.close();
writer.close();
}
}
