// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package home.chat;

public final class ChatMessageProto {
  private ChatMessageProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_msg_ChatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_msg_ChatMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_msg_ChatMessageFromServer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_msg_ChatMessageFromServer_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nchat.proto\022\003msg\")\n\013ChatMessage\022\014\n\004from" +
      "\030\001 \001(\t\022\014\n\004text\030\002 \001(\t\":\n\025ChatMessageFromS" +
      "erver\022!\n\007message\030\001 \001(\0132\020.msg.ChatMessage" +
      "2@\n\004Chat\0228\n\004chat\022\020.msg.ChatMessage\032\032.msg" +
      ".ChatMessageFromServer(\0010\001B\037\n\thome.chatB" +
      "\020ChatMessageProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_msg_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_msg_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_msg_ChatMessage_descriptor,
        new java.lang.String[] { "From", "Text", });
    internal_static_msg_ChatMessageFromServer_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_msg_ChatMessageFromServer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_msg_ChatMessageFromServer_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
