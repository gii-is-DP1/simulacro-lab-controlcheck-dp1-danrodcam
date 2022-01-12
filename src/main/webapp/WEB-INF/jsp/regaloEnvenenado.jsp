<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<petclinic:layout pageName="games">

    <div class="regaloEnvenenadoVista">
        <div style="grid-area: area1">
            <h3 id = "ronda"> Ronda:${posicionRonda}/${rondasPartida.size()}</h3>
        </div>
        <div id="cartaCentral" style="grid-area: area2">
            <center><img style="width:35%" src="${round.cartasCentrales.get(0).dirimage}"/></center>
           
        </div>

        <div style="grid-area: area3">
            <center><t>Tu carta:</t><br>
                <img style="width:60%" src="${player.cards.get(0).dirimage}"/></center>
                 <h2><c:out value="cartas acumuladas : ${player.cards.size() }"></c:out></h2>
        </div>

        	
        

        		<c:forEach items="${round.game.player}" var="player1">
        		<c:if test="${player1 != player}">

				<div style="grid-area: area4[0]">

                    <center><img style="width:80%;" src="${player1.cards.get(0).dirimage}"/></center>
        			<c:forEach items="${player1.cards.get(0).figuras}" var="figura">


        		 	<spring:url value="/rondas/{rondaId}/{playerId}/{figuraId}" var="rondaUrl">
                        <spring:param name="figuraId" value="${figura.id}"/>
                        <spring:param name="rondaId" value="${round.id }"/>
                        <spring:param name="playerId" value="${player1.id }"/>
                    </spring:url>


                        <center><a id = "boton" href="${fn:escapeXml(rondaUrl)}" class="btn btn-default">${figura.name }</a></center>


                    </c:forEach>
                    </div>



                </c:if>

        </c:forEach>
        </div>
        
    
</petclinic:layout>