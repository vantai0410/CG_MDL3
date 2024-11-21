<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="discount" method="post" >
    ListPrice <input type="number" name="listPrice">
    DiscountPercent <input type="number" name="discountPercent">
    <button type="submit">Calculate Discount</button>
</form>
<p>Discount Amount Result: ${discountAmount}</p>
<p>Discount Price Result: ${discountPrice}</p>

</body>
</html>