package home;

import home.msg.MessageGrpc;
import home.msg.Reply;
import home.msg.Request;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrpcClient {
    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final MessageGrpc.MessageBlockingStub blockingStub;

    private static String user;

    public GrpcClient(Channel channel) {
        this.blockingStub = MessageGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) {
        user = "user";
        String target = "localhost:50053";

        if (args.length > 0) {
            user = args[0];
        }

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        GrpcClient client = new GrpcClient(channel);
        client.sendMessage("Connected");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            client.sendMessage(scanner.nextLine());
        }
    }

    public void sendMessage(String text) {
        Request request = Request.newBuilder()
                .setMessage(text)
                .setName(user)
                .build();
        Reply reply;
        try {
            reply = blockingStub.sendMessage(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info(reply.getName() + ": " + reply.getMessage());
    }
}
