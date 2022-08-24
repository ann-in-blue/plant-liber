package plantLiber;

public class Query {
	
	
	/*
	 *
I)
Devono richiedere l’utilizzo degli operatori aggregati
II)
Devono richiedere l’utilizzo di query annidate (di cui una con almeno tre livelli)
III)
La metà delle query deve anche essere scritta utilizzando le viste
IV)
Devono coinvolgere almeno due tabelle. Ovviamente il vostro progetto può anche
utilizzare altre query oltre a quelle necessarie per soddisfare i requisiti del punto H*/
	
	//Q1: seleziona tutte le piante scoperte da un raccoglitore
	//INPUT: CF raccoglitore
	/* 
	 * raccoglitore, collezione, pianta
	 * in cui 
	 * Raccoglitore.CF = Collezione.raccoglitore
	 * Collezione.idCollezione = Pianta.idColl
	 * 
	 * 
	 * select nomeComune,nomeScientifico
	 * from Pianta as P
	 * where (P.idCampione IN (select idCampione
	 * 								from Collezione as C, Raccoglitore as R
	 * 								where ((R.CF = C.raccoglitore) AND (C.idCollezione = P.idColl))
	 * 								)
	 * 
	 * con le viste
	 * create view 
	 * 
	*/
	//Q2:seleziona tutte le piante officinali che sono anche angiosperme
	/*
	 * cioè tali che PiantaOfficinale.idCampione = 
	 * select P.nomeComune, P.nomeScientifico
	 * from Pianta as P
	 * where (P.idCampione IN (select po.idCampione
	 * 							from PiantaOfficinale as po
	 * 							where (po.idCampione IN (select idCampione
	 * 														from Angiosperme as a
	 * 															)
	 * 											)
	 * 							)
	 * */
	
	//Q3: selezionare le piante officinali che hanno un determinato utilizzo (dato in input)
	
	/*
	 * String uti;
	 * select * from PianteOfficinali as po join 
	 * where 
	 * 
	 * */
	
	//Q4: selezionare la collezione con il maggior numero di piante presenti
	

	
	
	//Q6: lista di piante in un dato stato
	
    //Q7: lista piante per habitat
    //Q8: ricerca semplice per nome (informazioni base e caratteristiche)
    //Q9: ricerca avanzata per nome: compresa la classificazione
	
    //Q10: ricerca piante per collezione
    
    // Q11: ricerca piante per famiglia
    
   //lista delle varie collezioni con il numero di piante in esse raccolte (aggreg.)
    //Q12: lista  collezioni in cui sono raccolte tutte le piante della stessa città (più livelli?!)

}
