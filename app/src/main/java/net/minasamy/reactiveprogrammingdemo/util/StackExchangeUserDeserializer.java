package net.minasamy.reactiveprogrammingdemo.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Mina.Samy on 9/18/2016.
 */
public class StackExchangeUserDeserializer implements JsonDeserializer<List<StackExchangeUser>> {

    private final static String ITEMS="items";

    @Override
    public List<StackExchangeUser> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray itemsArray= json.getAsJsonObject().getAsJsonArray(ITEMS);
        Type arrayType=new TypeToken<List<StackExchangeUser>>(){}.getType();
        return new Gson().fromJson(itemsArray,arrayType);
    }
}
