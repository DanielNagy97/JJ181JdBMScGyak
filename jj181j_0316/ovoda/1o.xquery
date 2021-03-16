xquery version "3.1";

for $d in fn:doc("ovoda.xml")//dolgozo
where $d/beosztas="óvónő"
order by $d/nev
return $d
