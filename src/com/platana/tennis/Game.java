package com.platana.tennis;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int scoredPlayer;
        int round = 0;
        Scanner input = new Scanner (System.in);
        Player player1;
        Player player2;
        Player winner=null;
        System.out.print ("Enter name player 1: ");
        player1 = new Player (input.nextLine ());
        System.out.print ("Enter name player 2: ");
        player2 = new Player (input.nextLine ());
        while (winner==null) {
            System.out.print ("who win the ball: ");
            scoredPlayer = input.nextInt ();
            if (scoredPlayer == 1) {
                player1.addScore (player2.getScore (),player2.isHasAd ());
            } else {
                player2.addScore (player1.getScore (),player1.isHasAd ());
            }
            if(player1.isHasAd () && player2.isHasAd ())
            {
                player1.resetScore (40);
                player2.resetScore (40);

            }
            //check Players----------- 70 means AD=55 + won the ball
            if (player1.getScore () == 70 || player2.getScore () == 70 ||
                    (player1.getScore ()==55 && player2.getScore () <40) ||
                    (player2.getScore ()==55 && player1.getScore () <40)) {
                if (player1.getScore () == 70 || player1.getScore ()==55)
                    player1.getRounds ()[round] += 1;
                if (player2.getScore () == 70 || player2.getScore ()==55)
                    player2.getRounds ()[round] += 1;
                // condition for winning the game
                if(player1.getRounds ()[round]>=6 && player1.getRounds ()[round] - player2.getRounds ()[round] >=2) {
                    round++;
                    player1.wonMatch ();
                    if(player1.hasWonTheGame ())
                    {
                        winner=player1;
                    }
                }
                // condition for winning the game
                if(player2.getRounds ()[round]>=6 && player2.getRounds ()[round] - player1.getRounds ()[round] >=2) {
                    round++;
                    player2.wonMatch ();
                    if(player2.hasWonTheGame ())
                    {
                        winner=player2;
                    }
                }
                player1.resetScore (0);
                player2.resetScore (0);
            }
            System.out.println (player1);
            System.out.println (player2);
        }
        System.out.println ("Winner is "+winner.getName ());
    }

}
