package tc.oc.pgm.tracker.trackers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import tc.oc.pgm.events.ParticipantBlockTransformEvent;
import tc.oc.pgm.tracker.damage.DispenserInfo;

/**
 * Updates the state of owned dispensers. The ownership of dispensed things is handled by other trackers.
 */
public class DispenserTracker extends AbstractTracker<DispenserInfo> {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlace(ParticipantBlockTransformEvent event) {
        if(event.getNewState().getMaterial() == Material.DISPENSER) {
            blocks().trackBlockState(event.getNewState(), new DispenserInfo(event.getPlayerState()));
        }
    }
}
