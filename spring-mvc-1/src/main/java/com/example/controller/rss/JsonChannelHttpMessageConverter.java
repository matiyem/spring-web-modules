package com.example.controller.rss;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedOutput;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 9:27 AM
 **/
public class JsonChannelHttpMessageConverter extends AbstractHttpMessageConverter<Channel> {
    public JsonChannelHttpMessageConverter() {
        super(new MediaType("application", "rss+json"));
    }

    @Override
    protected boolean supports(Class<?> aclazz) {
        return Channel.class.isAssignableFrom(aclazz);
    }

    @Override
    protected Channel readInternal(Class<? extends Channel> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Channel wireFeed, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        WireFeedOutput feedOutput = new WireFeedOutput();

        String xmlStr = null;
        try {
            xmlStr = feedOutput.outputString(wireFeed, true);
            JSONObject xmlJsonObj = XML.toJSONObject(xmlStr);
            String jsonPrettyPrintString=xmlJsonObj.toString(4);

            outputMessage.getBody().write(jsonPrettyPrintString.getBytes(StandardCharsets.UTF_8));
        } catch (FeedException | JSONException e) {
            e.printStackTrace();
        }
    }


}
