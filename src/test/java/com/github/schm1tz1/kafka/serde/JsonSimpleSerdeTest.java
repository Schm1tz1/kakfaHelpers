package com.github.schm1tz1.kafka.serde;

import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Arrays;

public class JsonSimpleSerdeTest {

    @Test
    public void serializerTest() {
        JsonSimpleSerializer ser = new JsonSimpleSerializer();
        JSONObject obj = new JSONObject();
        obj.put("name", "TEST");
        byte[] out = ser.serialize("test", obj);
        byte[] toCompare = new byte[] {123, 34, 110, 97, 109, 101, 34, 58, 34, 84, 69, 83, 84, 34, 125};
        assert(Arrays.equals(toCompare,out));
    }

    @Test
    public void deserializerTest() {
        JsonSimpleDeserializer deser = new JsonSimpleDeserializer();
        byte[] exampleIn = new byte[] {123, 34, 110, 97, 109, 101, 34, 58, 34, 84, 69, 83, 84, 34, 125};
        JSONObject out = deser.deserialize("test", exampleIn);
        JSONObject toCompare = new JSONObject();
        toCompare.put("name", "TEST");
        assert(out.equals(toCompare));
    }
}
