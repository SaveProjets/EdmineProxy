package fr.edminecoreteam.proxyapi.party;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InvitationsManager
{
    private HashMap<String, List<String>> playerRequest;

    public InvitationsManager() {
        playerRequest = new HashMap<>();
    }

    public void addInvitation(String player, String target) {
        List<String> invitedPlayers = playerRequest.get(player);
        if (invitedPlayers == null) {
            invitedPlayers = new ArrayList<>();
            playerRequest.put(player, invitedPlayers);
        }
        invitedPlayers.add(target);
    }

    public void removeInvitation(String player, String target) {
        List<String> invitedPlayers = playerRequest.get(player);
        if (invitedPlayers != null) {
            invitedPlayers.remove(target);
            if (invitedPlayers.isEmpty()) {
                playerRequest.remove(player);
            }
        }
    }

    public List<String> getPlayerInvitation(String player) {
        return playerRequest.get(player);
    }

    public boolean getPlayerIsInviteTarget(String player, String target) {

        List<String> invitedPlayers = playerRequest.get(player);
        if (invitedPlayers != null) {
            for (String invitee : invitedPlayers) {
                if (invitee.equals(target)) {
                    return true;
                }
            }
        }

        return false;
    }

    public HashMap<String, List<String>> getListOfPlayersRequest()
    {
        return new HashMap<>(playerRequest);
    }
}
