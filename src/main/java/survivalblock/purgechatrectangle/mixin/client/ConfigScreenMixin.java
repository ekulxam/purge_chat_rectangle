package survivalblock.purgechatrectangle.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.util.StringUtils;
import kr1v.malilibApi.ModRepresentation;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import survivalblock.purgechatrectangle.PurgeChatRectangle;

import java.util.Objects;

@Pseudo
@Mixin(targets = "kr1v.malilibApi.screen.ConfigScreen")
public abstract class ConfigScreenMixin extends GuiConfigsBase {
    public ConfigScreenMixin(int listX, int listY, String modId, Screen parent, String titleKey, Object... args) {
        super(listX, listY, modId, parent, titleKey, args);
    }

    @WrapOperation(method = "createButton", at = @At(value = "INVOKE", target = "Lkr1v/malilibApi/ModRepresentation$Tab;translationKey()Ljava/lang/String;"))
    private String letMeTranslateHer(ModRepresentation.Tab instance, Operation<String> original) {
        String tab = original.call(instance);
        return Objects.equals(this.modId, PurgeChatRectangle.MOD_ID) ? StringUtils.translate(tab) : tab;
    }
}
