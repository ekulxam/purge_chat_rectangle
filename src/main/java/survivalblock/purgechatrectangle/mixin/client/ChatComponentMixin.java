package survivalblock.purgechatrectangle.mixin.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Group;

import static survivalblock.purgechatrectangle.PurgeChatRectangle.allowHistoryRectangle;

@SuppressWarnings("MixinAnnotationTarget")
@Pseudo
@Mixin(targets = {"net/minecraft/class_338", "net/minecraft/client/gui/components/ChatComponent"})
public class ChatComponentMixin {
    // 1.14.4
    @Group(name = "purgeChatRectangle", min = 1)
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_332;fill(IIIII)V"), remap = false) // intermediary weird back then? No idea
    private static boolean skipOriginalStaticComponentIntermediary(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiComponent;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalStaticComponentMojmap(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle", min = 1)
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_338;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentIntermediary(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentMojmap(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    // 1.16.1
    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_25294(Lnet/minecraft/class_4587;IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentWithMatricesIntermediary(@Coerce Object instance, @Coerce Object matrices, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent;fill(Lcom/mojang/blaze3d/vertex/PoseStack;IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentWithMatricesMojmap(@Coerce Object instance, @Coerce Object matrices, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    // 1.21.1
    @Group(name = "purgeChatRectangle")
	@WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_332;method_25294(IIIII)V"), remap = false)
    private static boolean skipOriginalGraphicsIntermediary(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalGraphicsMojmap(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    // 1.21.11
    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_338$class_12233;method_75809(IIIII)V"), remap = false)
    private static boolean skipOriginalAccessObf(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalAccessDeobf(@Coerce Object instance, int i, int j, int k, int l, int m) {
        return allowHistoryRectangle();
    }
}