package MW;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class GamePlayer { // GamePlayer is a class used to keep track of the custom attributes and details for each player.

    private HashMap<Player, Integer> playerMeleeIframes = new HashMap<>();
    private HashMap<Player, Integer> playerAbilityIframes = new HashMap<>();
    private double incomingDamageMultiplier = 1;
    private double outgoingDamageMultiplier = 1;
    private String lastDamageReason = "none";
    private Player player;
    private Kit kit;

    public GamePlayer(Player setPlayer){player = setPlayer;}

    public void setPlayerMeleeIframes(Player attacker, int iframes){
        if (playerMeleeIframes.containsKey(attacker)){
            return;
        }
        playerMeleeIframes.put(attacker, iframes);
        new BukkitRunnable() {
            @Override
            public void run(){
                int frames = playerMeleeIframes.get(attacker);
                Bukkit.broadcastMessage("iframes = " + frames);
                frames--;
                playerMeleeIframes.replace(attacker, frames);
                if (frames <= 0){
                    playerMeleeIframes.remove(attacker);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0,1);
    }

    public HashMap<Player, Integer> getPlayerMeleeIframes(){return playerMeleeIframes;}

    public HashMap<Player, Integer> getPlayerAbilityIframes(){return playerAbilityIframes;}

    public double getIncomingDamageMultiplier(){return incomingDamageMultiplier;}

    public void setIncomingDamageMultiplier(double setMultiplier){incomingDamageMultiplier = setMultiplier;}

    public double getOutgoingDamageMultiplier(){return outgoingDamageMultiplier;}

    public void setOutgoingDamageMultiplier(double setMultiplier){outgoingDamageMultiplier = setMultiplier;}

    public String getLastDamageReason(){return lastDamageReason;}

    public void setLastDamageReason(String setReason){lastDamageReason = setReason;}

    public Player getPlayer(){return player;}

    public Kit getKit(){return kit;}

    public void setKit(Kit setKit){kit = setKit;}
}
