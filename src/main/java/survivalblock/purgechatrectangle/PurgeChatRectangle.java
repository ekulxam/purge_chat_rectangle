package survivalblock.purgechatrectangle;

import net.fabricmc.api.ClientModInitializer;
import survivalblock.purgechatrectangle.config.PurgeChatRectangleConfig;

public class PurgeChatRectangle implements ClientModInitializer {
    public static final String MOD_ID = "purge_chat_rectangle";

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

    public static void logError(String message, Throwable throwable) {
        try {
            org.slf4j.LoggerFactory.getLogger(MOD_ID).error(message, throwable);
            return;
        } catch (NoClassDefFoundError | Exception ignored) {
        }

        try {
            org.apache.logging.log4j.LogManager.getLogger(MOD_ID).error(message, throwable);
            return;
        } catch (NoClassDefFoundError | Exception ignored) {
        }

        System.err.println("[" + MOD_ID + "] " + message);
        //noinspection CallToPrintStackTrace (sorry I've already tried two loggers)
        throwable.printStackTrace();
    }
}
