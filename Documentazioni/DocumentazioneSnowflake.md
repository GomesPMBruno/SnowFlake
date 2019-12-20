# Documentazione del Progetto
## Bruno Gomes


1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

2. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

3. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

4. [Implementazione](#implementazione)

5. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

6. [Consuntivo](#consuntivo)

7. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

8. [Sitografia](#sitografia)

9. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

  Progetto per il Modulo 306 del 3° anno di Scuola, nella sezione di Informatica. I nostri 2 docenti per questo modulo, **Luca Muggiasca** e **Geo Petrini**, ci hanno chiesto di creare un programma dove si possa creare dei **Fiocchi di Neve**. Per fare questo si deve scegliere il pattern di un triangolo creando dei poligoni che cancellano parte del triangolo. Il progetto è iniziato il 6/9/2019 e finisce il 20/12/2019.

### Abstract

Il progetto viene richiesto come mezzo di scambiare la vecchia procedura di piegare un foglio diverse volte e dopo tagliare il foglio.

In questo progetto il scopo principale è quello di creare un fiocco di neve. Per realizzare questo si deve tagliare un triangolo utilizando dei poligoni con dei vertici creati dai click del utente.

Dovrò creare 2 sezioni importanti:

  - Il sito con una descrizione del progetto e un tasto di download del programma.

  - Il programma funzionante, con una GUI chiara.

Il progetto viene richiesto in uguale forma a tutti i allievi, dove ognuno decide la forma migliore in cui risolvere/eseguire il progetto.

Il progetto viene suddiviso in diverse attività che insieme portano a buon fine il risultato.

### Scopo

  Lo scopo del progetto (scopi didattici/scopi operativi). Dovrebbe
  descrivere il mandato, ma non vanno ricopiate le informazioni del
  quaderno dei compiti (che va invece allegato).


## Analisi

### Analisi del dominio

  Il prodotto FioccoDiNeve servirà ai utenti di simulare la creazione di un fiocco di neve di carta.
  I principali utenti di questo codice saranno quelli che gli serve la generazione del fiocco, ossia, probabilmente avranno una qualche connessione con l'arte.

### Analisi e specifica dei requisiti

  Per eseguire il progetto, I nostri maestri ci hanno datto delle specifiche che dobbiamo raggiungere.
  Queste specifiche, obbligatorie o meno, sono delle caratteristiche che il progetto deve raggrupare.
  
##### Questo lavoro sarà svolto utilizzando il Linguaggio JAVA, e quindi il progetto ha come requisiti minimi:
  
  - La creazione di un sito con una propria descrizione del software svolto.
  - Deve essere possibile scaricare il software.
  - I tagli del triangolo devono poter essere fatti con il mouse.
  - Deve esserci un'interfaccia grafica.
  - L'area di lavoro deve essere un triangolo.
  - Deve essere possibile resettare i punti registrati.
  - Deve esistere il tasto genera fiocco.
  - Il lavoro deve poter essere salvato.
  - Il salvataggio deve essere fatto in formato PNG o SVG.
  - Il salvataggio deve avere dimensioni definite dall'utente.
  - Deve essere possibile salvare i punti di taglio.
  
##### Come Bonus ci è stato anche proposto di fare:
  - La generazione deve avvenire in tempo reale.
  - I punti devono poter essere spostati o rimossi.



|ID |Requisito |Priorità |Versione |
|---|----------|---------|---------|
|Req-1|Il software deve essere scritto in linguaggio Java o Javascript|1|1.0|
|Req-2|In qualsiasi caso deve esistere un sito con la descrizione del programma|2|1.0|
|Req-2.1|Nel sito si può scaricare il programma|2|1.0|
|Req-3|Si deve utilizzare un'interfaccia grafica (Frame)|1|1.0|
|Req-3.1|La finistra dell'interfaccia è ridimensionabile, minimo 1024x768|1|1.0|
|Req-3.2|All'avvio del programma deve aparire un triangolo da tagliare con dei punti|1|1.0|
|Req-3.2.1|Il triangolo si ridimensiona in base alla grandezza dell'interfaccia (comincia a 50%)|1|1.0|
|Req-3.3|I punti devono essere creati con il mouse|1|1.0|
|Req-3.3.1|Deve essere possibile resettare i punti|1|1.0|
|Req-3.3.2|I punti devono poter essere spostati o rimossi|3|1.0|
|Req-4|Deve esistere un tasto 'genera fiocco'|1|1.0|
|Req-4.1|La generazione del fiocco viene fatta in tempo reale|3|1.0|
|Req-5|Si può salvare il fiocco creato|1|1.0|
|Req-5.1|Questo fiocco può essere salvato in formato PNG o SVG con un bottone|1|1.0|
|Req-5.2|Il salvataggio avrà delle dimensioni definite dall'utente|1|1.0|
|Req-5.3|I punti devono essere salvabili in un file|1|1.0|
|Req-5.4|I punti potranno essere importati tramite esplora file|1|1.0|
|Req-6|È possibile scambiare tra creazione/eliminazione punto tramite un bottone|3|1.0|

### Use case

I casi d’uso rappresentano l’interazione tra i vari attori e le
funzionalità del prodotto.

### Pianificazione

![Gantt](GanttIniziale.png)

### Analisi dei mezzi

#### Software
---

Il software nel PC:

- Sublime Text 3
- ProjectLibre
- GitHub Desktop
- Apache NetBeans IDE 11.1

---

#### Hardware
---

- Asus, Intel Core I3-7020U, RAM 4GB, Intel HD Graphics 620, Windows 10 64 bit

---

## Progettazione

/*Questo capitolo descrive esaustivamente come deve essere realizzato il prodotto fin nei suoi dettagli. Una buona progettazione permette all’esecutore di evitare fraintendimenti e imprecisioni nell’implementazione del prodotto.*/

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni …

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione

Nel mio codice ci sono queste classi:

  - Main: Classe principale. È un JFrame che contiene il JPanel(FioccoPanel) e tutti i tasti necessari per le diverse interazioni con il Triangolo/Fiocco.

  - FioccoPanel: JPanel che contiene il Triangolo da tagliare, dove il utente può inserire dei Punti e così creare il suo prorpio Fiocco personalizzato.

  - Punti: Classe che mi permette di personalizzare direttamente i punti creati dal utente.

  - PuntiListener: È un simplice listener che mi permette di mettere in relazione i Punti al FioccoPanel.

## Test

### Protocollo di test

|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Prova |
|**Riferimento**|REQ-1                               |
|**Descrizione**|Prendere il programma dal mio sito|
|**Prerequisiti**|Internet, Sito e codice funzionante|
|**Procedura**     |Andare al mio sito, prendere il file .rar (contenente programma e librerie) e provare ad aprirlo|
|**Risultati ottenuti** |Il codice si è aperto e ed è pronto al uso|


|Test Case      | TC-002                               |
|---------------|--------------------------------------|
|**Nome**       |Prova |
|**Riferimento**|REQ-3.1                                |
|**Descrizione**|Provare a diminiuire la dimensione della finestra sotto i 1024x768 pixel|
|**Prerequisiti**|Impostare la dimensione minima|
|**Procedura**     |Aprire il programma, provare a diminuire la finestra|
|**Risultati attesi** |Il programma rimane con la minima dimensione possibile|

|Test Case      | TC-003                               |
|---------------|--------------------------------------|
|**Nome**       |Aggiungere punti|
|**Riferimento**|REQ-3.3                            |
|**Descrizione**|Provare ad aggiungere punti su il Panel|
|**Prerequisiti**|Codice che permette di aggiungere punti|
|**Procedura**    |Aprire il programma, cliccare ovvunque su il Panel con il tasto sinistro del mouse|
|**Risultati attesi** |I punti si creano con successo|

|Test Case      | TC-003                               |
|---------------|--------------------------------------|
|**Nome**       |Togliere e spostare punti|
|**Riferimento**|REQ-3.3.2                               |
|**Descrizione**|Provare a togliere e spostare i punti dal Panel|
|**Prerequisiti**|Codice che permette di togliere e spostare punti|
|**Procedura**    |Aprire il programma, cliccare su un qualsiasi Punto con il tasto destro del mouse. Per spostarlo, premere con il tasto sinistro nel Punto e trascinare il mouse mentre se lo preme|
|**Risultati attesi** |I punti si togliono e si spostano con successo|





### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo
Ultimo Gantt che verifica il progresso delle attività

![Gantt](GanttFinale.png)

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Sicuramente sarebbe conveniente aggiungere tutti i punti che non sono riuscito ad arrivare.

- La corretta ridimenione dei punti
- Il salvataggio corretto del PNG

### Considerazioni personali
  Questo progetto è stato veramente impegnativo e mi ha fatto rendere conto di quanto importante è gestire il tempo, in modo che si possa fare tutto corretamente.
Avendo utilizzato il Gantt sono potutto verificare il mio progresso in comparassione a quello che avevo pianificatto. Anche se non sono riuscito a fare tutto perfetto, sono contento con il mio risultato finale.

## Sitografia


-  https://www.thinkcalculator.com/planegeometry/triangle3060.php, *30 60 90 Right Triangle*, 08-11-2019.

-  https://docs.oracle.com/javase/7/docs/api/java/util/List.html, *List*, 08-11-2019.

-  https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Area.html, *Area*, 09-11-2019.

-  https://docs.oracle.com/javase/7/docs/api/java/awt/Polygon.html, *Polygon*, 09-11-2019.

-  https://docs.oracle.com/javase/7/docs/api/java/awt/geom/AffineTransform.html, *AffineTransform*, 15-11-2019.

-  https://xmlgraphics.apache.org/batik/using/svg-generator.html, *SVG Generator*, 06-12-2019.

-  http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawanImageandsavetopng.htm, *Draw an Image and save PNG*, 06-12-2019.

## Allegati

- [README](../../../)

- [Diari di Lavoro](Diari)

- [Codice](../Source)

- [JAR](../Source/Dist)

- [Sito](http://samtinfo.ch/i17perbru)

- [QDC](FioccoDiNeve---QdC.pdf)