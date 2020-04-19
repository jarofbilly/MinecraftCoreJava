package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.*;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;


public class speed extends CommandBase{

    public speed(CoreApi api){
        super("speed", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {return false;} //if they have the permision to use this

        Player target = sender.getServer().getPlayerExact(sender.getName());

        //Item item = new Item(ItemID.COMPASS);
        //target.getInventory().setItem(4, item);
        //target.sendMessage("Given compass to " + target.getName());
        showCustom(target);

        return true;
    }

   /* public void showSimple(Player p) {
        FormWindowSimple gui = new FormWindowSimple("Gamemode UI", "Change your game mode quickly and simply");
        ElementButton custButton = new ElementButton("Custom button");
        custButton.addImage((new ElementButtonImageData("url", "https://i.imgur.com/AUrcTzD.png")));

        gui.addButton(custButton);
        gui.addButton(new ElementButton("Creative"));
        gui.addButton(new ElementButton("Survival"));
        gui.addButton(new ElementButton("Spectator"));


        p.showFormWindow(gui);
    }*/

    public void showCustom(Player p) {
        FormWindowCustom gui = new FormWindowCustom("Speed setter");
        gui.addElement(new ElementSlider("Set your speed", 0, 100, 1));
        p.showFormWindow(gui);

    }
}


