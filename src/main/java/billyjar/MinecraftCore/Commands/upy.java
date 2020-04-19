package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player; //add these in they're usefull
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.math.BlockFace;

public class upy extends CommandBase {
    public upy (CoreApi api) {
        super("upy", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {
            return false;
        }
        sender.sendMessage("Whoosh, you've gone up loads");
        Player player = (Player) sender;
        Level level = player.getLevel();
        level.setBlock(player.getPosition(), Block.get(Block.GLASS));

        return true;
    }
}
