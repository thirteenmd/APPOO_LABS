package com.appoo.chess;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer gamesPlayed;
    private Integer gamesWon;

    public Player(String name) {
        this.name = name.trim();
        gamesPlayed = 0;
        gamesWon = 0;
    }

    public String getName() {
        return name;
    }

    //Returns the number of games played
    public Integer getgamesPlayed() {
        return gamesPlayed;
    }

    //Returns the number of games won
    public Integer getgamesWon() {
        return gamesWon;
    }

    //Calculates the win percentage of the player
    public Integer winpPercent() {
        return (gamesWon * 100) / gamesPlayed;
    }

    //Increments the number of games played
    public void updategamesPlayed() {
        gamesPlayed++;
    }

    //Increments the number of games won
    public void updategamesWon() {
        gamesWon++;
    }


    //Function to fetch the list of the players
    public static ArrayList<Player> fetch_players() {
        Player tempplayer;
        ObjectInputStream input = null;
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            File infile = new File(System.getProperty("user.dir") + File.separator + "chessgamedata.dat");
            input = new ObjectInputStream(new FileInputStream(infile));
            try {
                while (true) {
                    tempplayer = (Player) input.readObject();
                    players.add(tempplayer);
                }
            } catch (EOFException e) {
                input.close();
            }
        } catch (FileNotFoundException e) {
            players.clear();
            return players;
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ignored) {
            }
            JOptionPane.showMessageDialog(null, "Unable to read the required Game files !!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Game Data File Corrupted !! Click Ok to Continue Builing New File");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return players;
    }


    //Function to update the statistics of a player
    public void Update_Player() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Player temp_player;
        File inputfile = null;
        File outputfile = null;
        try {
            inputfile = new File(System.getProperty("user.dir") + File.separator + "chessgamedata.dat");
            outputfile = new File(System.getProperty("user.dir") + File.separator + "tempfile.dat");
        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(null, "Read-Write Permission Denied !! Program Cannot Start");
            System.exit(0);
        }
        boolean playerdonotexist;
        try {
            if (!outputfile.exists())
                outputfile.createNewFile();
            if (!inputfile.exists()) {
                output = new ObjectOutputStream(new java.io.FileOutputStream(outputfile, true));
                output.writeObject(this);
            } else {
                input = new ObjectInputStream(new FileInputStream(inputfile));
                output = new ObjectOutputStream(new FileOutputStream(outputfile));
                playerdonotexist = true;
                try {
                    while (true) {
                        temp_player = (Player) input.readObject();
                        if (temp_player.getName().equals(getName())) {
                            output.writeObject(this);
                            playerdonotexist = false;
                        } else
                            output.writeObject(temp_player);
                    }
                } catch (EOFException e) {
                    input.close();
                }
                if (playerdonotexist)
                    output.writeObject(this);
            }
            inputfile.delete();
            output.close();
            File newf = new File(System.getProperty("user.dir") + File.separator + "chessgamedata.dat");
            if (!outputfile.renameTo(newf))
                System.out.println("File Renameing Unsuccessful");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to read/write the required Game files !! Press ok to continue");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Game Data File Corrupted !! Click Ok to Continue Builing New File");
        } catch (Exception ignored) {

        }
    }
}
