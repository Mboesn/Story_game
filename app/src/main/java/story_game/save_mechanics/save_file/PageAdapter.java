package story_game.save_mechanics.save_file;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import story_game.text.Page;

/**
 * Used in order to serialize and deserialize Page files while only saving the
 * type and not any values.
 */
public class PageAdapter implements JsonSerializer<Page>, JsonDeserializer<Page> {

    /**
     * Gson invokes this call-back method during deserialization when it encounters
     * a field of the specified type.
     *
     * @param page      The page to serialize.
     * @param typeOfSrc the actual type (fully genericized version) of the source
     *                  object.
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(Page page, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("type", page.getClass().getName());
        return jsonObj;
    }

    /**
     * Gson invokes this call-back method during deserialization when it encounters
     * a field of the specified type.
     *
     * @param json    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @return a deserialized object of the specified type typeOfT which is a
     *         subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of
     *                            {@code typeOfT}
     */
    @Override
    public Page deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String type = json.getAsJsonObject().get("type").getAsString();
        try {
            Class<?> clazz = Class.forName(type);
            return (Page) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Did not manage to deserialize page.\nError: " + e);
            throw new JsonParseException(e);
        }
    }

}
