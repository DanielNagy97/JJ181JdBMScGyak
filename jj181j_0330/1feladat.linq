<Query Kind="Statements">
  <Connection>
    <ID>7af37717-65ee-4815-8611-d034bac89f1f</ID>
    <Persist>true</Persist>
    <Driver Assembly="IQDriver" PublicKeyToken="5b59726538a49684">IQDriver.IQDriver</Driver>
    <Provider>Devart.Data.MySql</Provider>
    <CustomCxString>Server=localhost;Database=dbmsc;Uid=root;charset=utf8;</CustomCxString>
    <Server>localhost</Server>
    <Database>dbmsc</Database>
    <UserName>root</UserName>
    <DriverData>
      <StripUnderscores>false</StripUnderscores>
      <QuietenAllCaps>false</QuietenAllCaps>
      <ExtraCxOptions>charset=utf8;</ExtraCxOptions>
    </DriverData>
  </Connection>
</Query>

//1.feladat
var q1 = Customers.Select(c => new { name = c.FullName, age = c.Age}).OrderBy(c => c.age);
q1.Dump();

//2.feladat
var q2 = Customers.Where(c => c.Age > 28).OrderByDescending(c => c.FullName);
q2.Dump();

//3.feladat
var q3 = Products.Where(p => p.Category.Contains("ház"));
q3.Dump();

//4.feladat
var maxPrice = Products.Max(p => p.Price);
var q4 = Products
			.Where(p => p.Price == maxPrice)
			.Select(p => new {productName = p.ProductName, price = p.Price});
q4.Dump();

//5.feladat
var avgPrice = Math.Round((double) Products.Average(p => p.Price));
avgPrice.Dump();
var q5 = Products.Where(p => p.Price < avgPrice);
q5.Dump();

//6.feladat
var q6 = Products.Where(p => p.Category == "divat").Count();
q6.Dump();

//7.feladat
var q7 = Orders
			.Join(Orderproducts, o => o.Id, op => op.OrderId, (o, op) => new {o, op})
			.Join(Products, o_op => o_op.op.ProductId, p => p.Id, (o_op, p) => new {o_op, p})
			.GroupBy(result => result.o_op.o.Id)
			.Select(groups => new {orderId = groups.Key, sum = groups.Select(g => g.p.Price).Aggregate((p1, p2) => (p1+p2))});
q7.Dump();

//8.feladat
var q8 = Customers
			.Join(Orders, c => c.Id, o => o.Customer, (c, o) => new {c, o})
			.Join(Orderproducts, oc => oc.o.Id, op => op.OrderId, (oc, op) => new {oc, op})
			.Join(Products, ocop => ocop.op.ProductId, p => p.Id, (ocop, p) => new {ocop, p})
			.GroupBy(result => result.ocop.oc.c.FullName)
			.Select(groups => new {fullName = groups.Key, count = groups.Count()});
q8.Dump();