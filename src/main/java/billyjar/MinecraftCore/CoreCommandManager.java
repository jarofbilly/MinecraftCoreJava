package billyjar.MinecraftCore;

import billyjar.MinecraftCore.Commands.speed;
import billyjar.MinecraftCore.Commands.top;
import billyjar.MinecraftCore.Commands.upy;
import cn.nukkit.command.CommandMap;

public class CoreCommandManager {
    public static void registerAll(CoreApi api) {
        CommandMap map = api.getServer().getCommandMap();
        map.register("CoreApi", new upy(api));  //CassFile() //how to register commands
        map.register("CoreApi", new speed(api));
        map.register("CoreApi", new top(api));
    }
}
