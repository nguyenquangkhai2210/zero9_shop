SELECT P.ProID, COUNT(Od.OrderID)
FROM tblProduct P, tblOrderProductDetails O, tblOrder Od
WHERE P.ProID = O.ProID and o.OrderID = Od.OrderID AND MONTH(OD.CreatedTime) = 4
GROUP BY P.ProID
HAVING COUNT(Od.OrderID) >= ALL (
SELECT COUNT(Od.OrderID)
FROM tblProduct P, tblOrderProductDetails O, tblOrder Od
WHERE P.ProID = O.ProID and o.OrderID = Od.OrderID AND MONTH(OD.CreatedTime) = 4
GROUP BY P.ProID
)