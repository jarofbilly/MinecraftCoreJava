package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

public class top extends CommandBase{
    public top(CoreApi api){
        super("top", api);
    }

    public boolean execute(CommandSender sender, String s, String[] strings) {
        if (!this.testPermission(sender)) {return false;}

        Player player = (Player) sender;
        player.teleport(api.getHighestStandablePositionAt(player));
        return true;
    }
}
