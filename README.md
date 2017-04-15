# Tasky

Tasky je jednostavna aplikacija koja, pomoæu baze podataka, omoguæuje korisniku kreiranje liste zadataka, dodavanje novih zadataka, te brisanje postojeæih. Zadaci se svrstavaju u kategorije, te se odabire prioritet (crveno – visok, žuto – srednji i zeleno – nizak). 

Aplikacije se sastoji od poèetnog zaslona (MainActivity) na kojem se nalazi ListView i jedan Button koji se koristi za dodavanje novih zadataka. Svi dodani elementi pojavljuju se unutar liste na ovom zaslonu, a dugim klikom na neki od njih pojavljuje se dijalog za brisanje zadataka iz baze. Za izradu dijaloga i brisanje korišten je StackOverflow. [http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android, http://stackoverflow.com/questions/7510219/deleting-row-in-sqlite-in-android]
Za korištenje ListViewa kreirana je klasa TaskAdapter za što je korišten predložak s druge laboratorijske vježbe. Unutar te klase, pomoæu ViewHoldera pridružene su boje odreðenim prioritetima koje odabiremo unutar Spinnera. 
Korisnik unosi podatke na zaslonu (NewTaskActivity) koji se sastoji od dva Spinnera gdje se odabiru kategorija i prioritet, te EditText elemenata gdje se unosi naziv i opis zadatka. Ukoliko se ne unese ime zadatka, pojavljuje se Toast poruka, te nije moguæe dodati zadatak. Podaci se predaju po uzoru na LV2, koristeæi putExtra(). 
Baza podataka izraðena je po uzoru na predložak za treæu lab. vježbu. 

Prilikom izrade bilo je manjih problema s bazom podataka i to iskljuèivo zbog sintakse, zarez, razmak, itd. Vrlo je bitno paziti da je sve pravilno napisano, jer u suprotnom aplikacija neæe raditi. Aplikacija je testirana na dva ureðaja.

