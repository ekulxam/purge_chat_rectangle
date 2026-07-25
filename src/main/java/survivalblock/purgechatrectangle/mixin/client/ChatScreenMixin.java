package survivalblock.purgechatrectangle.mixin.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Group;

import static survivalblock.purgechatrectangle.PurgeChatRectangle.allowInputRectangle;

@SuppressWarnings("MixinAnnotationTarget")
@Pseudo
@Mixin(targets = {"net/minecraft/class_408", "net/minecraft/client/gui/screens/ChatScreen"})
public class ChatScreenMixin {
    // 1.14.4
    @Group(name = "purgeChatRectangle", min = 1)
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_332;fill(IIIII)V"), remap = false) // intermediary weird back then? No idea
    private static boolean skipOriginalStaticComponentIntermediary(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiComponent;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalStaticComponentMojmap(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    @Group(name = "purgeChatRectangle", min = 1)
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_408;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentIntermediary(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/ChatScreen;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentMojmap(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    // 1.16.1
    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_408;method_25294(Lnet/minecraft/class_4587;IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentWithMatricesIntermediary(@Coerce Object matrices, int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/ChatScreen;fill(Lcom/mojang/blaze3d/vertex/PoseStack;IIIII)V"), remap = false)
    private static boolean skipOriginalDeclaredComponentWithMatricesMojmap(@Coerce Object matrices, int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    // 1.21.1
    @Group(name = "purgeChatRectangle", min = 1)
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_332;method_25294(IIIII)V"), remap = false)
    private static boolean skipOriginalGraphicsIntermediary(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalGraphicsMojmap(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }

    // 26.1, GuiGraphicsExtractor didn't exist before
    @Group(name = "purgeChatRectangle")
    @WrapWithCondition(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V"), remap = false)
    private static boolean skipOriginalExtractorDeobf(int i, int j, int k, int l, int m) {
        return allowInputRectangle();
    }
}