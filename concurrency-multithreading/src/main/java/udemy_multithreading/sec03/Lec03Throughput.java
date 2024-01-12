package udemy_multithreading.sec03;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lec03Throughput {
    private static final String INPUT_FILE = "C:\\Users\\agila\\Desktop\\Projects\\self-projects\\java-core-tutorial" +
            "\\concurrency-multithreading\\src\\main\\resources\\war_and_peace.txt";
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors()-2;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Path.of(INPUT_FILE)));
        startServer(text);
    }

    private static void startServer(String text) throws IOException {
        System.out.println(NUMBER_OF_THREADS);
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

    private record WordCountHandler(String text) implements HttpHandler {

        @Override
            public void handle(HttpExchange exchange) throws IOException {
                String query = exchange.getRequestURI().getQuery();
                String[] keyValue = query.split("=");
                String action = keyValue[0];
                String word = keyValue[1];
                if (!action.equals("word")) {
                    exchange.sendResponseHeaders(400, 0);
                    return;
                }

                long count = countWold(word);

                byte[] response = Long.toString(count).getBytes();
                exchange.sendResponseHeaders(200, response.length);
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response);
                outputStream.close();
            }

            private long countWold(String word) {
                long count = 0;
                int index = 0;

                while (index >= 0) {
                    index = text.indexOf(word, index);
                    if (index >= 0) {
                        count++;
                        index++;
                    }
                }
                return count;
            }

        }
}
