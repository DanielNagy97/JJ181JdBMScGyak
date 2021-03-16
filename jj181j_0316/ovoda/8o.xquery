xquery version "3.1";

for $gy in fn:doc("ovoda.xml")//gyerek
where $gy/@jel = "napocska"
return
    element {"eredmeny"} {
        attribute {"jel"}{$gy/@jel},
        text{$gy/nev}
    }