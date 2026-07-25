package survivalblock.purgechatrectangle.mixin.client.config;

import com.llamalad7.mixinextras.sugar.Local;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.util.StringUtils;
import kr1v.malilibApi.ModRepresentation;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import survivalblock.purgechatrectangle.PurgeChatRectangle;

import java.util.Objects;

@Pseudo
@Mixin(targets = "kr1v.malilibApi.screen.ConfigScreen")
public abstract class ConfigScreenMixin extends GuiConfigsBase {
    public ConfigScreenMixin(int listX, int listY, String modId, Screen parent, String titleKey, Object... args) {
        super(listX, listY, modId, parent, titleKey, args);
    }

    @SuppressWarnings("LocalMayUseName")
    @ModifyArg(method = "createButton", at = @At(value = "INVOKE", target = "Lfi/dy/masa/malilib/gui/button/ButtonGeneric;<init>(IIIILjava/lang/String;[Ljava/lang/String;)V"), index = 4)
    private String letMeTranslateHer(String text, @Local(argsOnly = true) ModRepresentation.Tab tab) {
        if (!Objects.equals(this.modId, PurgeChatRectangle.MOD_ID)) {
            return text;
        }
        String key = tab.translationKey();
        if (!Objects.equals(text, key)) {
            return text; // already translated
        }
        return StringUtils.translate(text);
    }
}
