package cn.kycraft.kuayue.parts.core.factory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.createmod.catnip.data.Couple;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.phys.Vec3;

public class FactoryParams {

    public static String getString(JsonObject params, String key) {
        if (params == null) return null;
        return params.has(key) ? params.get(key).getAsString() : null;
    }

    public static String getStringOr(JsonObject params, String key, String fallback) {
        if (params == null) return fallback;
        return params.has(key) ? params.get(key).getAsString() : fallback;
    }

    public static boolean getBooleanOr(JsonObject params, String key, boolean fallback) {
        if (params == null) return fallback;
        return params.has(key) ? params.get(key).getAsBoolean() : fallback;
    }

    public static int getIntOr(JsonObject params, String key, int fallback) {
        if (params == null) return fallback;
        return params.has(key) ? params.get(key).getAsInt() : fallback;
    }

    public static float getFloatOr(JsonObject params, String key, float fallback) {
        if (params == null) return fallback;
        return params.has(key) ? params.get(key).getAsFloat() : fallback;
    }

    public static Couple<ResourceLocation> getModelCouple(JsonObject params, String key) {
        if (params == null || !params.has(key)) return Couple.create(null, null);
        JsonArray array = params.getAsJsonArray(key);
        if (array == null || array.size() < 2) return Couple.create(null, null);
        return Couple.create(
                ResourceLocation.parse(array.get(0).getAsString()),
                ResourceLocation.parse(array.get(1).getAsString())
        );
    }

    public static Vec3 getVec3(JsonObject params, String key, Vec3 fallback) {
        if (params == null || !params.has(key)) return fallback;
        JsonArray array = params.getAsJsonArray(key);
        if (array == null || array.size() < 3) return fallback;
        return new Vec3(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble());
    }

    public static RenderShape getRenderShape(JsonObject params, String key, RenderShape fallback) {
        if (params == null || !params.has(key)) return fallback;
        String value = params.get(key).getAsString();
        return switch (value) {
            case "invisible" -> RenderShape.INVISIBLE;
            case "model" -> RenderShape.MODEL;
            case "entityblock_animated" -> RenderShape.ENTITYBLOCK_ANIMATED;
            default -> fallback;
        };
    }
}
