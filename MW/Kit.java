package MW;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Kit {

    protected String name = "Unnamed Kit";
    protected double damage = 0;
    protected double armor = 0;
    protected double knockback = 0;
    protected double regen = 0;
    protected float speed = 0f;
    protected String[] description;
    protected Material menuItem;
    protected DisguiseType disguise;

    protected Player owner;
    protected Plugin plugin;

    public Kit(){this.plugin = Main.getInstance();}

    public void equipKit(Player player){
        destroyKit();
        owner = player;
        player.sendMessage("You equipped " + name + "!");
        player.getInventory().clear();
        player.setExp(0);
        player.setWalkSpeed(speed);
        if (disguise != null) {
            MobDisguise disg = new MobDisguise(disguise);
            disg.setEntity(player);
            FlagWatcher watcher = disg.getWatcher();
            watcher.setCustomName("§a§l" + owner.getName());
            watcher.setCustomNameVisible(true);
            disg.startDisguise();
        }
        else {
            try {
                DisguiseAPI.undisguiseToAll(player);
            } catch (NullPointerException ex){}
        }
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
    }

    public void destroyKit(){
        owner = null;
    }
}
