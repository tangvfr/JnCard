package fr.tangv.pickdeckcard.impl.board;

public class InitMethod {
    /*init deck

    this.hearthDeckBox = new IDeckBox<>();
        this.mainDeckBox = PollerDeckBox.createPollerDeckBox(
                this.hearthDeckBox,
                settings.numberHearthInMainDeck()
        );
     */


String t ="""
    private static final double RANDOM_50 = 0.5;

    public void initDecks() throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        this.hearthDeckBox.initialize(DeckFactory.createEmptyDeck(), DeckFactory.createHearthDeck());
        this.mainDeckBox.initialize(DeckFactory.createEmptyDeck(), DeckFactory.createAttackDeck());
    }

    public void initPlayers(Player player1, Player player2) throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        throw new RuntimeException("Not yet implemented");
    }


    public void calcFirstPlayerTurn() throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTED, GameNotStartingException.class);
        int playerHearts1 = this.getPlayer1().countHearths();
        int playerHearts2 = this.getPlayer2().countHearths();

        if (playerHearts1 == playerHearts2) {//random choice
            this.currentPlayer = Math.random() < RANDOM_50 ? this.getPlayer1() : this.getPlayer2();
        } else if (playerHearts1 < playerHearts2) {//lesser hearts choice
            this.currentPlayer = this.getPlayer1();
        } else {//(playerHearts2 < playerHearts1) {//lesser hearts choice
            this.currentPlayer = this.getPlayer2();
        }
    }

    /**
     * Permet de faire piocher des cartes d'une pioche au deux joueurs
     * @param deckBox le pioche
     * @param amount le nombre de cartes piochées
     * @throws EmptyDeckException si plus de carte a piocher
     */
    private void giveCard(DeckBox<T> deckBox, int amount) throws EmptyDeckException {
        deckBox.playerPollCard(this.getPlayer1(), amount);
        deckBox.playerPollCard(this.getPlayer2(), amount);
    }

    /**
     * Permet de faire piocher des cartes d'une pioche au deux joueurs
     * @param deckBox le pioche
     * @throws EmptyDeckException si plus de carte a piocher
     */
    private void giveCard(DeckBox<T> deckBox) throws EmptyDeckException {
        deckBox.playerPollCard(this.getPlayer1());
        deckBox.playerPollCard(this.getPlayer2());
    }

    @Override
    public void giveCards() throws GameNotStartingException, GameSettingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        //variable
        GameSettings settings = this.game.getSettings();
        DeckBox<T> heartDeck = this.getHearthDeckBox();
        DeckBox<T> mainDeck = this.getMainDeckBox();

        try {
            //give the 2 ten
            this.giveCard(heartDeck);

            //mix decks
            heartDeck.remix();
            mainDeck.remix();

            //give cards
            this.giveCard(heartDeck, settings.getStartingNumberHearthCard());
            this.giveCard(mainDeck, settings.getStartingNumberAttackCard());
        } catch (EmptyDeckException e) {
            throw new GameSettingException("Cards gave at starting is too much");
        }
    }
""";
}
