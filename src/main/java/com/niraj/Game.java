package com.niraj;

public class Game {
    private Table table;
    private GameStatus gameStatus;
    private Player playerTurn;
    private Player winnerPlayer;

    public Game(Table table) {
        this.table = table;
        this.gameStatus = GameStatus.ACTIVE;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    private void playerMove() {
        int movePoint = playerTurn.serve();
        if (movePoint == Constants.EVEN_POINT) {
            table.getFirstPlayer().incrementScore();
        } else {
            table.getSecondPlayer().incrementScore();
        }
    }

    private void identifyNextPlayerTurn() {
        if (playerTurn.isChangeTurn()) {
            playerTurn.setChangeTurn(false);
            playerTurn = table.getOppositePlayer(playerTurn);
        }
    }

    public void startGame() {
        this.playerTurn = table.getFirstPlayer();
        while (winnerPlayer == null) {
            playerMove();
            identifyNextPlayerTurn();
            GameStatus currentGameStatus = checkTieStatus();
            if (currentGameStatus == GameStatus.TIED_AT_10_10 || currentGameStatus == GameStatus.TIED_AT_20_20) {
                this.gameStatus = currentGameStatus;
                continue;
            }
            findWinner();
        }
    }

    private GameStatus checkTieStatus() {
        GameStatus tieStatus = null;
        if (table.getFirstPlayer().getScore() == Constants.SCORE_TEN && table.getSecondPlayer().getScore() == Constants.SCORE_TEN) {
            tieStatus = GameStatus.TIED_AT_10_10;
        } else if (table.getFirstPlayer().getScore() == Constants.SCORE_TWENTY && table.getSecondPlayer().getScore() == Constants.SCORE_TWENTY) {
            tieStatus = GameStatus.TIED_AT_20_20;
        }
        return tieStatus;
    }

    private void findWinner() {
        switch (this.gameStatus) {
            case ACTIVE:
                if (table.getFirstPlayer().getScore() == Constants.SCORE_ELEVEN) {
                    winnerPlayer = table.getFirstPlayer();
                    this.gameStatus = GameStatus.FIRST_PLAYER_WON;
                } else if (table.getSecondPlayer().getScore() == Constants.SCORE_ELEVEN) {
                    winnerPlayer = table.getSecondPlayer();
                    this.gameStatus = GameStatus.SECOND_PLAYER_WON;
                }
                break;
            case TIED_AT_10_10:
                if (Math.abs((table.getFirstPlayer().getScore() - table.getSecondPlayer().getScore())) == Constants.MIN_DIFF_TO_WIN) {
                    if (table.getFirstPlayer().getScore() > table.getSecondPlayer().getScore()) {
                        winnerPlayer = table.getFirstPlayer();
                        this.gameStatus = GameStatus.FIRST_PLAYER_WON;
                    } else {
                        winnerPlayer = table.getSecondPlayer();
                        this.gameStatus = GameStatus.SECOND_PLAYER_WON;
                    }
                }
                break;
            case TIED_AT_20_20:
                if (table.getFirstPlayer().getScore() == Constants.SCORE_TWENTY_ONE) {
                    winnerPlayer = table.getFirstPlayer();
                    this.gameStatus = GameStatus.FIRST_PLAYER_WON;
                } else if (table.getSecondPlayer().getScore() == Constants.SCORE_TWENTY_ONE) {
                    winnerPlayer = table.getSecondPlayer();
                    this.gameStatus = GameStatus.SECOND_PLAYER_WON;
                }
                break;
        }
    }
}
