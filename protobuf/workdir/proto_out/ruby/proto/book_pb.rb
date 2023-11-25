# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: proto/book.proto

require 'google/protobuf'

Google::Protobuf::DescriptorPool.generated_pool.build do
  add_file("proto/book.proto", :syntax => :proto3) do
    add_message "tsuyoyo.protobuf.demo.Author" do
      optional :id, :int32, 1
      optional :name, :string, 2
      optional :penName, :string, 3
    end
    add_message "tsuyoyo.protobuf.demo.Book" do
      optional :id, :int32, 1
      optional :title, :string, 2
      optional :author, :message, 3, "tsuyoyo.protobuf.demo.Author"
      optional :genre, :enum, 4, "tsuyoyo.protobuf.demo.Genre"
    end
    add_message "tsuyoyo.protobuf.demo.GetBooksResponse" do
      repeated :books, :message, 1, "tsuyoyo.protobuf.demo.Book"
    end
    add_enum "tsuyoyo.protobuf.demo.Genre" do
      value :UNKNOWN, 0
      value :SCIENCE, 1
      value :FANTASY, 2
      value :MYSTERY, 3
    end
  end
end

module Tsuyoyo
  module Protobuf
    module Demo
      Author = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("tsuyoyo.protobuf.demo.Author").msgclass
      Book = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("tsuyoyo.protobuf.demo.Book").msgclass
      GetBooksResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("tsuyoyo.protobuf.demo.GetBooksResponse").msgclass
      Genre = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("tsuyoyo.protobuf.demo.Genre").enummodule
    end
  end
end
