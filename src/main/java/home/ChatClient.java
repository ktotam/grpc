package home;


import home.chat.ChatMessage;
import home.chat.ChatMessageFromServer;
import home.chat.ChatGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Logger;

public class ChatClient {
    private static final Logger logger = Logger.getLogger(ChatClient.class.getName());
    private static String name = "user";

    public static void main(String[] args) {
        if (args.length > 0) {
            name = args[0];
        }
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

        ChatGrpc.ChatStub chatService = ChatGrpc.newStub(channel);
        logger.info("Connected");
        StreamObserver<ChatMessage> chat = chatService.chat(new StreamObserver<ChatMessageFromServer>() {
            @Override
            public void onNext(ChatMessageFromServer chatMessageFromServer) {
                logger.info(chatMessageFromServer.getMessage().getFrom() + ": " + chatMessageFromServer.getMessage().getText());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                logger.info("Disconnected");
            }

            @Override
            public void onCompleted() {
                logger.info("Disconnected");
            }
        });

        Thread thread = new Thread(() -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                chat.onNext(ChatMessage.newBuilder().setFrom(name).setText(scanner.nextLine()).build());
            }
        });
        thread.start();
    }
}
