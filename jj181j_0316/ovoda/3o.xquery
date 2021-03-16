xquery version "3.1";

for $d in fn:doc("ovoda.xml")//dolgozo
where $d/szuletesiev = min(//szuletesiev) and $d/beosztas = "dadus"
return $d/nev