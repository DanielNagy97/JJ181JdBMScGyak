xquery version "3.1";

let $gy := fn:doc("ovoda.xml")//gyerek
return update value //nev [.="Benőke"] with "Benedek"