package survivalblock.purgechatrectangle.config;

import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.ApiStatus;

public interface PurgeChatRectangleConfig {
    PurgeChatRectangleConfig INSTANCE = getInstance(FabricLoader.getInstance());

    default boolean removeInputRectangle() {
        return true;
    }

    default boolean removeHistoryRectangle() {
        return true;
    }

    @ApiStatus.Internal
    static PurgeChatRectangleConfig getInstance(FabricLoader floader) {
        if (floader.isModLoaded("malilib") && floader.isModLoaded("malilib-api")) {
            return PurgeChatRectangleMAPICompat.create();
        }
        return new PurgeChatRectangleConfig() {};
    }
}
