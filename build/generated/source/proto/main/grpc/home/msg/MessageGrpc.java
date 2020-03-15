package home.msg;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: message.proto")
public final class MessageGrpc {

  private MessageGrpc() {}

  public static final String SERVICE_NAME = "msg.Message";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<home.msg.Request,
      home.msg.Reply> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = home.msg.Request.class,
      responseType = home.msg.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<home.msg.Request,
      home.msg.Reply> getSendMessageMethod() {
    io.grpc.MethodDescriptor<home.msg.Request, home.msg.Reply> getSendMessageMethod;
    if ((getSendMessageMethod = MessageGrpc.getSendMessageMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getSendMessageMethod = MessageGrpc.getSendMessageMethod) == null) {
          MessageGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<home.msg.Request, home.msg.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  home.msg.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  home.msg.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new MessageMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageStub>() {
        @java.lang.Override
        public MessageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageStub(channel, callOptions);
        }
      };
    return MessageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub>() {
        @java.lang.Override
        public MessageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageBlockingStub(channel, callOptions);
        }
      };
    return MessageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub>() {
        @java.lang.Override
        public MessageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageFutureStub(channel, callOptions);
        }
      };
    return MessageFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MessageImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(home.msg.Request request,
        io.grpc.stub.StreamObserver<home.msg.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                home.msg.Request,
                home.msg.Reply>(
                  this, METHODID_SEND_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageStub extends io.grpc.stub.AbstractAsyncStub<MessageStub> {
    private MessageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(home.msg.Request request,
        io.grpc.stub.StreamObserver<home.msg.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessageBlockingStub> {
    private MessageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageBlockingStub(channel, callOptions);
    }

    /**
     */
    public home.msg.Reply sendMessage(home.msg.Request request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageFutureStub extends io.grpc.stub.AbstractFutureStub<MessageFutureStub> {
    private MessageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<home.msg.Reply> sendMessage(
        home.msg.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((home.msg.Request) request,
              (io.grpc.stub.StreamObserver<home.msg.Reply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return home.msg.MsgProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Message");
    }
  }

  private static final class MessageFileDescriptorSupplier
      extends MessageBaseDescriptorSupplier {
    MessageFileDescriptorSupplier() {}
  }

  private static final class MessageMethodDescriptorSupplier
      extends MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
