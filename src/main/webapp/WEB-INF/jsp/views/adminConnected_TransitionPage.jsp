<%@ page import="encheres.backoffice.models.AdminToken" %>
<%@ page import="encheres.backoffice.format.Data" %>
<%
    AdminToken token = (AdminToken) ((Data) request.getAttribute("data")).getData();
%>
<script>
    window.addEventListener("load", () => {
        const token = "<%= token.getToken() %>";
        localStorage.setItem("token", token);
        location.href = "/admins/accueil";
    });
</script>