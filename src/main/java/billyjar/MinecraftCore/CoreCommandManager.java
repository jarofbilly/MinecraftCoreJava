package billyjar.MinecraftCore;

import billyjar.MinecraftCore.Commands.speed;
import billyjar.MinecraftCore.Commands.up;
import cn.nukkit.command.CommandMap;

public class CoreCommandManager {
    public static void registerAll(CoreApi api) {
        CommandMap map = api.getServer().getCommandMap();
        map.register("CoreApi", new up(api));  //CassFile() //how to register commands
        map.register("CoreApi", new speed(api));
    }
}
