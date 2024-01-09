//package convert.htmlToPdf;
//
//import static convert.htmlToPdf.Util.getContent;
//import static convert.htmlToPdf.Util.getStatic;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.SneakyThrows;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//public class Main {
//
//    @SneakyThrows
//    public static void main(String[] args) {
//        String content = getContent();
//        List<String> staticContent = List.of(getStatic(), getStatic(), getStatic());
//
//        String collectedStaticContent = staticContent.stream()
//                .map(paymentResult -> MessageContentUtil.builder()
//                        .setContent(getStatic())
//                        .setValue("merchant_name", "mn")
//                        .setValue("amount", "12")
//                        .setValue("description", "JNCHJJ")
//                        .setValue("payment_date", "String.valueOf(paymentResult.getPaymentDate())")
//                        .setValue("payment_key", "VMFNHBJHDSBJHSBD")
//                        .setValue("card_type", " paymentResult.getCard().getCardType().getDisplayName()")
//                        .setValue("card_number", "paymentResult.getCard().getCardNumber()")
//                        .setValue("status", "fetchLocalizedStatus(paymentResult.getStatus())")
//                        .build())
//                .collect(Collectors.joining("\n"));
//
//        String finalContent = MessageContentUtil.builder()
//                .setContent(content)
//                .setValue("static-data", collectedStaticContent)
//                .build();
//
//        System.out.println(finalContent);
//
//        convertToPdf(finalContent, "data.pdf");
//    }
//
//    private static String getAzerbaijaniHtml() {
//        // Replace this with your actual Azerbaijani HTML content
//        return "<html><body><h1>Salam, Dünya!</h1></body></html>";
//    }
//
//    private static void convertToPdf(String outputPath, String htmlContent) {
//        try {
//            ITextRenderer renderer = new ITextRenderer();
//            renderer.setDocumentFromString(htmlContent);
//            renderer.layout();
//
//            try (OutputStream os = new FileOutputStream(outputPath)) {
//                renderer.createPDF(os);
//            }
//
//            System.out.println("PDF created successfully at: " + outputPath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
