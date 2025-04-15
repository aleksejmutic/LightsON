package model.gsonHelpers;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import model.CompositeWire;
import model.Consumer;
import model.Decorator;
import model.Element;
import model.FuseBox;
import model.GroupedElements;
import model.JunctionBox;
import model.JunctionPoint;
import model.Socket;
import model.SwitchElement;
import model.Wire;

public class ElementDeserializer implements JsonDeserializer<Element> {

	@Override
	public Element deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("elementType").getAsString();

        switch (type) {
            case "Fuses":
                return context.deserialize(jsonObject, FuseBox.class);
            case "Wire":
                return context.deserialize(jsonObject, Wire.class);
            case "Consumer":
                return context.deserialize(jsonObject, Consumer.class);
            case "Switch":
                return context.deserialize(jsonObject, SwitchElement.class);
            case "Socket":
                return context.deserialize(jsonObject, Socket.class);
            case "CompositeWire":
                return context.deserialize(jsonObject, CompositeWire.class);
            case "JunctionBox":
                return context.deserialize(jsonObject, JunctionBox.class);
            case "GroupedElements":
                return context.deserialize(jsonObject, GroupedElements.class);
            case "Decorator":
                return context.deserialize(jsonObject, Decorator.class);
            case "JunctionPoint":
                return context.deserialize(jsonObject, JunctionPoint.class);
              
            default:
                throw new JsonParseException("Unknown element type: " + type);
        }
	}

}
