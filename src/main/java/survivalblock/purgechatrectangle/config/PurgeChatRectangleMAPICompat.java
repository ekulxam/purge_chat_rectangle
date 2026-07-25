package survivalblock.purgechatrectangle.config;

import fi.dy.masa.malilib.config.options.ConfigBase;
import kr1v.malilibApi.MalilibApi;
import kr1v.malilibApi.annotation.Config;
import kr1v.malilibApi.config.plus.ConfigBooleanPlus;
import survivalblock.purgechatrectangle.PurgeChatRectangle;

import java.lang.reflect.Field;

@Config(value = PurgeChatRectangle.MOD_ID, name = "purge_chat_rectangle.tab")
public class PurgeChatRectangleMAPICompat implements PurgeChatRectangleConfig {
    public static PurgeChatRectangleConfig create() {
        MalilibApi.registerMod(PurgeChatRectangle.MOD_ID, "Purge Chat Rectangle");

        return new PurgeChatRectangleConfig() {
            @Override
            public boolean removeInputRectangle() {
                return HIDE_INPUT_RECTANGLE.getBooleanValue();
            }

            @Override
            public boolean removeHistoryRectangle() {
                return HIDE_HISTORY_RECTANGLE.getBooleanValue();
            }
        };
    }

    public static final ConfigBooleanPlus HIDE_INPUT_RECTANGLE;
    public static final ConfigBooleanPlus HIDE_HISTORY_RECTANGLE;

    static {
        HIDE_INPUT_RECTANGLE = new ConfigBooleanPlus("Hide Input Rectangle");
        HIDE_HISTORY_RECTANGLE = new ConfigBooleanPlus("Hide History Rectangle");

        String inputTranslated = PurgeChatRectangle.MOD_ID + ".hide_input_rectangle";
        String historyTranslated = PurgeChatRectangle.MOD_ID + ".hide_history_rectangle";

        Class<?> clazz = ConfigBase.class;

        try {
            Field translatedName = clazz.getDeclaredField("translatedName");
            translatedName.setAccessible(true);

            translatedName.set(HIDE_INPUT_RECTANGLE, inputTranslated);
            translatedName.set(HIDE_HISTORY_RECTANGLE, historyTranslated);
        } catch (ReflectiveOperationException e) {
            try {
                Field prettyName = clazz.getDeclaredField("prettyName");
                prettyName.setAccessible(true);

                prettyName.set(HIDE_INPUT_RECTANGLE, inputTranslated);
                prettyName.set(HIDE_HISTORY_RECTANGLE, historyTranslated);
            } catch (ReflectiveOperationException e1) {
                e1.addSuppressed(e);
                PurgeChatRectangle.logError("Unable to load config translations!", e1);
            }
        }
    }
}
