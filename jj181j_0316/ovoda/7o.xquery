xquery version "3.1";

let $gy := fn:doc("ovoda.xml")//gyerek[@jel="traktor"]
return update delete $gy