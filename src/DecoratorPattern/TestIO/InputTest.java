package DecoratorPattern.TestIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            InputStream in =
                    new LowerCaseInputStream(
                        new BufferedInputStream(
                            new FileInputStream("E:\\OneDrive\\代码\\Java\\TestDesignPatterns\\src\\DecoratorPattern\\TestIO\\text.txt")));

            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
