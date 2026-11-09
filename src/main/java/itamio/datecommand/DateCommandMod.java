package itamio.datecommand;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("datecommand")
public class DateCommandMod {
    public DateCommandMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("date").requires(s -> s.hasPermission(0))
            .executes(ctx -> {
                var now = java.time.LocalDate.now(); var fmt = java.time.format.DateTimeFormatter.ofPattern("EEEE yyyy-MM-dd"); ctx.getSource().sendSuccess(() -> Component.literal("Today is " + now.format(fmt)), false);
                return 1;
            }));
    }
}
