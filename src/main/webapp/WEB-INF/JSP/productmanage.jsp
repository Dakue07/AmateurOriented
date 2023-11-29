<!-- いじるな -->
<HTML><%@ page language="java" pageEncoding="UTF-8"
    contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<!-- ここから下に書いてね -->

<c:forEach var="data" items="${data}">
	${data.rice_id}
	${data.rice_name}
	${data.rice_genre}
	${data.rice_weight}
	${data.rice_made}
	${data.rice_image_path}
	${data.rice_since}
	${data.rice_stock}
	${data.rice_price}
	${data.rice_flag}
</c:forEach>


<!-- いじるな -->
<%@include file="../../assets/template/footer.jsp" %>