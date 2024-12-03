package cn.ksmcbrigade.mchf;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MoreChatHistoryForge.MODID)
public class MoreChatHistoryForge
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "bml";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
    public static final ModConfigSpec.BooleanValue CHAT_HISTORY = builder.define("history",true);
    public static final ModConfigSpec.IntValue MAX_HISTORY = builder.defineInRange("maxHistory",16284,1,32767);
    public static final ModConfigSpec CONFIG_SPEC = builder.build();

    public MoreChatHistoryForge(IEventBus modEventBus, ModContainer modContainer)
    {
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT,CONFIG_SPEC);
        LOGGER.info("MCHF mod loaded.");
    }
}
