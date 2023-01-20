<%@ page import="java.util.List" %>
<%@ page import="encheres.backoffice.models.Categorie" %>
<%@ page import="encheres.backoffice.format.Data" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categorie> list = (List<Categorie>) ((Data) request.getAttribute("categories")).getData();
%>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Categories</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title">Liste des categories</h1>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Libellé</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <% for(Categorie c : list) { %>
                                <tr>
                                    <td><% out.print(c.getLibelle()); %></td>
                                    <td><a href="<%= request.getContextPath() %>/categories/<% out.print(c.getIdCategorie()); %>" class="btn btn-primary float-end">Modifier</a></td>
                                </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card">
                    <a class="btn btn-outline-success" href="<%= request.getContextPath() %>/categories/toForm">Ajouter une nouvelle categorie</a>
                </div>
            </div>
        </div>
    </section>
</main>