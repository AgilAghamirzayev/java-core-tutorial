package convert.htmlToPdf;

import java.io.ByteArrayOutputStream;
import lombok.SneakyThrows;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class Main2 {
    public static void main(String[] args) {
        byte[] bytes = convertHtmlToPdf(Util.getContent());

        String test = "";
        System.out.println(test);
    }


    @SneakyThrows
    public static byte[] convertHtmlToPdf(String htmlContent) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(os, true);
            return os.toByteArray();
        }
    }

}
