package home;

import home.msg.MessageGrpc;
import home.msg.Reply;
import home.msg.Request;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private void start() throws IOException, InterruptedException {
        int port = 50052;
        Server server = ServerBuilder.forPort(port)
                .addService(new MsgService())
                .build()
                .start();

        logger.info("Started, port: " + port);
        server.awaitTermination();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
    }

    static class MsgService extends MessageGrpc.MessageImplBase {

        @Override
        public void sendMessage(Request request, StreamObserver<Reply> observer) {
            Reply reply = Reply.newBuilder()
                    .setMessage(request.getMessage())
                    .setName(request.getName())
                    .build();
            logger.info(reply.getName() + ": " + reply.getMessage());
            observer.onNext(reply);
            observer.onCompleted();
        }
    }


}
