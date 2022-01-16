package SendEmail;

import java.io.IOException;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class text {
    public static void main(String[] args) {

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode("hello", BarcodeFormat.QR_CODE, 500, 500);

            System.out.println("running...");

            MatrixToImageWriter.writeToPath(bitMatrix, "png", Paths.get("CineBook/cinebook/src/SendEmail/qr.png"));

        } catch (IOException | WriterException e1) {

            e1.printStackTrace();
        }

    }
}
