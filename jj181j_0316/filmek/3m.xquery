xquery version "3.1";

(: 
let $doc := fn:doc("mozi.xml")
for $kategoria in distinct-values($doc//film/kategoria)
order by $kategoria
return $kategoria
:)
 
for $kategoria in fn:doc("mozi.xml")//kategoria
group by $kategoria
return $kategoria
