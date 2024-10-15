package fr.tangv.pickdeckcard.model.deck;

/**
 * Pile de carte de structure FIFO(Fisrt In First Out)
 * @param <T> le type de carte utilisé
 */
public interface Deck<T> {

    /**
     * Permet de mélanger le jeu de cartes
     */
    void mix();

    /**
     * Permet de récupérer la carte du dessus de la pile
     * @return la carte du dessus de la pile, null si plus de carte dans la pile
     */
    T poll();

    /**
     * Permet de récupérer la carte du dessus de la pile
     * @return la carte du dessus de la pile
     * @throws java.util.NoSuchElementException si plus de carte dans la pile
     */
    T remove();

    /**
     * Permet d'ajouter une carte sur la pile de carte
     * @param card la carte ajouter
     */
    void add(T card);

    /**
     * Permet de connaitre le nombre de cartes dans la pile
     * @return le nombre de cartes dans la pile
     */
    int size();

    /**
     * Permet de savoir si la pile est vide
     * @return true si la pile est vide, sinon false
     */
    boolean isEmpty();

    /**
     * Permet de transférer l'intégralité de la pile vers une autre pile (vide la pile)
     * @param deck l'autre pile
     */
    void transfertTo(Deck<T> deck);

}
