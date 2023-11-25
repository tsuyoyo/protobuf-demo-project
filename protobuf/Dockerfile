# Ref: https://zenn.dev/mitsugu/articles/0323811005f233
FROM golang:1.16.5
ARG PROTOBUF_VERSION=3.17.3

RUN apt-get update && apt-get install unzip

WORKDIR /usr/src/app
RUN curl -L https://github.com/protocolbuffers/protobuf/releases/download/v${PROTOBUF_VERSION}/protoc-${PROTOBUF_VERSION}-linux-x86_64.zip -o protoc.zip && \
    unzip protoc.zip && \
    mv bin/* /usr/local/bin/ && \
    mv include/* /usr/local/include/
