xquery version "3.1";

for $d in fn:doc("ovoda.xml")//dolgozo
where $d/szuletesiev = max(//dolgozo/szuletesiev) and $d/beosztas = "óvónő"
return $d/nev