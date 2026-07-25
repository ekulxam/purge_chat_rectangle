package survivalblock.purgechatrectangle;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import survivalblock.purgechatrectangle.config.PurgeChatRectangleConfig;

public class PurgeChatRectangle implements ClientModInitializer {
    public static final String MOD_ID = "purge_chat_rectangle";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        PurgeChatRectangleConfig.init();
    }

    public static boolean allowInputRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeInputRectangle();
    }

    public static boolean allowHistoryRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeHistoryRectangle();
    }
}
