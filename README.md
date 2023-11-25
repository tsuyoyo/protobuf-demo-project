# Protobuf demo

Protocol bufferのデモです。
Protocol bufferって何？を、超簡単なサンプルで説明します。

## Directory構成

* `protobuf`: protoの定義ファイルと、そこからRubyとKotlinのclassを生成するscriptが入ってます
* `rails-protobuf-demo`: GET methodを呼び出すと、ダミーのデータがbinaryで返却されるendpointが実装されてます
* `ProtobufDemoApp`: Railsのendpointをcallし、binaryをKotlinのobjectにdecodeする例が実装されてます

## 試し方

1. `protobuf`ディレクトリ内で `$ zsh ./generateProto.sh` を実装すると、Dockerインスタンスが立ち上がり、
`workdir/proto` ディレクトリ内のprotoファイルからKotlin/Rubyのファイルが `workdir/proto_out` 配下に生成されます
2. 1で生成されたファイルを、RailsとAndroidのプロジェクトへcopyして配置します
(もちろん実際のオペレーションでは、1の生成物をjarでdeployするなどしてmanual workを省くべきです)
3. `rails-protobuf-demo` ディレクトリで `$ rails s` を実行し、サーバを起動します
4. `ProtobufDemoApp` ディレクトリをbuildし、Android emulatorを起動します。
5. "Call API" ボタンをclickすると、Logcatにfetchしたデータが表示されます。