# Tasky

Tasky je jednostavna aplikacija koja, pomo�u baze podataka, omogu�uje korisniku kreiranje liste zadataka, dodavanje novih zadataka, te brisanje postoje�ih. Zadaci se svrstavaju u kategorije, te se odabire prioritet (crveno � visok, �uto � srednji i zeleno � nizak). 

Aplikacije se sastoji od po�etnog zaslona (MainActivity) na kojem se nalazi ListView i jedan Button koji se koristi za dodavanje novih zadataka. Svi dodani elementi pojavljuju se unutar liste na ovom zaslonu, a dugim klikom na neki od njih pojavljuje se dijalog za brisanje zadataka iz baze. Za izradu dijaloga i brisanje kori�ten je StackOverflow. [http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android, http://stackoverflow.com/questions/7510219/deleting-row-in-sqlite-in-android]
Za kori�tenje ListViewa kreirana je klasa TaskAdapter za �to je kori�ten predlo�ak s druge laboratorijske vje�be. Unutar te klase, pomo�u ViewHoldera pridru�ene su boje odre�enim prioritetima koje odabiremo unutar Spinnera. 
Korisnik unosi podatke na zaslonu (NewTaskActivity) koji se sastoji od dva Spinnera gdje se odabiru kategorija i prioritet, te EditText elemenata gdje se unosi naziv i opis zadatka. Ukoliko se ne unese ime zadatka, pojavljuje se Toast poruka, te nije mogu�e dodati zadatak. Podaci se predaju po uzoru na LV2, koriste�i putExtra(). 
Baza podataka izra�ena je po uzoru na predlo�ak za tre�u lab. vje�bu. 

Prilikom izrade bilo je manjih problema s bazom podataka i to isklju�ivo zbog sintakse, zarez, razmak, itd. Vrlo je bitno paziti da je sve pravilno napisano, jer u suprotnom aplikacija ne�e raditi. Aplikacija je testirana na dva ure�aja.

