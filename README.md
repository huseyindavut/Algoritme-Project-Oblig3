[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/teLsEufN)

Student; Huseyin Davutoglu
Studentnummer; 381403
E-mail; hudav8489@oslomet.no

# Oppgave 1

Denne oppgaven handler om å legge inn en ny verdi i et binært søketre.
Jeg begynte med å sikre at verdien ikke er null, da dette ville føre til en feil i treet.
Deretter initierte jeg en løkke for å navigere gjennom treet fra roten til riktig posisjon basert på sammenligninger.
Når den riktige plasseringen er funnet, opprettes en ny node og knyttes til treet, enten som venstre eller høyre barn av den siste besøkte noden. 
Til slutt oppdateres antall noder og endringer i treet for å reflektere denne innsettingen.

# Oppgave 2

I denne oppgaven målet mitt er å telle antall forekomster av en spesifikk verdi i treet.
Først sjekker metoden om verdien faktisk finnes i treet, for deretter å starte søket fra roten.
Løkken navigerer gjennom treet ved å sammenligne verdien med nodene og teller opp hver gang en match blir funnet. 
Ved å bruke sammenligninger, går vi enten til venstre eller høyre barn av noden,
og til slutt returneres antallet forekomster av den spesifikke verdien.

# Oppgave 3

Oppgaven handler om å finne den første noden i postorden-traverseringen av et binært tre.
Metoden tar en node som inngangsparameter og begynner fra denne noden. 
Jeg implementerte en evig løkke for å navigere gjennom venstre og høyre barn av noden i henhold til postorden-reglene.
Når en node uten barn (et blad) blir funnet, returneres den som den første noden i postorden. 
Dette er nyttig for å hjelpe med å implementere traversering i postorden senere i programmet.

# Oppgave 4

Her implementerte jeg en metode for postorden-traversering av treet, der en oppgave kan anvendes på hver node.
Metoden begynner med å finne den første noden i postorden og utfører oppgaven på denne noden. 
Deretter bruker den en løkke for å navigere til den neste noden i postorden og utføre oppgaven på hver node til det ikke er flere noder igjen.
Denne tilnærmingen muliggjør en enkel og effektiv traversering av treet i postorden, og oppgaver kan anvendes på nodene etter behov.

# Oppgave 5

I denne oppgaven har jeg implementert tre metoder i algoritme-faget som håndterer fjerning av noder fra et binært søketre:
fjern, fjernAlle, og nullstill. Metoden fjern(T verdi) søker etter en spesifisert verdi i treet og fjerner den hvis den finnes, 
samtidig som den håndterer forskjellige tilfeller av noder med null eller ett barn, samt noder med to barn. 
Denne metoden oppdaterer også forelder-pekere for å opprettholde treets struktur.
Metoden fjernAlle(T verdi) benytter seg av fjern for å fjerne alle forekomster av en gitt verdi, og returnerer antallet noder som ble fjernet. 
Til slutt, metoden nullstill() renser hele treet ved å sette alle noder, verdier og pekere til null, og setter antallet noder til 0. 
Dette gir en effektiv måte å tømme treet på, uten behov for ekstra metoder.




