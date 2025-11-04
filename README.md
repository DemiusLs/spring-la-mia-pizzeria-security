Parte 1
Step 1
Dobbiamo realizzare un’applicazione web che ci aiuti a gestire la nostra pizzeria.

Abbiamo bisogno di creare la prima pagina (index) dove mostriamo tutte le pizze che prepariamo. Nei prossimi giorni implementeremo il resto dei metodi per le CRUD.


Una pizza avrà le seguenti informazioni :

un id
un nome
una descrizione
una foto (url)
un prezzo

Creiamo il database, repository e l'entity per gestire le CRUD delle pizze.

Implementiamo quindi il controller con il metodo index che restituisce una view per mostrare l’elenco delle pizze caricate dal database (possiamo creare una tabella con bootstrap o una qualche grafica a nostro piacimento che mostri questo elenco... con un po’ di creatività se vogliamo!)

L’elenco potrebbe essere vuoto: in quel caso dobbiamo mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella nostra applicazione.

Gestiamo i componenti riutilizzabili con i fragments.

Step 2
Mostriamo una singola pizza.

Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato ci porterà a una pagina che mostrerà i dettagli della pizza scelta. Dobbiamo quindi inviare l’id come parametro dell’URL, recuperarlo nel metodo del controller, caricare i dati della pizza ricercata e passarli come model.

La view a quel punto li mostrerà all’utente con la grafica che preferiamo.
Step 3 - Bonus
Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se compilato filtrerà le pizze (lato server) aventi come titolo quello inserito dall’utente.

Parte 2

Step 1
Abbiamo la lista delle pizze, abbiamo i dettagli delle pizze...perchè non realizzare la pagina per la creazione di una nuova pizza?

Aggiungiamo quindi tutto il codice necessario per mostrare il form per la creazione di una nuova pizza e per il salvataggio dei dati in tabella.

Nella index creiamo ovviamente il bottone “Crea nuova pizza” che ci porta a questa nuova pagina creata.

Ricordiamoci che l’utente potrebbe sbagliare inserendo dei dati: gestiamo quindi la validazione! Ad esempio verifichiamo che :
i dati della pizza siano tutti presenti
il campi di testo non superino una certa lunghezza 
il prezzo abbia un valore valido (ha senso una pizza con prezzo minore o uguale a zero?)
Step 2
Completiamo le pagine di gestione delle nostre pizze!

Abbiamo la pagina con la lista di tutte le pizze, quella con i dettagli della singola pizza, quella per crearla...cosa manca?

Dobbiamo realizzare :
pagina di modifica di una pizza 
cancellazione di una pizza, cliccando un pulsante presente nella grafica di ogni singolo prodotto mostrato (nella lista in index)

Parte 3
Nuova importante funzionalità : le offerte speciali!
In alcuni momenti potremmo voler vendere le nostre pizze a un prezzo scontato.

Dobbiamo quindi predisporre tutto il codice necessario per poter collegare un’offerta speciale a una pizza (in una relazione 1 a molti, cioè un’offerta speciale può essere collegata a una sola pizza, e una pizza può essere collegata a più offerte speciali).


L’offerta speciale avrà :

una data di inizio
una data di fine
un titolo
La pagina di dettaglio della singola pizza mostrerà l’elenco delle offerte collegate e avrà un bottone “Crea nuova offerta speciale” per aggiungerne una nuova.

Accanto ad ogni offerta speciale è previsto un bottone che mi porterà a una pagina per modificarla.

Parte 4
Aggiungiamo una nuova fuzionalità per la nostra pizzeria: gli ingredienti!


Ogni pizza può avere più ingredienti, e ogni ingrediente può essere collegato a più pizze.


Prevediamo quindi una pagina per mostrare l’elenco di tutti gli ingredienti che utilizziamo nella nostra pizzeria che permetta anche di crearne di nuovi (e di cancellarli).


Nella pagina di creazione (e modifica) della singola pizza dobbiamo dare la possibilità di collegare uno o più ingredienti.

Parte 5
Implementiamo l'accesso alla nostra applicazione anche all’esterno, esponiamo degli endpoint REST!


Implementiamo quindi i metodi CRUD tramite RestController.


Diamo la possibilità di :

ottenere la lista di pizze (dobbiamo anche poterle filtrare per titolo)
leggere i dettagli di una singola pizza
creare una nuova pizza
modificare una pizza esistente
cancellare una pizza