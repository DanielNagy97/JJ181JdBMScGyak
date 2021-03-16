xquery version "3.1";

for $cs in fn:doc("ovoda.xml")//csoport
where $cs/@nev="süni"
return $cs/gyerek/nev