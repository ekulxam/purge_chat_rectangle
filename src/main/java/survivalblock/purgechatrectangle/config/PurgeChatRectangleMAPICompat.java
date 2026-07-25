package survivalblock.purgechatrectangle.config;

import kr1v.malilibApi.MalilibApi;
import kr1v.malilibApi.annotation.Config;
import kr1v.malilibApi.config.plus.ConfigBooleanPlus;
import survivalblock.purgechatrectangle.PurgeChatRectangle;

@Config(value = PurgeChatRectangle.MOD_ID, name = "PCR")
public class PurgeChatRectangleMAPICompat implements PurgeChatRectangleConfig {
    public static PurgeChatRectangleConfig create() {
        MalilibApi.registerMod(PurgeChatRectangle.MOD_ID, "Purge Chat Rectangle");

        return new PurgeChatRectangleConfig() {
            @Override
            public boolean removeInputRectangle() {
                return HIDE_INPUT_RECTANGLE.get();
            }

            @Override
            public boolean removeHistoryRectangle() {
                return HIDE_HISTORY_RECTANGLE.get();
            }
        };
    }

    public static final ConfigBooleanPlus HIDE_INPUT_RECTANGLE = new ConfigBooleanPlus("Hide Input Rectangle");
    public static final ConfigBooleanPlus HIDE_HISTORY_RECTANGLE = new ConfigBooleanPlus("Hide History Rectangle");

    static {
        HIDE_INPUT_RECTANGLE.setTranslatedName(PurgeChatRectangle.MOD_ID + ".hide_input_rectangle");
        HIDE_HISTORY_RECTANGLE.setTranslatedName(PurgeChatRectangle.MOD_ID + ".hide_history_rectangle");
    }
}
