package survivalblock.purgechatrectangle;

import net.fabricmc.api.ModInitializer;
import survivalblock.purgechatrectangle.config.PurgeChatRectangleConfig;

public class PurgeChatRectangle implements ModInitializer {
    public static final String MOD_ID = "purge_chat_rectangle";

    @Override
    public void onInitialize() {
        PurgeChatRectangleConfig.init();
    }

    public static boolean allowInputRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeInputRectangle();
    }

    public static boolean allowHistoryRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeHistoryRectangle();
    }
}
