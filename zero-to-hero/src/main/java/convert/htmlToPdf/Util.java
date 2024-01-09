package convert.htmlToPdf;

public class Util {
    public static String getContent() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "    <style type=\"text/css\">\n" +
                "        body {\n" +
                "            font-family: Arial;\n" +
                "            color: #444;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "\n" +
                "    <script>\n" +
                "        <!--window.print();-->\n" +
                "    </script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<table bgcolor=\"white\" width=\"100%\"\n" +
                "       style=\"max-width: 580px; margin: auto; border-collapse: collapse; background: #fff;\">\n" +
                "    <tr>\n" +
                "        <td\n" +
                "                style=\"font-size: 25px; line-height: 70px; border-bottom: 1px solid #dddddd; padding: 10px;\">\n" +
                "            <span>Ödəniş Qəbzi</span>\n" +
                "        </td>\n" +
                "        <td align=\"right\"\n" +
                "            style=\"border-bottom: 1px solid #dddddd; padding: 10px;\"><img\n" +
                "                    src=\"https://dyo1b8bikoi2e.cloudfront.net/gp-logo.png\"\n" +
                "                    alt=\"GoldenPay OJSC\" width=\"60%\"/></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"padding: 20px 10px 10px;\">\n" +
                "        <td colspan=\"2\"\n" +
                "            style=\"border-bottom: 1px solid #dddddd; padding: 10px;\">\n" +
                "\n" +
                "            <h1\n" +
                "                    style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Xidmət </h1>\n" +
                "            <h2\n" +
                "                    style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[merchant_name]</h2>\n" +
                "            <h1\n" +
                "                    style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Məbləğ</h1>\n" +
                "            <h2\n" +
                "                    style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[amount]</h2>\n" +
                "\n" +
                "            <h1\n" +
                "                    style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Nömrə və ya kod</h1>\n" +
                "            <h2\n" +
                "                    style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[description]</h2>\n" +
                "            <h1\n" +
                "                    style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Tarix</h1>\n" +
                "            <h2\n" +
                "                    style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[payment_date]</h2>\n" +
                "            <h1\n" +
                "                    style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Tranzaksiya ID</h1>\n" +
                "            <h2\n" +
                "                    style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[payment_key]</h2>\n" +
                "                <h1\n" +
                "                        style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Kartın növü</h1>\n" +
                "                <h2\n" +
                "                        style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[card_type]</h2>\n" +
                "                <h1\n" +
                "                        style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Kartın son 4 rəqəmi</h1>\n" +
                "                <h2\n" +
                "                        style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[card_number]</h2>\n" +
                "                <h1\n" +
                "                        style=\"display: block; font-size: 15px; color: #aaaaaa; font-weight: normal; margin: 0;\">Status</h1>\n" +
                "                <h2\n" +
                "                        style=\"display: block; font-size: 18px; font-weight: normal; margin: 0 0 20px 0;\">[status]</h2>\n" +
                "            <span style=\"display:block;float:right;margin-top:-200px;\"><img\n" +
                "                        src=\"https://dyo1b8bikoi2e.cloudfront.net/print.png\" alt=\"GoldenPay OJSC\"/></span>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";

    }

}
