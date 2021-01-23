package MW;

import MW.GameManagers.EventManager;
import MW.Kits.KitZombie;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin implements Listener {

    public static Plugin ourInstance;
    public static Kit[] allKits;
    public static HashMap<Player, GamePlayer> gamePlayerHashMap = new HashMap<>();

    public static void main(String[] args){
    }

    public static Plugin getInstance() {return ourInstance;}

    @Override
    public void onEnable() {
        ourInstance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new EventManager(), this);

        allKits = new Kit[]{

                //List of all kits. Be sure to add any new kits to this list so that they appear in game.
                new KitZombie()
        };
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        allKits[0].equipKit((Player) sender); //temporary code that equips the kit being used for testing. will be replaced with a proper command when another kit is added.
        return true;
    }
}