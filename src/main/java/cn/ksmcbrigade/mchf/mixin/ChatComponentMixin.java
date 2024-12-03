package cn.ksmcbrigade.mchf.mixin;

import cn.ksmcbrigade.mchf.MoreChatHistoryForge;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {
    @Inject(method = "clearMessages",at = @At("HEAD"),cancellable = true)
    public void clear(boolean p_93796_, CallbackInfo ci){
        if(MoreChatHistoryForge.CHAT_HISTORY.get()) ci.cancel();
    }

    @ModifyExpressionValue(
            method = {"addMessageToDisplayQueue", "addMessageToQueue", "addRecentChat"},
            at = @At(value = "CONSTANT", args = "intValue=100")
    )
    public int changeMaxHistory(int original) {
        return original+MoreChatHistoryForge.MAX_HISTORY.get();
    }
}
