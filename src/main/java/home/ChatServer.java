package home;

import home.chat.ChatGrpc;
import home.chat.ChatMessage;
import home.chat.ChatMessageFromServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ChatServer {
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50053;
        Server server = ServerBuilder.forPort(port).addService(new ChatServiceImpl()).build();
        logger.info("Server started, port: " + port);
        server.start();
        server.awaitTermination();
    }

    static class ChatServiceImpl extends ChatGrpc.ChatImplBase {
        private static List<StreamObserver<ChatMessageFromServer>> observers = new ArrayList<>();

        @Override
        public StreamObserver<ChatMessage> chat(StreamObserver<ChatMessageFromServer> responseObserver) {
            observers.add(responseObserver);

            return new StreamObserver<ChatMessage>() {
                @Override
                public void onNext(ChatMessage chatMessage) {
                    logger.info(chatMessage.getFrom() + ": " + chatMessage.getText());
                    ChatMessageFromServer message = ChatMessageFromServer.newBuilder()
                            .setMessage(chatMessage)
                            .build();

                    for (StreamObserver<ChatMessageFromServer> observer : observers) {
                        observer.onNext(message);
                    }
                }

                @Override
                public void onError(Throwable t) {
                }

                @Override
                public void onCompleted() {
                    observers.remove(responseObserver);
                }
            };
        }
    }
}
