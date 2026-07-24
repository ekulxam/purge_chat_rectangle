package survivalblock.purgechatrectangle;

import net.fabricmc.api.ModInitializer;
import survivalblock.purgechatrectangle.config.PurgeChatRectangleConfig;

public class PurgeChatRectangle implements ModInitializer {
    @Override
    public void onInitialize() {
    }

    public static boolean allowInputRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeInputRectangle();
    }

    public static boolean allowHistoryRectangle() {
        return !PurgeChatRectangleConfig.INSTANCE.removeHistoryRectangle();
    }
}
