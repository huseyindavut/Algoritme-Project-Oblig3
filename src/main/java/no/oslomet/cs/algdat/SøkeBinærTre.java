package no.oslomet.cs.algdat;

import java.util.*;

public class SøkeBinærTre<T> implements Beholder<T> {

    // En del kode er ferdig implementert, hopp til linje 91 for Oppgave 1

    private static final class Node<T> { // En indre nodeklasse
        private T verdi; // Nodens verdi
        private Node<T> venstre, høyre, forelder; // barn og forelder

        // Konstruktører
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> f) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            forelder = f;
        }

        private Node(T verdi, Node<T> f) {
            this(verdi, null, null, f);
        }

        @Override
        public String toString() {
            return verdi.toString();
        }
    } // class Node

    private final class SBTIterator implements Iterator<T> {
        Node<T> neste;

        public SBTIterator() {
            neste = førstePostorden(rot);
        }

        public boolean hasNext() {
            return (neste != null);
        }

        public T next() {
            Node<T> denne = neste;
            neste = nestePostorden(denne);
            return denne.verdi;
        }
    }

    public Iterator<T> iterator() {
        return new SBTIterator();
    }

    private Node<T> rot;
    private int antall;
    private int endringer;

    private final Comparator<? super T> comp;

    public SøkeBinærTre(Comparator<? super T> c) {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;
        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }
        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot);
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    // Oppgave 1
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Det er en legginn som er ikke lov"); //Her det sjekker at verdien ikke er null. Kaster en feil hvis verdi er null.

        Node<T> p = rot;    // Setter rot-noden som startpunkt for å søke etter riktig plassering.
        Node<T> q = null;   // Brukes for å lagre den siste noden som ble besøkt.
        int cmp = 0; // Vi lages det til å lagre resultatet av sammenligningen mellom "verdi" og "p.verdi".

        while (p != null) { // Går gjennom treet for å finne riktig plassering for "verdi".
            q = p;          // Oppdaterer "q" til å være den nåværende noden.
            cmp = comp.compare(verdi, p.verdi); // Sammenligner den nye verdien med verdien i den nåværende noden.
            p = cmp < 0 ? p.venstre : p.høyre; // Går til venstre barn hvis verdien er mindre, ellers til høyre.
        }

        p = new Node<>(verdi, q); // Oppretter en ny node med verdien, og kobler den til forrige node ("q").

        if (q == null) rot = p; // Hvis treet er tomt, settes den nye noden som rot.
        else if (cmp < 0) q.venstre = p;   // Hvis verdien er mindre enn "q", legges den til som venstre barn.
        else q.høyre = p;  // Hvis verdien er større eller lik "q", legges den til som høyre barn.

        antall++;     // Øker antall noder i treet.
        endringer++;     // Øker antall endringer i treet (brukt for å spore strukturelle endringer).

        return true;  // Returnerer "true" for å indikere at innleggingen var vellykket.
    }


    // Oppgave 2
    public int antall(T verdi) {
        int antallForventningsVerdi = 0; // Denne er en variabel som holder styr på hvor mange ganger vi finner 'verdi' i treet.


        if (inneholder(verdi)) { // Sjekker om treet inneholder 'verdi'. Hvis ikke, går vi ikke videre.
            Node<T> p = rot; // Starter søket fra rotnoden i treet.

            while (p != null) { // Så lenge vi ikke har kommet til en null node (tom plass i treet), fortsetter vi søket.

                int comparator = comp.compare(verdi, p.verdi); // Sammenligner verdien vi leter etter ('verdi') med verdien i den nåværende noden ('p.verdi').

                if (comparator < 0) { // Hvis 'verdi' er mindre enn nodens verdi, går vi til venstre i treet (fordi venstre undertre inneholder mindre verdier).
                    p = p.venstre;
                } else { // Hvis 'verdi' er større enn eller lik nodens verdi, går vi til høyre.
                    if (comparator == 0) {  // Hvis 'verdi' er lik nodens verdi (sammenligningen returnerer 0), har vi funnet en forekomst.
                        antallForventningsVerdi++; // Øker telleren for antall forekomster med 1.
                    }
                    p = p.høyre;  // Uansett om vi fant en match eller ikke, går vi videre til høyre gren i treet.
                }
            }
        }
        return antallForventningsVerdi; // Returnerer antall ganger vi fant 'verdi' i treet.
    }

    // Oppgave 3
    private Node<T> førstePostorden(Node<T> p) {
        throw new UnsupportedOperationException();
    }

    private Node<T> nestePostorden(Node<T> p) {
        throw new UnsupportedOperationException();
    }

    // Oppgave 4
    public void postOrden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException();
    }

    public void postOrdenRekursiv(Oppgave<? super T> oppgave) {
        postOrdenRekursiv(rot, oppgave); // Ferdig implementert
    }

    private void postOrdenRekursiv(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException();
    }

    // Oppgave 5
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException();
    }

    public void nullstill() {
        throw new UnsupportedOperationException();
    }
}