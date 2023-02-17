package cn.xxx.order.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;
import com.microsoft.cognitiveservices.speech.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

//@ServerEndpoint 是一个 Java WebSocket API 的注解，它可以将一个普通的 Java 类转换为 WebSocket 服务器端的终端点。
// 其中 value 属性指定了 WebSocket 的 URI 路径，即客户端通过该路径连接到 WebSocket 服务器。
//例如，@ServerEndpoint(value = "/audio") 注解表示创建了一个 WebSocket 服务器端终端点.
// 该终端点对应的 URI 路径为 /audio，客户端需要通过 ws://host:port/audio 的方式连接到该 WebSocket 服务器。
@Slf4j
@Component
@ServerEndpoint(value = "/audio")
public class Text2VoiceWebsocket {

    private static SpeechConfig speechConfig;
    private static SpeechSynthesizer synthesizer;



    @OnOpen
    public void onOpen(Session session) {
        // 在静态代码块中初始化语音合成对象

        // TODO 配置文本转语音的key和区域
        speechConfig = SpeechConfig.fromSubscription("", "eastus");
        // Note: the voice setting will not overwrite the voice element in input SSML.
        speechConfig.setSpeechSynthesisVoiceName("zh-CN-XiaoxiaoNeural");
        synthesizer = new SpeechSynthesizer(speechConfig);

        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket closed: " + session.getId());
        // 关闭语音合成对象
        synthesizer.close();
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error: " + session.getId() + ", " + throwable.getMessage());
        // 关闭语音合成对象
        synthesizer.close();
    }

    @OnMessage
    public void onMessage(Session session, String text) {
        System.out.println("Received text: " + text);
        try {
            // 将文本转换成语音流
            SpeechSynthesisResult result = synthesizer.SpeakTextAsync(text).get();

            // 将语音流转成字节数组
            AudioDataStream audioDataStream =  AudioDataStream.fromResult(result);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = (int) audioDataStream.readData(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
                // 将音频数据通过 WebSocket 发送给前端
                session.getBasicRemote().sendBinary(ByteBuffer.wrap(buffer, 0, bytesRead));
            }
            audioDataStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }
}

