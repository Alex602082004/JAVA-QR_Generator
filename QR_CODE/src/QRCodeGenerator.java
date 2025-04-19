import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(String data, String filePath, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            String qrData = "https://github.com/Alex602082004"; // Token unic
            generateQRCode(qrData, "qrcode.png", 300, 300);
            System.out.println("QR Code generat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


