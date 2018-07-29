package com.springfox.cuclinet;

import club.minnced.discord.rpc.*;
import javax.swing.*; 

public class Main {
    public static void main(String[] args) {
    	//1. Create the frame.
    	JFrame frame = new JFrame("FrameDemo");

    	//2. Optional: What happens when the frame closes?
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	//4. Size the frame.
    	frame.pack();

    	//5. Show it.
    	frame.setVisible(true);
        DiscordRPC lib = DiscordRPC.INSTANCE;
        String applicationId = appid.id;
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence discordPresence = new DiscordRichPresence();
        discordPresence.state = cu.playingon;
        discordPresence.details = cu.gamestamp;
        discordPresence.startTimestamp = cu.timestampstart;
        discordPresence.endTimestamp = cu.timestampend;
        discordPresence.largeImageKey = cu.playingimageping;
        discordPresence.largeImageText = cu.playingin;
        discordPresence.smallImageKey = cu.imageping1;
        discordPresence.smallImageText = cu.imagepingt1;
        discordPresence.partyId = cu.partyid;
        discordPresence.partySize = cu.playersparty;
        discordPresence.partyMax = game.playercountparty2;
        discordPresence.spectateSecret = cu.secret1;
        discordPresence.joinSecret = cu.secret2;
        lib.Discord_UpdatePresence(discordPresence);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }
}
